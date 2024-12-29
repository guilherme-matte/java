package control.invest.IC.services;

import control.invest.IC.models.IrpfModel;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringExtractService {

    //private IrpfModel irpfModel;

    private String extractValue(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public String extractCpf(String Text) {
        return extractValue(Text, "\\s*(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\s+(.+)");
    }

    public String extractCnpj(String Text) {
        return extractValue(Text, "\\s*(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})\\s+(.+)");
    }

    public String extractValor(String Text) {
        // Regex para capturar o texto e valor
        String regex = "\\s*(\\D+?)\\s*(\\d{1,3}(?:\\.\\d{3})*,\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Text);

        while (matcher.find()) {
            // Extrair o texto e o valor
            String texto = matcher.group(1);
            String valor = matcher.group(2);

            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");


            try {
                Double number = Double.parseDouble(valor);

                // Verifica se o número é diferente de 0.00
                if (number != 0.00) {
                    return texto + " " + number;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public IrpfModel extrairValores(String text) {
        try {
            IrpfModel irpfModel = new IrpfModel();
            String[] lines = text.split("\\n");
            int num = 1;
            boolean fp = false;//verifica se a fonte pagadora ja foi armazenada

            for (String line : lines) {

                //System.out.println(line);
                if (extractCnpj(line) != null) {
                    String regex = "\\s*(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})\\s+(.+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);


                    if (matcher.find()) {
                        if (fp == false) {
                            irpfModel.setFontePagadoraCnpj(matcher.group(1));
                            irpfModel.setFontePagadoraNomeEmpresa(matcher.group(2));
                            fp = true;
                        } else {
                            irpfModel.setCnpjEmpresaPagDedutivel(matcher.group(1));
                            irpfModel.setNomeEmpresaPagDedutivel(matcher.group(2).replace("-", "").trim());

                        }
                    }


                }
                if (extractCpf(line) != null) {
                    String regex = "\\s*(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\s+(.+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        irpfModel.setCpf(matcher.group(1));
                        irpfModel.setNomePessoaFisica(matcher.group(2));
                    }

                }
                if (extractValor(line) != null) {
                    String regex = "\\s*(\\D+?)\\s*(\\d{1,3}(?:\\.\\d{3})*,\\d{2})";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String op = matcher.group(1).replace(".", "").trim();
                        System.out.println(op);
                        System.out.println(matcher.group(2));
                        if (Objects.equals(op, "Total dos rendimentos (inclusive férias)")) {
                            irpfModel.setRendimentosTotais(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }
                        if (Objects.equals(op, "Contribuição previdenciária oficial")) {
                            irpfModel.setPrevSocial(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }
                        if (Objects.equals(op, "Imposto sobre a renda retido na fonte")) {
                            irpfModel.setImpostoRetido(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }
                        if (Objects.equals(op, "Décimo terceiro salário")) {
                            irpfModel.setDecTercSal(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }
                        if (Objects.equals(op, "º salário")) {
                            irpfModel.setImpRendDecTerc(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }
                        if (Objects.equals(op, "Valor pago no ano referente ao titular: R$")) {
                            irpfModel.setValorEmpresaPagDedutivel(Double.parseDouble(matcher.group(2).replace(".", "").replace(",", ".")));
                        }

                        //Criar outros depois
                    }
                }

                num += 1;
            }
            return irpfModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
