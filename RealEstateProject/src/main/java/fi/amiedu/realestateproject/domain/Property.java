package fi.amiedu.realestateproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

//@Entity
public abstract class Property {

	private Lot lot;
	private Address address;
	private List<Picture> pictures;
	private Picture floorPlan;
	private String prize;
	private double area;
	private String desc;

	public Property(Lot lot, Address address, String prize, double area, String desc) {
		this.lot = lot;
		this.address = address;
		this.pictures = new ArrayList<>();
		this.floorPlan = new Picture();
		this.prize = prize;
		this.area = area;
		this.desc = desc;
	}

	public Property() {
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Picture getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(Picture floorPlan) {
		this.floorPlan = floorPlan;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Property [");
		if (lot != null) {
			builder.append("lot=");
			builder.append(lot);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
		if (pictures != null) {
			builder.append("pictures=");
			builder.append(pictures);
			builder.append(", ");
		}
		if (floorPlan != null) {
			builder.append("floorPlan=");
			builder.append(floorPlan);
			builder.append(", ");
		}
		if (prize != null) {
			builder.append("prize=");
			builder.append(prize);
			builder.append(", ");
		}
		builder.append("area=");
		builder.append(area);
		builder.append(", ");
		if (desc != null) {
			builder.append("desc=");
			builder.append(desc);
		}
		builder.append("]");
		return builder.toString();
	}

}
