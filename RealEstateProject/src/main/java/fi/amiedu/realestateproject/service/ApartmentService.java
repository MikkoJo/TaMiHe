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
	// Map<Apartment> apartmentMap = new HashMap();

	public Map Addresses() {
		Address add1 = new Address("Peräjänkuja", "Vantaa", "01760", "Suomi", new Point(1, 21));
		Address add2 = new Address("Reunatie 81", "Vantaa", "01790", "Suomi", new Point(22, 36));
		Address add3 = new Address("Vaisalantie 3B", "Vantaa", "01210", "Suomi", new Point(34, 46));
		Address add4 = new Address("Kielokuja 7", "Espoo", "01810", "Suomi", new Point(44, 68));
		Address add5 = new Address("Nurenkuru", "Rundu", "9871", "Namibia", new Point(244, 368));
		Address add6 = new Address("Mäkitie 6 A12", "Nurmijärvi", "01870", "Suomi", new Point(4, 6));
		Address add7 = new Address("Hiomotie 8 B5", "Helsinki", "00210", "Suomi", null);
		Apartment apa1 = new Apartment(add1, 160000, 170000.0d, "Omakotitalo", 2, 2, false, true);
		Apartment apa2 = new Apartment(add2, 250000, 2100, "Omakotitalo", 5, 1, false, true);
		Apartment apa3 = new Apartment(add3, 65000, 800.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa4 = new Apartment(add4, 200000, 7000.0d, "Rivitalo", 2, 1, false, true);
		Apartment apa5 = new Apartment(add5, 10000, 17000.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa6 = new Apartment(add6, 310000, 17000.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa7 = new Apartment(add7, 2000000, 170000.0d, "Kerrostalo", 5, 5, true, true);
		
		Map<Apartment, Address> apartmentMap = new HashMap();
		apartmentMap.put(apa1, add1);
		apartmentMap.put(apa2, add2);
		apartmentMap.put(apa3, add3);
		apartmentMap.put(apa4, add4);
		apartmentMap.put(apa5, add5);
		apartmentMap.put(apa6, add6);
		apartmentMap.put(apa7, add7);
		return apartmentMap;
	}

//public Apartment addApartment(Apartment apartment) {
//		return newApartment;
//}

}
