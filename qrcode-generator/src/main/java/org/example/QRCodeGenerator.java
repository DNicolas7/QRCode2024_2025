package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class QRCodeGenerator {
    public static void main(String[] args) {
        String data = "Je veux une bonne note";
        String filePath = "qrcode.png";

        try {
            Writer writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 300, 300);

            Path path = Paths.get(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

            System.out.println("QR Code généré : " + filePath);
        } catch (WriterException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
