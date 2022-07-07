package com.example.domain;

public class Photo {
	private String fileName;

	private String contentType;

	private Long albumId;

	public Photo(String fileName, String contentType) {
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	@Override
	public String toString() {
		return "FileDto [fileName=" + fileName + ", contentType=" + contentType + "]";
	}

}
