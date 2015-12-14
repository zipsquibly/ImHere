package com.imhere.qr;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCreator {

	private static final String IMAGE_FORMAT = "png";

	public static void generateQRCode(int width, int height, String content,
			OutputStream outputStream) throws Exception {

		try {
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(content,
					BarcodeFormat.QR_CODE, width, height, hintMap);
			
			int qrWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(qrWidth,
					qrWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, qrWidth, qrWidth);
			graphics.setColor(Color.BLACK);

			for (int i = 0; i < qrWidth; i++) {
				for (int j = 0; j < qrWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, IMAGE_FORMAT, outputStream);
			
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
	}

}
