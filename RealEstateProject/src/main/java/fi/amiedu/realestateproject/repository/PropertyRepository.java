package fi.amiedu.realestateproject.repository;

import org.springframework.data.repository.CrudRepository;

import fi.amiedu.realestateproject.domain.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer>{

}
