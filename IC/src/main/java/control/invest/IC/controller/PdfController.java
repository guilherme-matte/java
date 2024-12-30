package control.invest.IC.controller;

import control.invest.IC.models.IrpfModel;
import control.invest.IC.services.ImageToTextService;
import control.invest.IC.services.IrpfService;
import control.invest.IC.services.PdfToImageService;
import control.invest.IC.services.StringExtractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PdfController {
    private final PdfToImageService pdfToImageService;
    private final ImageToTextService imageToTextService;


    public PdfController(PdfToImageService pdfToImageService, ImageToTextService imageToTextService) {
        this.pdfToImageService = pdfToImageService;
        this.imageToTextService = imageToTextService;
    }

    @PostMapping("/irpf/extract-pdf")
    public ResponseEntity<Map<String, Object>> extractPdf(@RequestPart("file") MultipartFile file) {
        IrpfModel irpfModel = new IrpfModel();
        IrpfService irpfService = new IrpfService();
        try {
            File tempPdf = File.createTempFile("uploaded", ".pdf");
            file.transferTo(tempPdf);
            Rectangle regionValores = new Rectangle(510, 230, 70, 450);
            List<File> imageFilesValores = pdfToImageService.convertPdfToImages(tempPdf, regionValores,"valores");
            Rectangle regionCabecalho = new Rectangle(30, 125, 420, 80);
            List<File> imageFilesCabecalho = pdfToImageService.convertPdfToImages(tempPdf,regionCabecalho,"cabecalho");
            Rectangle regionPagamentos = new Rectangle(15, 655, 520, 100);
            List<File> imageFilespagamentos = pdfToImageService.convertPdfToImages(tempPdf,regionPagamentos,"pagamentos");
            String extractedText = imageToTextService.extractTextFromImages(imageFilesValores);

            tempPdf.delete();
            StringExtractService stringExtractService = new StringExtractService();

            irpfModel = stringExtractService.extrairValores(extractedText);

            if (irpfModel != null) {

                Map<String, Object> rendimentos = new HashMap<>();
                rendimentos.put("rendimentosTotais", irpfModel.getRendimentosTotais());
                rendimentos.put("prevSocial", irpfModel.getPrevSocial());
                rendimentos.put("impostoRetido", irpfModel.getImpostoRetido());
                rendimentos.put("decTercSal", irpfModel.getDecTercSal());
                rendimentos.put("impRendDecTerc", irpfModel.getImpRendDecTerc());

                Map<String, Object> deducoes = new HashMap<>();
                deducoes.put("pensao", irpfModel.getPensao());
                deducoes.put("cnpjPagDedutivel", irpfModel.getCnpjEmpresaPagDedutivel());
                deducoes.put("nomeEmpresaPagDedutivel", irpfModel.getValorEmpresaPagDedutivel());
                deducoes.put("valorEmpresaPagDedutivel", irpfModel.getValorEmpresaPagDedutivel());

                Map<String, Object> response = new HashMap<>();
                response.put("cpf", irpfModel.getCpf());
                response.put("nomePessoaFisica", irpfModel.getNomePessoaFisica());
                response.put("fontePagadora", irpfModel.getFontePagadoraNomeEmpresa());
                response.put("rendimentos", rendimentos);
                response.put("deducoes", deducoes);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            }


        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
