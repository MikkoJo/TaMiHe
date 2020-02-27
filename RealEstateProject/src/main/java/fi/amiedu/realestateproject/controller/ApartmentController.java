package fi.amiedu.realestateproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fi.amiedu.realestateproject.domain.Property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.service.ApartmentService;

//http://localhost:8080/apartments
//http://localhost:8080/apartments/{city}
//http://localhost:8080/apartments/country/{country}

@RestController
@CrossOrigin
public class ApartmentController {
	 private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);

	@Autowired // Using services and //http://localhost:8080/apartments
	private ApartmentService apartmentService;

	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/init") 
	public void initApartments() {
		try {
			apartmentService.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartment", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	//@CrossOrigin
	public List< Property> getAllProperties(@RequestParam(required = false) String address) {
		List<Property> properties;
		if(address == null) {
			properties = apartmentService.getAllProperties();
		}
		else {
			properties = apartmentService.searchByAddress(address);
		}
		return properties;
	}
	
	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartment/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Property getProperty(@PathVariable Integer id) {
		System.out.println(id);
		Property property= apartmentService.getProperty(id);
		return property;
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/apartment",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void addApartment(@RequestBody Apartment apartment) {
		apartmentService.addApartment(apartment);
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/apartmentpic/{id}",
			consumes = {"multipart/form-data"},
			produces = MediaType.APPLICATION_JSON_VALUE
			)
		public boolean addApartmentPic(@PathVariable Integer id,
		        @RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file) {
		return apartmentService.addApartmentPic(id, file);
	}

	@RequestMapping(
			method = RequestMethod.POST,
			value = "/apartmentpic",
			consumes = {"multipart/form-data"},
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public boolean addApartmentPic(@RequestPart("apartment") @Valid String apartment,
	        @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
		ObjectMapper obj=new ObjectMapper();
		Apartment apart;
		try {
			apart = obj.readValue(apartment, Apartment.class);
			return apartmentService.addApartmentWithPic(apart, file);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/apartment/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public void updateProperty(@PathVariable Integer id, @RequestBody Apartment apartment) {
		apartmentService.updateApartment(id, apartment);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/apartment/{id}"
			)
	public void removeProperty(@PathVariable Integer id) {
		apartmentService.removeProperty(id);
	}
	
}
