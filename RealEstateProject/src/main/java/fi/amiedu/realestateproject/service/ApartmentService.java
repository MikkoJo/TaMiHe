package fi.amiedu.realestateproject.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.controller.ApartmentController;
import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.domain.Property;
import fi.amiedu.realestateproject.repository.PropertyRepository;
import fi.amiedu.realestateproject.util.Point;

@Component
public class ApartmentService {
	// Logger create to help debugging problems
	private static final Logger logger = LoggerFactory.getLogger(ApartmentService.class);

	// Could not be used properly with method creation of apartmentMap and
	// apartments
	@Autowired
	private PropertyRepository repo;

	// Create a list of apartments
	private HashMap<Address, Apartment> apartmentMap = new HashMap<Address, Apartment>();
	private ArrayList<Apartment> apartments = new ArrayList<Apartment>();
	private boolean startUp = true;
	private InputStream input;
	private InputStream input3;
	private Resource resourc;
	public void init() throws Exception {
		if (startUp) {
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

			repo.save(apa1);
			repo.save(apa2);
			repo.save(apa3);
			repo.save(apa4);
			repo.save(apa5);
			repo.save(apa6);
			repo.save(apa7);
			Resource resource = new ClassPathResource("static/test.jpg");
			Resource resource2 = new ClassPathResource("static/test2.jpg");
			input = resource.getInputStream();
			input3 = resource2.getInputStream();

			apa1.addPicture(new Picture("Test", input.readAllBytes()));
			input.close();
			apa1.addPicture(new Picture("Test2", input3.readAllBytes()));
			input3.close();
			resourc = new ClassPathResource("static/test.jpg");
			InputStream input2 = resourc.getInputStream();
			byte[] image = input2.readAllBytes();
			List<Picture> pics2 = Arrays.asList(new Picture("eka", image));
			apa2.addFloorPlan(pics2.get(0));
//			apa2.setPictures(pics2);
			repo.save(apa1);
//			repo.save(apa2);
			startUp = false;
		}
	}

	public List<Property> getAllProperties() {
		List<Property> allProperties = new ArrayList<>();
		Iterable<Property> propertiesIter = repo.findAll();
		propertiesIter.forEach(allProperties::add);
		return allProperties;
	}

	public Property getProperty(Integer id) {
		Property prop = repo.findById(id).get();
		return prop;
	}

	public void addApartment(Apartment apartment) {
		repo.save(apartment);
	}

	public void updateApartment(Integer id, Apartment apartment) {
		Optional<Property> found = repo.findById(id);
		if (found.isPresent()) {
			repo.save(apartment);
		}

	}

	public void removeProperty(Integer id) {
		Optional<Property> found = repo.findById(id);
		if (found.isPresent()) {
			repo.deleteById(id);
		}
	}

	public List<Property> searchByAddress(String address) {
		return repo.findByAddressStreetAddressContainingIgnoreCase(address);
	}
	
	/*
	 * Old Code
	 * 
		public void getAddressApartments() {
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
			if (startUp == true) { // apartmentMap is initialized only once with startup
				apartmentMap.put(apa1.getAddress(), apa1);
				apartmentMap.put(apa2.getAddress(), apa2);
				apartmentMap.put(apa3.getAddress(), apa3);
				apartmentMap.put(apa4.getAddress(), apa4);
				apartmentMap.put(apa5.getAddress(), apa5);
				apartmentMap.put(apa6.getAddress(), apa6);
				apartmentMap.put(apa7.getAddress(), apa7);
			}
		}

		public List<Apartment> getApartments() {
			if ((apartmentMap.isEmpty()) && (startUp == true)) { // Fix the situation if all apartments are deleted.
				getAddressApartments();
				logger.info("getApa: startUp = " + startUp);
			}
			Iterator<Address> iterator = apartmentMap.keySet().iterator();
			if ((apartments.size() == 0) && (startUp == true)) {
				while (iterator.hasNext()) {
					Apartment apartment = apartmentMap.get(iterator.next());
					apartments.add(apartment);
				}
				startUp = false;
			}
			String size = "" + apartments.size();
			logger.info("getApa: apartments.size() = " + size + " startUp = " + startUp);
			return apartments;
		}

		public List<Apartment> getCityApartments(String city) {
			// Apartment apartment = null;
			ArrayList<Apartment> cityList = new ArrayList<Apartment>();
			for (Apartment apa : apartments) {
				// Apartment apartment = apa;
				if ((apa.getAddress()).getCity().equals(city)) {
					cityList.add(apa);
				}
			}
			int koko = cityList.size();
			logger.info("getCit: " + koko);
			return cityList;
		}

//		public List<Apartment> getCityApartments(String city) {
//			//Apartment apartment = null;
//			ArrayList<Address> cityList = repo.getAddress(); //((PropertyRepository) apartments).findByAddressCity(city);
////			ArrayList<Apartment> cityList = new ArrayList<Apartment>();
////			for (Apartment apa : apartments) {
////				//Apartment apartment = apa;
////				if ((apa.getAddress()).getCity().equals(city)) {
////					cityList.add(apa);
////				}
////			}
//			int koko = cityList.size();
//			logger.info("getCit: " + koko);
//			return cityList;
//		}

		public List<Apartment> getCountryApartments(String country) {
			// Apartment apartment = null;
			ArrayList<Apartment> countryList = new ArrayList<Apartment>();
			for (Apartment apa : apartments) {
				// apartment = apa;
				if ((apa.getAddress()).getCountry().equals(country)) {
					countryList.add(apa);
				}
			}
			int koko = countryList.size();
			logger.info("getCou: " + koko);
			return countryList;
		}

//		public void addApartment(Apartment apartment) {
//			// if (!apartmentMap.containsValue(apartment)) { // not working, but why?
//			boolean found = false;
//			for (Apartment apa : apartments) {
//				if ((apa.getAddress().toString()).equals(apartment.getAddress().toString())) {
//					found = true;
//					break;
//				}
//			}
//			if (found == false) {
//				apartments.add(apartment);
//				apartmentMap.put(apartment.getAddress(), apartment);
//			}
//			String msg = apartmentMap.toString();
//			logger.info("addApa apartmentMap: " + msg);
//			// return apartments; List<Apartment>
//		}

		public void addApartments(HashMap<Address, Apartment> apartmentHashMap) {
			// Apartment apartment = null;
////			Iterator<Address> iterator = apartmentHashMap.keySet().iterator();
////			while (iterator.hasNext()) {
//			for (Map.Entry pairEntry: apartmentHashMap.entrySet()) {
//				//apartment = apartmentHashMap.get(iterator.next());
//				apartment = (Apartment) pairEntry.getValue();
//				addApartment(apartment);
//			}
			Set<Address> keySet = apartmentHashMap.keySet();
			for (Address key : keySet) {
				Apartment apartmentValue = apartmentHashMap.get(key);

				// apartment = apartmentHashMap.get(iterator.next());

				addApartment(apartmentValue);
			}
			String msg = apartmentMap.toString();
			logger.info("addApa apartmentMap: " + msg);
			// return apartments; List<Apartment>
		}

		public void deleteApartment(Address address) {
			boolean found = false;
			for (Apartment apa : apartments) {
				if ((apa.getAddress().toString()).equals(address.toString())) {
					logger.info("delApa: Found - " + address);
					apartmentMap.remove(address, apa);
					// I wonder, why this is not removing a apartment with address out of hashMap of
					// apartmentMap?
					apartments.remove(apa);
					found = true;
					break;
				}
			}
			if (found == false)
				logger.info("delApat: Not found - " + address);
			logger.info("delApat: " + address.toString());
			logger.info("delApat: apartmentMap.size() =  " + apartmentMap.size());
		}

		public void updateApartment(Apartment apartment) {
			boolean found = false;
			Address address = apartment.getAddress();
			for (Apartment apa : apartments) {
				if ((apa.getAddress().toString()).equals(address.toString())) {
					// logger.info("delApa: Found - " + address);
					// apartmentMap.put(address, apartment);
					apartments.remove(apa);
					apartments.add(apartment);
					found = true;
					break;
				}
			}
			if (found == false)
				logger.info("updApat: Not found - " + address);
			logger.info("updApat: " + address.toString());
			logger.info("updApat: apartmentMap.size() =  " + apartmentMap.size());
		}

		public void deleteApartments(HashMap<Address, Apartment> apartmentHashMap) {
			Set<Address> keySet = apartmentHashMap.keySet();
			for (Address key : keySet) {
				Apartment apartmentValue = apartmentHashMap.get(key);
				deleteApartment(apartmentValue.getAddress());
			}
			String msg = apartmentMap.toString();
			logger.info("addApa apartmentMap: " + msg);
		}
	*/

}
