package com.imhere.controller;

import java.io.OutputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imhere.qr.QRCreator;

@RestController
public class QRCodeController {

	@ResponseBody
	@RequestMapping(value = "/qr", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public void getQR(OutputStream outputStream) throws Exception {
		long time = System.currentTimeMillis();
		String content = "http://localhost:8080/iamhere/login?timestamp="+time;
		QRCreator.generateQRCode(125, 125, content, outputStream);;
		outputStream.flush();
	}
}