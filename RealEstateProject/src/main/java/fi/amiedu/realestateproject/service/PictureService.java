package fi.amiedu.realestateproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.repository.PictureRepository;

@Component
public class PictureService {

	@Autowired
	private PictureRepository repo;
	
	public byte[] getPicture(Integer id) {
		Optional<Picture> pic = repo.findById(id);
		if(pic.isPresent()) {
			Picture picture = pic.get();
			return picture.getFile();
		}
		else {
			return null;
		}
	}
	
}
