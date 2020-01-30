package fi.amiedu.realestateproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import fi.amiedu.realestateproject.util.Point;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 

	@OneToOne(mappedBy = "address")
	private Property property;
	private String streetAddress;
//	private String houseNumber;
//	private String doorNumber;
	private String city;
	private String zipCode;
	private String country;
	@OneToOne
	@JoinColumn(name="point_id")
	private Point coordinates;

	public Address(Property property, String streetAddress/*, String houseNumber, String doorNumber*/,
			String city, String zipCode, String country, Point coordinates) {
		super();
		this.property = property;
		this.streetAddress = streetAddress;
//		this.houseNumber = houseNumber;
//		this.doorNumber = doorNumber;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.coordinates = coordinates;
	}
	
	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
/*
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
*/
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [");
		if (streetAddress != null) {
			builder.append("streetAddress=");
			builder.append(streetAddress);
			builder.append(", ");
		}
		/*
		if (houseNumber != null) {
			builder.append("houseNumber=");
			builder.append(houseNumber);
			builder.append(", ");
		}
		if (doorNumber != null) {
			builder.append("doorNumber=");
			builder.append(doorNumber);
			builder.append(", ");
		}
		*/
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (zipCode != null) {
			builder.append("zipCode=");
			builder.append(zipCode);
			builder.append(", ");
		}
		if (country != null) {
			builder.append("country=");
			builder.append(country);
			builder.append(", ");
		}
		if (coordinates != null) {
			builder.append("coordinates=");
			builder.append(coordinates);
		}
		builder.append("]");
		return builder.toString();
	}

}
