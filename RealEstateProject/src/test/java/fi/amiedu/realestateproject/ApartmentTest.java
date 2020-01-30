package fi.amiedu.realestateproject;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.domain.Lot;
import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.util.Point;

class ApartmentTest {

	private Apartment apar;
	private InputStream input;
	private Resource resourc;
	
	@BeforeEach
	void setUp() throws Exception {
		Address addr = new Address("Valimotie 8-10 13", "Helsinki", "00380", "Finland", new Point(1,1));
//		Lot lot = new Lot("Under construction");
		apar = new Apartment(addr, "150 000", 54.2, "Cool Apartment", 3, 5, true, true);
		Resource resource = new ClassPathResource("static/test.jpg");

		input = resource.getInputStream();

		apar.setFloorPlans(Arrays.asList(new Picture("Test", input.readAllBytes())));

	}

	@Test
	void test() throws IOException {
		System.out.println(apar);
		resourc = new ClassPathResource("static/test.jpg");
		InputStream input2 = resourc.getInputStream();
		byte[] image = input2.readAllBytes();
		System.out.println(image.length);
		System.out.println(apar.getFloorPlans().get(0).getFile().length);
//		byte[] test = apar.getFloorPlans().get(0).getFile();
		
//		assert.assertArrayEquals(image, test);
//		assert.assertArrayEquals(image.length, apar.getFloorPlans().get(0).getFile().length);
		//fail("Not yet implemented");
	}

}
