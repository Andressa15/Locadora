package com.filme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.models.MovieModel;
import com.filme.services.FilmeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeService movieService;


	@GetMapping
	public ResponseEntity<MovieModel> saveMovie(MovieModel movieModel){
		movieService.save(movieModel);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> takeById(@PathVariable int id ){
		try {
			movieService.takeById(id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> createadMovie(@Valid @RequestBody MovieModel movie){
		try {
			movieService.save(movie);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch (Exception e ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody MovieModel movie){
		movieService.uptade(id, movie);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> rent (@PathVariable int id){
		try{
			movieService.rent(id);
			return ResponseEntity.ok(HttpStatus.ACCEPTED);
		}catch (Exception e ) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}	
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> giveback (@PathVariable int id, MovieModel movie){
			movieService.giveBack(movie);
			return ResponseEntity.ok().build();
	}
	@DeleteMapping
	public ResponseEntity<MovieModel> deteleMesseger(int id) {
		try {
			movieService.deleteMovie(id);
			return ResponseEntity.ok().build();

		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
