package fi.amiedu.realestateproject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired
	private PropertyRepository repo;

	// Create a list of apartments
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

			apa1.addPicture(new Picture("Test", StreamUtils.copyToByteArray(input)));
//			apa1.addPicture(new Picture("Test", input.readAllBytes()));
			input.close();
			apa1.addPicture(new Picture("Test2", StreamUtils.copyToByteArray(input3)));
			input3.close();
			resourc = new ClassPathResource("static/test.jpg");
			InputStream input2 = resourc.getInputStream();
			byte[] image = StreamUtils.copyToByteArray(input2);
			input2.close();
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

	public boolean addApartmentPic(Integer id, @Valid @NotNull @NotBlank MultipartFile file) {
		Property prop = getProperty(id);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			prop.addPicture(new Picture(fileName, file.getBytes(), file.getContentType()));
			repo.save(prop);
		}

		catch (IOException e) {
			return false;
		}
		return true;

	}

	public boolean addApartmentWithPic(@Valid Apartment apartment, @Valid @NotNull @NotBlank MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			apartment.addPicture(new Picture(fileName, file.getBytes(), file.getContentType()));
			repo.save(apartment);
		}

		catch (IOException e) {
			return false;
		}
		return true;
	}


}
