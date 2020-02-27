package fi.amiedu.realestateproject.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.repository.PictureRepository;

@Component
public class PictureService {

	@Autowired
	private PictureRepository repo;
	
	private Map<Integer, String> contentTypeCache = new HashMap<>(); 
	
	public byte[] getPicture(Integer id) {
		Optional<Picture> pic = repo.findById(id);
		if(pic.isPresent()) {
			Picture picture = pic.get();
			this.contentTypeCache.put(id, picture.getContentType());
			return picture.getFile();
		}
		else {
			return null;
		}
	}
	
	public String getContentType(Integer id) {
		String contentType = contentTypeCache.get(id);
		//default
		if(contentType == null) {
			contentType = "image/jpeg";
		}
		return contentType;
	}
}
