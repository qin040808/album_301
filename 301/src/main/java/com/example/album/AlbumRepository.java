package com.example.album;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Album;
import com.example.mapper.AlbumMapper;

@Repository
public class AlbumRepository {
	private SqlSessionTemplate sessionTemplate;

	public AlbumRepository(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public void newAlbum(Album album) {
		sessionTemplate.getMapper(AlbumMapper.class).newAlbum(album.getAccountId(), album.getAlbumName());
		sessionTemplate.getMapper(AlbumMapper.class).insertDefault();
	}

	public List<Map<Map<String, String>, Map<Long, String>>> getAlbum(Long accountId) {
		List<Map<Map<String, String>, Map<Long, String>>> albums = sessionTemplate.getMapper(AlbumMapper.class)
				.getAlbum(accountId);
		System.out.println(albums);
		return albums;
	}

	public void deleteAlbum(Long albumId) {
		sessionTemplate.getMapper(AlbumMapper.class).deleteAlbum(albumId);
	}
}
