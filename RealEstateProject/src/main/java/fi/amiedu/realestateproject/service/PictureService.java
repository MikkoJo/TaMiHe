package fi.amiedu.realestateproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.repository.PictureRepository;

@Component
public class PictureService {

	@Autowired
	private PictureRepository repo;
	
	public byte[] getPicture(Integer id) {
		Picture pic = repo.findById(id).get();
		return pic.getFile();
	}
	
}
