package fi.amiedu.realestateproject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import fi.amiedu.realestateproject.domain.Picture;
import fi.amiedu.realestateproject.domain.Property;
import fi.amiedu.realestateproject.repository.PictureRepository;
import fi.amiedu.realestateproject.repository.PropertyRepository;

@Component
public class PictureService {

	@Autowired
	private PictureRepository repo;
	@Autowired
	private PropertyRepository propRepo;

	private Map<Integer, String> contentTypeCache = new HashMap<>();

	public byte[] getPicture(Integer id) {
		Optional<Picture> pic = repo.findById(id);
		if (pic.isPresent()) {
			Picture picture = pic.get();
			this.contentTypeCache.put(id, picture.getContentType());
			return picture.getFile();
		} else {
			return null;
		}
	}

	public String getContentType(Integer id) {
		String contentType = contentTypeCache.get(id);
		// default
		if (contentType == null) {
			contentType = "image/jpeg";
		}
		return contentType;
	}

	public boolean addPicToApartment(Integer apartmentId, @Valid @NotNull @NotBlank MultipartFile file) {
		Optional<Property> prop = propRepo.findById(apartmentId);
		if (prop.isPresent()) {
			Property property = prop.get();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			try {
				property.addPicture(new Picture(fileName, file.getBytes(), file.getContentType()));
				propRepo.save(property);
			} catch (IOException e) {
				return false;
			}
		} else {
			return false;
		}
		return true;

	}

	public boolean updatePicture(Integer apartmentId, Integer id, 
			@Valid @NotNull @NotBlank MultipartFile file) {
		Optional<Property> prop = propRepo.findByPicturesId(id);
		if (prop.isPresent()) {
			Property property = prop.get();
			// Check if picture belongs to this property
			if (property.getId() == apartmentId) {
				Optional<Picture> pic = repo.findById(id);
				if (pic.isPresent()) {
					Picture picture = pic.get();
					String fileName = StringUtils.cleanPath(file.getOriginalFilename());
					try {
						picture.setDesc(fileName);
						picture.setFile(file.getBytes());
						picture.setContentType(file.getContentType());
						repo.save(picture);
					} catch (IOException e) {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean deletePicture(Integer apartmentId, Integer id) {
		Optional<Property> prop = propRepo.findByPicturesId(id);
		if (prop.isPresent()) {
			Property property = prop.get();
			// Check if picture belongs to this property
			if (property.getId() == apartmentId) {
				Optional<Picture> pic = repo.findById(id);
				if (pic.isPresent()) {
					repo.delete(pic.get());
				}
				else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}
