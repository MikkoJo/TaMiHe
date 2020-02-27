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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 

	private String desc;
	private String url;
	private String contentType;
	@Lob
    @Column(columnDefinition="BLOB")
	private byte[] file;
	
	public Picture() {
	}

	public Picture(String desc, byte[] file) {
		super();
		this.desc = desc;
		this.file = file;
		this.contentType = null;
	}
	public Picture(String desc, byte[] file, String contentType) {
		super();
		this.desc = desc;
		this.file = file;
		this.contentType = contentType;
	}
	
	public String getUrl() {
		return ServletUriComponentsBuilder.fromCurrentContextPath().toUriString() + "/picture/" + id;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@JsonIgnore
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
}
