package fi.amiedu.realestateproject.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private String streetAddress;
	private String city;
	private String zipCode;
	private String country;
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, 
	CascadeType.MERGE,
	CascadeType.REMOVE})
	@JoinColumn(name="point_id")
	private Point coordinates;

	public Address(String streetAddress,
			String city, String zipCode, String country, Point coordinates) {
		super();
		this.streetAddress = streetAddress;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
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
			builder.append(getCoordinates());
		}
		builder.append("]");
		return builder.toString();
	}

}
