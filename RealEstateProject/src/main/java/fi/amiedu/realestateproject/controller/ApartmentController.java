package fi.amiedu.realestateproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//http://localhost:8080/apartments/country/{country}

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
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "/apartments/country/{country}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List< Apartment> getCountryApartments(@PathVariable String country) {
		apartmentService.getApartments();
		return apartmentService.getCountryApartments(country);
	}
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "/apartments/{city}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List< Apartment> getCityApartments( @PathVariable String city) {
		apartmentService.getApartments();
		return apartmentService.getCityApartments( city);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/apartments"
			)
	public void updateApartment(@RequestBody Apartment apartment) {
		apartmentService.getApartments();
		apartmentService.updateApartment(apartment);
	}
	
	//http://localhost:8080/apartments
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/apartments"
			)
	public void addApartment(@RequestBody Apartment apartment) {
		apartmentService.getApartments();
		apartmentService.addApartment(apartment);
	}
	
//	@RequestMapping(
//			method = RequestMethod.POST,
//			value = "/apartments"
//			)
//	public void addApartments(@RequestBody HashMap<Address, Apartment> apartmentHashMap) {
//		apartmentService.getApartments();
//		Set<Address>keySet = apartmentHashMap.keySet();
//		for (Address add: keySet) {
//			//apartment = apartmentHashMap.get(iterator.next());
//			Apartment apartment = apartmentHashMap.get(add);
//			apartmentService.addApartment(apartment);
//		}
//	//	apartmentService.addApartments(apartmentHashMap);
//	}

	
	@RequestMapping(method = RequestMethod.DELETE, 
			value = "/apartments",     
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteApartment(@RequestBody Apartment apartment) {
		apartmentService.getApartments();
		apartmentService.deleteApartment(apartment.getAddress());
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, 
//			value = "/apartments",     
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public void deleteApartments(HashMap<Address, Apartment> apartmentHashMap) {
//		apartmentService.getApartments();
//		Set<Address>keySet = apartmentHashMap.keySet();
//		for (Address key: keySet){
////			Apartment apartmentValue = apartmentHashMap.get(key);
////			apartmentService.deleteApartment(apartmentValue.getAddress());
//			apartmentService.deleteApartment(key);
//	}
//	}
		
//	@RequestMapping(method = RequestMethod.DELETE, 
//			value = "/apartments",     
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public void deleteApartments(HashMap<Address, Apartment> apartmentHashMap) {
//		Set<Address>keySet = apartmentHashMap.keySet();
//		for (Address key: keySet){
//			Apartment apartmentValue = apartmentHashMap.get(key);
//			deleteApartment(apartmentValue.getAddress());
//		}
//	}

}
