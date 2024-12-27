package control.invest.IC.controller;

import control.invest.IC.services.ImageToTextService;
import control.invest.IC.services.PdfToImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PdfController {
    @Autowired
    private final PdfToImageService pdfToImageService;
    private final ImageToTextService imageToTextService;


    public PdfController(PdfToImageService pdfToImageService, ImageToTextService imageToTextService) {
        this.pdfToImageService = pdfToImageService;
        this.imageToTextService = imageToTextService;
    }

    @PostMapping("/irpf/extract-pdf")
    public ResponseEntity<String> extractPdf(@RequestPart("file") MultipartFile file) {
        try {
            File tempPdf = File.createTempFile("uploaded", ".pdf");
            file.transferTo(tempPdf);

            List<File> imageFiles = pdfToImageService.convertPdfToImages(tempPdf);
            String extractedText = imageToTextService.extractTextFromImages(imageFiles);

            tempPdf.delete();
            return ResponseEntity.ok(extractedText);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar arquivo");
        }
    }
}
