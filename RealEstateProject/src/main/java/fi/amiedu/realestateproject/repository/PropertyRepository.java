package fi.amiedu.realestateproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fi.amiedu.realestateproject.domain.Apartment;
import fi.amiedu.realestateproject.domain.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer>{

	List<Property> findByAddressCountryIgnoreCase(String country);
	List<Property> findByAddressStreetAddressContainingIgnoreCase(String streetAddress);
	List<Property> findByAddressCityIgnoreCase(String city);
	List<Property> findByPriceLessThanEqual(double price);
	List<Apartment> findByBalconyTrue();
	
	Optional<Property> findByPicturesId(Integer id);
}
