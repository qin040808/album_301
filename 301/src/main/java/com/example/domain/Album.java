package com.example.domain;

import java.time.LocalDateTime;

public class Album {

	private Long albumId;

	private Long accountId;

	private String albumName;

	private String thumbnailUrl;

	private LocalDateTime albumCreateDate;

	private LocalDateTime albumDeleteDate;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public LocalDateTime getAlbumCreateDate() {
		return albumCreateDate;
	}

	public void setAlbumCreateDate(LocalDateTime albumCreateDate) {
		this.albumCreateDate = albumCreateDate;
	}

	public LocalDateTime getAlbumDeleteDate() {
		return albumDeleteDate;
	}

	public void setAlbumDeleteDate(LocalDateTime albumDeleteDate) {
		this.albumDeleteDate = albumDeleteDate;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

}
