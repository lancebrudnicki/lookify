package com.lance.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lance.lookify.models.Song;
import com.lance.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// this will find all the songs for our display
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	// this will create a new song in the database
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	//find one song for our search then a if else to see it is not null return either
	public Song findOne(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	public Song updateSong(Long id, String title, String artist, int rating) {
		Song song = findOne(id);
		//using setters to change the data
		song.setTitle(title);
		song.setArtist(artist);
		song.setRating(rating);
		
		return songRepository.save(song);
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> topTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	public List<Song> findSongsByArtist(String artist){
		return songRepository.findByArtistStartingWith(artist);
	}
}
