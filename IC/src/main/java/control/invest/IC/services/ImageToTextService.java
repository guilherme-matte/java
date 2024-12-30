package control.invest.IC.services;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ImageToTextService {
    public String extractTextFromImages(List<File> imageFiles) {
        StringBuilder extractedText = new StringBuilder();
        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("por");

        for (File imageFile : imageFiles) {
            try {
                String text = tesseract.doOCR(imageFile);
                extractedText.append(text).append("|");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //imageFile.delete();
            }
        }
        return extractedText.toString();
    }
}
