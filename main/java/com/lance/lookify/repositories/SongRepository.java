package com.lance.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lance.lookify.models.Song;



@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();

	// this method will be used for our search
	List<Song> findByArtistStartingWith(String search);
	
	List<Song> findTop10ByOrderByRatingDesc();
	
}
