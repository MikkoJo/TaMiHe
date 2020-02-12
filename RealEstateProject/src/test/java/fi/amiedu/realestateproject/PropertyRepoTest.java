package fi.amiedu.realestateproject;

//import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

//import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import fi.amiedu.realestateproject.domain.Address;
import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.domain.Property;
import fi.amiedu.realestateproject.repository.PropertyRepository;
import fi.amiedu.realestateproject.util.Point;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest/*(classes = SampleApplication.class)*/
class PropertyRepoTest {

	@Autowired
	PropertyRepository repo;
	
	Apartment apart;
	Address adr;
	Apartment apart2;
	Address adr2;
	Apartment apart3;
	Address adr3;
	
	@BeforeEach
	public void setUp() throws Exception {
		if(repo.count() != 0)
			repo.deleteAll();
		apart = new Apartment();
		adr = new Address("Kaikukuja 6 a 5", "Helsinki", "00530", "Suomi", new Point(23,23));
		apart.setAddress(adr);
		apart2 = new Apartment();
		adr2 = new Address("Harjukatu 12 3 4", "Helsinki", "00540", "Suomi", new Point(66,23));
		apart2.setAddress(adr2);
		apart2.setPrice(155222);
		apart2.setArea(69.2);
		apart2.setDesc("Kiva Kämppä hyvällä paikalla");
		apart2.setFloor(5);
		apart2.setTotalFloors(5);
		apart2.setBalcony(false);
		apart2.setElevator(true);
		apart3 = new Apartment();
		adr3 = new Address("Valimotie 8 ä 11", "Helsinki", "00330", "Suomi", new Point(223,2883));
		apart3.setAddress(adr3);
		apart3.setPrice(82222.0);
	}

	@Test
	public void saveGetTest() {
		repo.save(apart);
		repo.save(apart2);
		repo.save(apart3);
		Iterable<Property> all = repo.findAll();
		assertEquals(3, repo.count());
		for(Property p: all) {
			assertEquals("Helsinki", p.getAddress().getCity());
		}
//		Iterable<Property> all2 = repo.findAll();
//		all2.forEach(p-> System.out.println(p.getAddress()));
//		Iterable<Property> all3 = repo.findAll();
//		all3.forEach(p-> System.out.println(p));
		
	}

	@Test
	public void deleteTest() {
		System.out.println("delteTest");
		repo.save(apart);
		repo.save(apart2);
		repo.save(apart3);
		Iterable<Property> all = repo.findAll();
		assertEquals(3, repo.count());
		repo.deleteById(apart.getId());
		assertEquals(2, repo.count());
		for(Property p: all) {
			assertEquals("Helsinki", p.getAddress().getCity());
		}
//		Iterable<Property> all2 = repo.findAll();
//		all2.forEach(p-> System.out.println(p.getAddress()));
//		Iterable<Property> all3 = repo.findAll();
//		all3.forEach(p-> System.out.println(p.getId()));
		
	}
	
	@Test
	public void updateTest() {
		repo.save(apart);
		repo.save(apart2);
		repo.save(apart3);
		apart.getAddress().setCountry("Eesti");
		apart.setArea(88.4);
		apart.getAddress().setCoordinates(new Point(58888,555555));
		apart.setBalcony(true);
		repo.save(apart);
		Iterable<Property> all = repo.findAll();
		for(Property p: all) {
			assertEquals("Helsinki", p.getAddress().getCity());
		}
		Iterable<Property> all2 = repo.findAll();
		all2.forEach(p-> System.out.println(p.getAddress().getCoordinates()));
		Iterable<Property> all3 = repo.findAll();
		all3.forEach(p-> System.out.println(p));
		
	}

	@Test
	public void findTest() {
		repo.save(apart);
		repo.save(apart2);
		repo.save(apart3);
		apart.getAddress().setCity("Espoo");
		apart.getAddress().setCountry("Eesti");
		apart.setPrice(100312.0);
		apart.setBalcony(true);
		repo.save(apart);
		Iterable<Property> all = repo.findAll();
		assertEquals(3, repo.count());
		List<Property> country = repo.findByAddressCountryIgnoreCase("Suomi");
		assertEquals(2, country.size());
		List<Property> street = repo.findByAddressStreetAddressContainingIgnoreCase("kuja");
		assertEquals(1,street.size());
		List<Property> city = repo.findByAddressCityIgnoreCase("Helsinki");
		assertEquals(2,city.size());
		List<Property> price = repo.findByPriceLessThanEqual(130000.0);
		assertEquals(2,price.size());
		List<Apartment> balcony = repo.findByBalconyTrue();
		assertEquals(1,balcony.size());
		Iterable<Property> all2 = repo.findAll();
		all2.forEach(p-> System.out.println(p.getAddress().getCoordinates()));
		Iterable<Property> all3 = repo.findAll();
		all3.forEach(p-> System.out.println(p));
		
	}
}
