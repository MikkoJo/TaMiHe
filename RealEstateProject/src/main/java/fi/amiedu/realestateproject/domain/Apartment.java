package fi.amiedu.realestateproject.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Apartment extends Property {

	private int floor;
	private int totalFloors;
	private boolean elevator;
	private boolean balcony;

	public Apartment(Lot lot, Address address, String prize, double area, String desc,
			int floor, int totalFloors,	boolean elevator, boolean balcony) {
		super(lot, address, prize, area, desc);
		this.floor = floor;
		this.totalFloors = totalFloors;
		this.elevator = elevator;
		this.balcony = balcony;
	}
	
	public Apartment() {
		super();
	}
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getTotalFloors() {
		return totalFloors;
	}

	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Apartment [floor=");
		builder.append(floor);
		builder.append(", totalFloors=");
		builder.append(totalFloors);
		builder.append(", elevator=");
		builder.append(elevator);
		builder.append(", balcony=");
		builder.append(balcony);
		builder.append("]");
		return builder.toString();
	}

}
