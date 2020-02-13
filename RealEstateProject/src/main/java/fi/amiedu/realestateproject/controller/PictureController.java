package fi.amiedu.realestateproject.controller;

//import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.amiedu.realestateproject.service.PictureService;

@org.springframework.stereotype.Controller
public class PictureController {

	@Autowired
	private PictureService picService;
	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/picture/{id}", 
			produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<byte[]> getPicture(@PathVariable Integer id)  {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	     
	    ResponseEntity<byte[]> responseEntity = 
	    		new ResponseEntity<>(picService.getPicture(id), headers, HttpStatus.OK);
	    return responseEntity;
	}
}