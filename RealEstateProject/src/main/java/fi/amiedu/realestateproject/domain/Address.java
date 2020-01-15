package fi.amiedu.realestateproject.domain;

import fi.amiedu.realestateproject.util.Point;

public class Address {
	private String streetName;
	private String houseNumber;
	private String doorNumber;
	private String city;
	private String zipCode;
	private String country;
	private Point coordinates;
	
	public Address(String streetName, String houseNumber, String doorNumber, String city, String zipCode,
			String country, Point coordinates) {
		super();
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.doorNumber = doorNumber;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.coordinates = coordinates;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
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
		if (streetName != null) {
			builder.append("streetName=");
			builder.append(streetName);
			builder.append(", ");
		}
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
