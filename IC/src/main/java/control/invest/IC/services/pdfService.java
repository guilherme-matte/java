package control.invest.IC.services;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class pdfService {
    public String extractTextFromPdf(String pdfPath) throws IOException{
        File pdfFile = new File(pdfPath);

        try (PDDocument document = PDDocument.load(pdfFile)){
            if (document.isEncrypted()){
                throw new IllegalArgumentException("PDF inacessível");
            }

        }
    }
}
