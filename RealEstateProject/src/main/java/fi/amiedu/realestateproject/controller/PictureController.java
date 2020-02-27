package fi.amiedu.realestateproject.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.amiedu.realestateproject.service.PictureService;

@org.springframework.stereotype.Controller
public class PictureController {

	@Autowired
	private PictureService picService;
	
	private ResponseEntity<byte[]> responseEntity;
	
	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/picture/{id}", 
			produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<byte[]> getPicture(@PathVariable Integer id)  {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	    
	    byte[] pic = picService.getPicture(id);
	    HttpStatus httpStatus;
	    if(pic != null) {
	    	httpStatus = HttpStatus.OK;
	    	headers.setContentType(
	    			MediaType.parseMediaType(picService.getContentType(id)));
	    }
	    else {
	    	httpStatus = HttpStatus.NOT_FOUND;
	    }
	    	responseEntity = 
	    			new ResponseEntity<>(pic, headers, httpStatus);
	    return responseEntity;
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/picture/{apartmentId}",
			consumes = {"multipart/form-data"},
			produces = MediaType.APPLICATION_JSON_VALUE
			)
		public ResponseEntity<HttpStatus> addPicToApartment(@PathVariable Integer apartmentId,
		        @RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file) {
		boolean result = picService.addPicToApartment(apartmentId, file);
		if(result) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/picture/{apartmentId}/{id}",
			consumes = {"multipart/form-data"})
	public ResponseEntity<HttpStatus> updatePicture(@PathVariable Integer apartmentId, 
			@PathVariable Integer id,
			@RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file) {
		boolean result = picService.updatePicture(apartmentId, id, file);
		if(result) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/picture/{apartmentId}/{id}")
	public ResponseEntity<HttpStatus> deletePicture(@PathVariable Integer apartmentId, 
			@PathVariable Integer id) {
		boolean result = picService.deletePicture(apartmentId, id);
		if(result) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
