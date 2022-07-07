package com.example.photo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.account.CurrentAccount;
import com.example.domain.Album;
import com.example.domain.Photo;
import com.example.photo.form.PhotoForm;

@Controller
public class PhotoController {

	private final PhotoService photoService;

	public PhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}

	@GetMapping("/album_detail/{id}")
	public String loadPhotos(@PathVariable long id, Model model) {
		List<Map<Long, String>> photoList = photoService.getPhotos(id);
		model.addAttribute("albumName", photoService.getAlbumName(id));
		model.addAttribute("albumId", id);
		model.addAttribute("photoList", photoList);
		return "pages/photo";
	}

	@GetMapping("/upload")
	public String aaa() {
		return "pages/photo";
	}

	@GetMapping("/results")
	public String results() {
		return "pages/photo";
	}

	@GetMapping("/image/{albumId}/{photoId}")
	public String showImg(@PathVariable long photoId, @PathVariable long albumId, Model model) {
		model.addAttribute("photoUrl", photoService.getPhoto(photoId));
		model.addAttribute("photoId", photoId);
		model.addAttribute("albumId", albumId);
		return "pages/image";
	}

	@GetMapping("/delete/{albumId}/{photoId}")
	public String deleteImg(@PathVariable long photoId, @PathVariable long albumId) {
		photoService.deletePhoto(photoId);
		return "redirect:/album_detail/" + albumId;
	}

	@PostMapping("/upload/{albumId}")
	public String upload(@RequestParam("uploadfile") MultipartFile[] uploadfile, Model model,
			@CurrentAccount Album album, @Valid @ModelAttribute PhotoForm photoForm, @PathVariable long albumId) {
		System.out.println(albumId);
		List<Photo> list = new ArrayList<>();
		String absolutePath = new File("").getAbsolutePath() + "\\";

		for (MultipartFile file : uploadfile) {
			Photo photo = new Photo(file.getOriginalFilename(), file.getContentType());
			list.add(photo);
			File newFileName = new File(absolutePath + "target/classes/static/img/" + photo.getFileName());
			photo.setAlbumId(albumId);
			photoService.photoUp(photo);
			try {
				file.transferTo(newFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("files", list);

		return "redirect:/album_detail/" + albumId;
	}
}
