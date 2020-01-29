package fi.amiedu.realestateproject.domain;

public class Picture {
	private String desc;
	private byte[] file;
	
	public Picture(String desc, byte[] file) {
		super();
		this.desc = desc;
		this.file = file;
	}
	
	public Picture() {
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
}
