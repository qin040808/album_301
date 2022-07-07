package com.example.album;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Album;

@Service
public class AlbumService {
	private final AlbumRepository albumRepository;

	public AlbumService(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	public void newAlbum(Album album) {
		albumRepository.newAlbum(album);
	}

	public void deleteAlbum(Long albumId) {
		albumRepository.deleteAlbum(albumId);
	}

	public List<Map<Map<String, String>, Map<Long, String>>> getAlbum(Long accountId) {
		return albumRepository.getAlbum(accountId);
	}
}
