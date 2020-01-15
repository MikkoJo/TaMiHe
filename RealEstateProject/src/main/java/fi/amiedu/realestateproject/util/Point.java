package fi.amiedu.realestateproject.util;

// Point coordinates in EPSG:3857
public class Point {

	private long x;
	private long y;
	private long z;
	
	public Point(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
		this.z = 0;
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
	
	
}
