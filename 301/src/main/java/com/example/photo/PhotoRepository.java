package com.example.photo;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Photo;
import com.example.mapper.PhotoMapper;

@Repository
public class PhotoRepository {
	private SqlSessionTemplate sessionTemplate;

	public PhotoRepository(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public List<Map<Long, String>> getPhotos(Long albumId) {
		return sessionTemplate.getMapper(PhotoMapper.class).getPhotos(albumId);
	}

	public String getAlbumName(Long albumId) {
		return sessionTemplate.getMapper(PhotoMapper.class).getAlbumName(albumId);
	}

	public String getPhoto(Long photoId) {
		return sessionTemplate.getMapper(PhotoMapper.class).getPhoto(photoId);
	}

	public void photoUp(Photo photo) {
		sessionTemplate.getMapper(PhotoMapper.class).newPhoto(photo.getAlbumId(), "/" + photo.getFileName());
	}

	public void deletePhoto(long id) {
		sessionTemplate.getMapper(PhotoMapper.class).deletePhoto(id);
	}
}
