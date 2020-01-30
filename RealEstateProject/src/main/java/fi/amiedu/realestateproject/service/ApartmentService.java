package fi.amiedu.realestateproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.util.Point;

@Component
public class ApartmentService {
	// Create a list of apartments
	//Map<Apartment> apartmentMap = new HashMap();
	
	public Map Addresses() {
	Address ad1 = new Address("Mäkitie 6 A12", "Nurmijärvi","01870","Suomi", new Point(4,6));
	Address ad2 = new Address("Hiomotie 8 B5", "Helsinki","00210","Suomi", null);
	Apartment a1 = new Apartment(ad1,"20000",17000.0d,"Omakotitalo",2,2,false,true);
	Apartment a2 = new Apartment(ad2,"20000",51900,"Kerrostalo",5,1,true,true);
	
	Map<Apartment,Address> apartmentMap = new HashMap();
	apartmentMap.put(a1,ad1);
	apartmentMap.put(a2,ad2);
	return apartmentMap;
	}
	
//public Apartment addApartment(Apartment apartment) {
//		return newApartment;
//}

}
