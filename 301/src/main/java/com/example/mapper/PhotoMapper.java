package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PhotoMapper {

	@Select("SELECT photo_id as id, photo_url as url FROM photo WHERE album_id = #{album_id} AND photo_url != '/default_cover.png'")
	List<Map<Long, String>> getPhotos(Long album_id);

	@Select("SELECT album_name From album WHERE album_id = #{album_id}")
	String getAlbumName(Long album_id);

	@Select("SELECT photo_url as url FROM photo WHERE photo_id = #{photo_id}")
	String getPhoto(Long photo_id);

	@Insert("INSERT INTO" + " photo(album_id, photo_url, photo_create_date)"
			+ " VALUES(#{album_id}, #{photo_url}, now())")
	void newPhoto(Long album_id, String photo_url);

	@Delete("DELETE FROM photo WHERE photo_id =#{id}")
	void deletePhoto(Long id);

}