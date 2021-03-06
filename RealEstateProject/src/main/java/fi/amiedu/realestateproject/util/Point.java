package fi.amiedu.realestateproject.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Point coordinates in EPSG:3857
@Entity
public class Point {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private long x;
	private long y;
	private long z;
	
	public Point() {
	}
	
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public Point(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	public long getZ() {
		return z;
	}
	public void setZ(long z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "Point [" + (id != null ? "id=" + id + ", " : "") + "x=" + x + ", y=" + y + "]";
	}
	
}
