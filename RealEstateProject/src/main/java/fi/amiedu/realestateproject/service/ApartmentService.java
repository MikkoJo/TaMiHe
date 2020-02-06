package fi.amiedu.realestateproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.controller.ApartmentController;
import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.domain.Property;
import fi.amiedu.realestateproject.repository.PropertyRepository;
import fi.amiedu.realestateproject.util.Point;

@Component
public class ApartmentService {
	private static final Logger logger = LoggerFactory.getLogger(ApartmentService.class);
	// Create a list of apartments
	
//	@Autowired
//	private PropertyRepository repo;
//	
//	public List<Apartment> getApartments() {
//		List<Apartment> apartments = new ArrayList<>();
//		Iterable<Property> allApartments = repo.findAll();//findByAddressStreetAddressContaining(apartmentMap.g.getAddress().getStreetAddress());
//
//		for (Property apa: allApartments) {
//		apartments.add(apa);
//		}
//		return apartments;
//		}

	private HashMap<Address, Apartment> apartmentMap = new HashMap<Address, Apartment>();
	private ArrayList<Apartment> apartments = new ArrayList<Apartment>();

//		public HashMap<Address, Apartment> getApartments() {
//		//Map<Integer, Apartment> apartmentMap = new HashMap();
//		apartments.put(apa1);
//		apartments.put(apa2);
//		apartments.put(apa3);
//		apartments.put(apa4);
//		apartments.put(apa5);
//		apartments.put(apa6);
//		apartments.put(apa7);
//		return apartments;
//	}

	public HashMap<Address, Apartment> getAddressApartments() {
		// Map<Integer, Apartment> apartmentMap = new HashMap();
		Address add1 = new Address("Peräjänkuja", "Vantaa", "01760", "Suomi", new Point(1, 21));
		Address add2 = new Address("Reunatie 81", "Vantaa", "01790", "Suomi", new Point(22, 36));
		Address add3 = new Address("Vaisalantie 3B", "Vantaa", "01210", "Suomi", new Point(34, 46));
		Address add4 = new Address("Kielokuja 7", "Espoo", "01810", "Suomi", new Point(44, 68));
		Address add5 = new Address("Nurenkuru", "Rundu", "9871", "Namibia", new Point(244, 368));
		Address add6 = new Address("Mäkitie 6 A12", "Nurmijärvi", "01870", "Suomi", new Point(4, 6));
		Address add7 = new Address("Hiomotie 8 B5", "Helsinki", "00210", "Suomi", null);
		Apartment apa1 = new Apartment(add1, 160000, 170000.0d, "Omakotitalo", 2, 2, false, true);
		Apartment apa2 = new Apartment(add2, 250000, 2100, "Omakotitalo", 1, 5, false, true);
		Apartment apa3 = new Apartment(add3, 65000, 800.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa4 = new Apartment(add4, 200000, 7000.0d, "Rivitalo", 1, 2, false, true);
		Apartment apa5 = new Apartment(add5, 10000, 17000.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa6 = new Apartment(add6, 310000, 17000.0d, "Omakotitalo", 1, 1, false, true);
		Apartment apa7 = new Apartment(add7, 2000000, 170000.0d, "Kerrostalo", 5, 5, true, true);
		apartmentMap.put(apa1.getAddress(), apa1);
		apartmentMap.put(apa2.getAddress(), apa2);
		apartmentMap.put(apa3.getAddress(), apa3);
		apartmentMap.put(apa4.getAddress(), apa4);
		apartmentMap.put(apa5.getAddress(), apa5);
		apartmentMap.put(apa6.getAddress(), apa6);
		apartmentMap.put(apa7.getAddress(), apa7);
		return apartmentMap;
	}

	public List<Apartment> getApartments() {
		 if (apartments.size() == 0)    //If all apartments are distroyed?
			 getAddressApartments();
		Iterator<Address> iterator = apartmentMap.keySet().iterator();
		if(apartments.size() == 0)
		{while (iterator.hasNext()) {
			Apartment apartment = apartmentMap.get(iterator.next());
			apartments.add(apartment);
		}}
		String size = "" + apartments.size();
		logger.info(size);
		return apartments;
	}
	
	
	public List<Apartment> getCityApartments(String city) {
//		 if (apartments.size() == 0)    //If all apartments are distroyed?
//			 getAddressApartments();
		Apartment apartment = null;
		ArrayList<Apartment> cityList = new ArrayList<Apartment>();
		for (Apartment apa : apartments)
		{
			apartment = apa;
			if ((apa.getAddress()).getCity().equals(city)) {
				cityList.add(apa);
			}
		}
		logger.info("" + cityList.size());
		return cityList;
	}

//		public HashMap<String, Apartment> getApartments() {
//		//Map<Integer, Apartment> apartmentMap = new HashMap();
//		apartmentMap.put(apa1.getAddress().getCity(), apa1);
//		apartmentMap.put(apa2.getAddress().getCity(), apa2);
//		apartmentMap.put(apa3.getAddress().getCity(), apa3);
//		apartmentMap.put(apa4.getAddress().getCity(), apa4);
//		apartmentMap.put(apa5.getAddress().getCity(), apa5);
//		apartmentMap.put(apa6.getAddress().getCity(), apa6);
//		apartmentMap.put(apa7.getAddress().getCity(), apa7);
//		return apartmentMap;
//	}

//		public List<String> getCityApartments(String city){
//			List<String> cityList = new ArrayList<String>();
//			Iterator<String> iterator = apartmentMap.keySet().iterator();
//			while(iterator.hasNext()){
//				System.out.println(iterator);
//			}
//			//if (city = iterator. = hashMap.get(iterator.next());
//			
//			return cityList;
//		}

	public List<Apartment> addApartment(Apartment apartment) {
		apartments.add(apartment);
		return apartments;
		//apartmentMap.put(apartment.getAddress(), apartment);
	}
//
//	public void deleteApartment(Address address) {
//		Iterator<Address> iterator = apartmentMap.keySet().iterator();
//		while (iterator.hasNext()) {
//			Apartment apartment = apartmentMap.get(iterator.next());
//			if (apartment.getAddress().equals(address)) {
//				apartmentMap.remove(apartment); // not working
//				break;
//			}
//		}
//	}

	public List<Apartment> deleteApartment(Address address) {
//		Iterator<Apartment> iterator = apartments.keySet().iterator();
//		Apartment apartment = null;
		for (Apartment apa : apartments)
		{
			//if (apa.getAddress().equals(address)) {
			if (((apa.getAddress()).getStreetAddress()).equals((address).getStreetAddress())) {          //(apa.getAddress().equals(address))
				apartments.remove(apa); // not working
				break;
			}
		}
		return apartments;
	}

////		public Map getCityApartments() {
//		Map<Apartment, Address> apartmentMap = new HashMap();
//		apartmentMap.put(apa1, add1);
//		apartmentMap.put(apa2, add2);
//		apartmentMap.put(apa3, add3);
//		apartmentMap.put(apa4, add4);
//		apartmentMap.put(apa5, add5);
//		apartmentMap.put(apa6, add6);
//		apartmentMap.put(apa7, add7);
//		return apartmentMap;
//	}

//		public Map getAddresses() {
//		Map<Apartment, Address> addresstMap = new HashMap();
//		addresstMap.put(apa1, add1);
//		addresstMap.put(apa2, add2);
//		addresstMap.put(apa3, add3);
//		addresstMap.put(apa4, add4);
//		addresstMap.put(apa5, add5);
//		addresstMap.put(apa6, add6);
//		addresstMap.put(apa7, add7);
//		return addresstMap;
//	}		

//		public Apartment getApartment(Address address) {
//			Map apas = getAddresses();
//			for (Apartment apa : apas) {
//			if (apa.getAddress().equals(address))
//			return apa;
//			}

//public Apartment addApartment(Apartment apartment) {
//		return newApartment;
//}

}
