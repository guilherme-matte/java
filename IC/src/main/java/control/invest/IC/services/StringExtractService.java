package control.invest.IC.services;

import control.invest.IC.models.IrpfModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
        String regex = "(\\d{1,3}(?:\\.\\d{3})*,\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Text);

        if (matcher.find()) {
            // Extrair o texto e o valor
            String valor = matcher.group();

            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");


            try {
                //Double number = Double.parseDouble(valor);
                return matcher.group();
                // Verifica se o número é diferente de 0.00

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

            String regex = "(\\d{1,3}(?:\\.\\d{3})*,\\d{2})";
            Pattern pattern = Pattern.compile(regex);

            List<Double> extractedValues = new ArrayList<>();


            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    double value = Double.parseDouble(matcher.group().replace(".", "").replace(",", "."));

                    extractedValues.add(value);


                }
            }

            Field[] fields = IrpfModel.class.getDeclaredFields();
            int index = 0;

            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType().equals(double.class) && index < extractedValues.size()) {
                    field.set(irpfModel, extractedValues.get(index));
                    index++;
                }
            }

            return irpfModel;
            
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
