package control.invest.IC.services;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfToImageService {
    public List<File> convertPdfToImages(File pdfFile) throws IOException {
        List<File> imageFile = new ArrayList<>();

        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            int pageCount = document.getNumberOfPages();

            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(i, 700);
                File tempImage = File.createTempFile("page_" + i, ".png");
                ImageIO.write(image, "png", tempImage);
                imageFile.add(tempImage);

            }
        }
        return imageFile;
    }
}
