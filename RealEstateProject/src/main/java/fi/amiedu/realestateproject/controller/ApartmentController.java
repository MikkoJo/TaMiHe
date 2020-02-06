package fi.amiedu.realestateproject.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	 private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);

	@Autowired // Using services and //http://localhost:8080/apartments
	private ApartmentService apartmentService;

	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartments", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List< Apartment> getApartments() {
		List<Apartment> listApartment = apartmentService.getApartments();
		return listApartment;
	}
	
	@RequestMapping(method = RequestMethod.GET, // HTTP GET
			value = "/apartments/{city}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List< Apartment> getCityApartments(@PathVariable String city) {
		return apartmentService.getCityApartments(city);
		
	}
	
	//http://localhost:8080/apartments
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/apartments"
			)
	public void addApartment(@RequestBody Apartment apartment) {
		apartmentService.addApartment(apartment);
//		String size = ""+ apartmentService.apartmentMap.size();
//		logger.info(size);     //logger.info("test");
	}

	
	@RequestMapping(method = RequestMethod.DELETE, // HTTP GET
			value = "/apartments", // consumes = MediaType.APPLICATION_JSON_VALUE,      
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteApartment(@RequestBody Apartment apartment) {                      
		apartmentService.deleteApartment(apartment.getAddress());
	}

}
