package fi.amiedu.realestateproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.service.ApartmentService;

//http://localhost:8080/apartments
//http://localhost:8080/apartments/{city}

@RestController
public class ApartmentController {

	@Autowired // Using services
	private ApartmentService apartmentService;

	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartments", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Apartment> getApartments() {
		apartmentService.getApartments();
		return apartmentService.apartmentMap;
	}
	
//	@RequestMapping(method = RequestMethod.GET, // HTTP GET
//			value = "/apartments/{city}", 
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Apartment> getCityApartments() {
//		apartmentService.getCityApartments();
//		return apartmentService.apartmentMap;
//	}
	
	//Not working
	@RequestMapping(method = RequestMethod.POST, value = "/apartments")
	public void addApartment(Apartment apartment) {
		apartmentService.addApartment(apartment);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/apartments")
	public void deleteApartment(Address address) {
		apartmentService.deleteApartment(address);
	}
	

//	@RequestMapping(method = RequestMethod.GET, // HTTP GET
//			value = "/apartments", 
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Apartment> getCityApartments() {
//		apartmentService.getApartments();
//		return apartmentService.apartmentMap;
//	}
	
	// public Address(/*Property property,*/ String streetAddress/*, String houseNumber, String doorNumber*/,
	// String city, String zipCode, String country, Point coordinates)

//	@RequestMapping(method = RequestMethod.GET, // HTTP GET
//			value = "/apartments", // consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<Apartment,Address> getAddresses() {
//		return apartmentService.getApartments();
//	}
	
//	@RequestMapping(method = RequestMethod.GET, // HTTP GET
//			value = "/apartments", // consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<Apartment,Address> getAddresses() {
//		return apartmentService.getAddresses();
//	}

}
