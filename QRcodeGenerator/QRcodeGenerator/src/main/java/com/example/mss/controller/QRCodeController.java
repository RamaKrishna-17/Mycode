package com.example.mss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mss.generator.QRCodeGenerator;

@RestController
public class QRCodeController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
	
	
	@GetMapping(value="/generateAndDownloadQRCode")
	public void download(@RequestParam String crop,@RequestParam String farmerName,@RequestParam String customerName,@RequestParam String transporterName,@RequestParam Integer width,@RequestParam Integer height)throws Exception
	{
		
		QRCodeGenerator.generateQRCodeImage(crop,farmerName,customerName,transporterName, width, height, QR_CODE_IMAGE_PATH);
		
	}
	
	 @GetMapping(value="/generateQRCode")
	public ResponseEntity<Object> generateQRCode(@RequestParam String crop,@RequestParam String farmerName,@RequestParam String customerName,@RequestParam String transporterName,@RequestParam Integer width,@RequestParam Integer height)throws Exception
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(transporterName, width, height,crop,farmerName,customerName));
	}
	
}
