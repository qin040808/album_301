package com.example.album;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.account.CurrentAccount;
import com.example.album.form.AlbumForm;
import com.example.domain.Account;
import com.example.domain.Album;

@Controller
public class AlbumController {
	private final AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}

	@GetMapping("/album")
	public String albumPage(@CurrentAccount Account account, Model model) {
		List<Map<Map<String, String>, Map<Long, String>>> albumList = albumService.getAlbum(account.getAccountId());
		model.addAttribute("albumList", albumList);
		model.addAttribute("username", account.getNickname());
		model.addAttribute("userId", account.getAccountId());
		model.addAttribute("albumForm", new AlbumForm());

		return "pages/album";
	}

	@PostMapping("/deleteAlbum/{id}")
	public String deleteAlbum(@PathVariable long id) {
		albumService.deleteAlbum(id);
		return "redirect:/album";
	}

	@PostMapping("/album")
	public String albumPage(@Valid @ModelAttribute AlbumForm albumForm, Errors errors,
			@CurrentAccount Account account) {
		Album newAlbum = new Album();
		newAlbum.setAccountId(account.getAccountId());
		newAlbum.setAlbumName(albumForm.getAlbumName());
		newAlbum.setAlbumId(albumForm.getAlbumId());
		System.out.println(albumForm.getAlbumId());
		albumService.newAlbum(newAlbum);

		return "redirect:/album";
	}

}
