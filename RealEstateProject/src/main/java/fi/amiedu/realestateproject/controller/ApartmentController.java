package fi.amiedu.realestateproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.service.ApartmentService;

//import fi.amiedu.realestateproject.service.ApartmentService;

//http://localhost:8080/apartments

@RestController
public class ApartmentController {

	@Autowired // Using services
	private ApartmentService apartmentService;

	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartments", // consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<Apartment,Address> getAddresses() {
		return apartmentService.getApartments();
	}
	
//	@RequestMapping(method = RequestMethod.GET, // HTTP GET
//			value = "/apartments", // consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<Apartment,Address> getAddresses() {
//		return apartmentService.getAddresses();
//	}

}
