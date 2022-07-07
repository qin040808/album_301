package com.example.photo;

import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.Photo;

@Service
public class PhotoService {
	private final PhotoRepository photoRepository;

	public PhotoService(PhotoRepository photoRepository, PasswordEncoder passwordEncoder) {
		this.photoRepository = photoRepository;
	}

	public List<Map<Long, String>> getPhotos(Long albumId) {
		return photoRepository.getPhotos(albumId);
	}

	public String getAlbumName(Long albumId) {
		return photoRepository.getAlbumName(albumId);
	}

	public String getPhoto(Long photoId) {
		return photoRepository.getPhoto(photoId);
	}

	public void photoUp(Photo photo) {
		photoRepository.photoUp(photo);
	}

	public void deletePhoto(long id) {
		photoRepository.deletePhoto(id);
	}
}
