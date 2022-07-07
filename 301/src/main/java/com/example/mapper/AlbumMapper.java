package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AlbumMapper {

	@Insert("INSERT INTO" + "   album(account_id, album_name, album_create_date)"
			+ "VALUES(#{account_id},#{album_name}, now())")
	void newAlbum(Long account_id, String album_name);

	@Insert("insert into photo(album_id, photo_url, photo_create_date)"
			+ "values((SELECT album_id from album where album_create_date = now()),'/default_cover.png',now())")
	void insertDefault();

	@Select("select a.id, a.name, a.count, p.photo_url as photo FROM "
			+ "	(select a.album_id as id, a.album_name as name, count(a.album_id)-1 as count, MAX(p.photo_id) as max"
			+ "		from album a join photo p" + "		on a.album_id = p.album_id"
			+ "		where account_id = #{account_id}" + "		group by a.album_id) as a"
			+ "	INNER JOIN photo as p on p.photo_id = a.max" + "    ORDER BY a.id")
	List<Map<Map<String, String>, Map<Long, String>>> getAlbum(Long account_id);

	@Delete("DELETE FROM album WHERE album_id = #{album_id}")
	void deleteAlbum(Long album_id);
}
