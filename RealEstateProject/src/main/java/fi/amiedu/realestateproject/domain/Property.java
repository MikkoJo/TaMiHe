package fi.amiedu.realestateproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
public abstract class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 

/*	@OneToOne
	@JoinColumn(name="lot_id", referencedColumnName = "id")
	private Lot lot;
*/	
//	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }) //For testing
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="property_id")
	private List<Picture> pictures;
	
//	@OneToMany(mappedBy="property")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="property_id")
	private List<Picture> floorPlans;
	private String prize;
	private double area;
	private String desc;

	public Property(/*Lot lot,*/ Address address, String prize, double area, String desc) {
		/*this.lot = lot;*/
		this.address = address;
		this.pictures = new ArrayList<>();
		this.floorPlans = new ArrayList<>();
		this.prize = prize;
		this.area = area;
		this.desc = desc;
	}

	public Property() {
	}
/*
	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}
*/
	public Address getAddress() {
		return address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Picture> getFloorPlans() {
		return floorPlans;
	}

	public void setFloorPlans(List<Picture> floorPlans) {
		this.floorPlans = floorPlans;
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
/*
		if (lot != null) {
			builder.append("lot=");
			builder.append(lot);
			builder.append(", ");
		}
*/
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
//		if (pictures != null) {
//			builder.append("pictures=");
//			builder.append(pictures);
//			builder.append(", ");
//		}
//		if (floorPlans != null) {
//			builder.append("floorPlans=");
//			builder.append(floorPlans);
//			builder.append(", ");
//		}
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
