package fi.amiedu.realestateproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 

	private String desc;
	private String url;
	@Lob
    @Column(columnDefinition="BLOB")
	private byte[] file;
	
//	@ManyToOne
//	@JoinColumn(name="property_fk")
//	private Property property;
	

	public Picture(String desc, byte[] file/*, Property property*/) {
		super();
		this.desc = desc;
		this.file = file;
//		this.url = url;
//		this.property = property;
	}
	
	public String getUrl() {
		// hardcoded 
		//TODO: change later
		return ServletUriComponentsBuilder.fromCurrentContextPath().toUriString() + "/picture/" + id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Picture() {
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
//	public Property getProperty() {
//		return property;
//	}
//	
//	public void setProperty(Property property) {
//		this.property = property;
//	}

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
