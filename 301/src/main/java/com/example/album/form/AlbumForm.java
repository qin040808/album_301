package com.example.album.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class AlbumForm {

	private Long albumId;

	private Long accountId;

	@NotBlank
	private String albumName;

	private LocalDateTime albumCreateDate;

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

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

	public LocalDateTime getAlbumCreateDate() {
		return albumCreateDate;
	}

	public void setAlbumCreateDate(LocalDateTime albumCreateDate) {
		this.albumCreateDate = albumCreateDate;
	}

}
