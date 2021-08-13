package com.lance.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lance.lookify.models.Song;
import com.lance.lookify.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;

	// Controller
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	//===========DashBoard Routes=============
	
	@RequestMapping("/")
		public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard( @ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	

	
	
	//===========Add New Song Routes=============
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "addsong.jsp";
	}
	
	@RequestMapping(value="/songs/add",method=RequestMethod.POST )
	public String createNewSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "addsong.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}	
	}
	
	
	//===========Show One Song Routes=============
	
	@RequestMapping("songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findOne(id);
		model.addAttribute("song", song);
		
		return "details.jsp";
	}
	
	//===========Top Songs Routes=============
	
	@RequestMapping("/search/topten")
	public String topTen(Song song,Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	
	//==========Artist Routes=============
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String songsByArtist(@RequestParam(value="artist") String artist) {
		
		return "redirect:/search/" + artist;
	}
	
	@RequestMapping("/search/{artist}")
	public String songsByArtistPage(@PathVariable("artist") String artist,@ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.findSongsByArtist(artist);
		model.addAttribute("songs", songs);
		return "artistsearch.jsp";
	}
	
	
	
	//===========Used by all Routes=============
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String destory(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
}
