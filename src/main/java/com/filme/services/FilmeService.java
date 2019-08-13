package com.filme.services;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filme.models.MovieModel;
import com.filme.repositorys.MovieRepository;

@Service
public class FilmeService {

	@Autowired
	private MovieRepository movieRepository;
	public String save (MovieModel movieModel) {
		movieModel.getNome();
		movieModel.getGenero();
		movieModel.getClassificacaoIndicativa();
		movieModel.getDuracao();
		movieModel.getLinkDaCapa();
		movieModel.getQuantidadeDisponivel();
		movieRepository.save(movieModel);
		return "Salvo";
	}
	public void deleteMovie1(int id ) {
		movieRepository.deleteById(id);
	}
	public MovieModel takeById ( int id ) {
		return movieRepository.findById(id).get();
	}
	public void uptade(int id, @Valid  MovieModel movie ) {
		movie.setId(id);
		movieRepository.save(movie);
	}
	public Boolean rent(int id) {
		MovieModel filme = findById(id);
		int rent = filme.getQuantidadeDisponivel();
		rent = rent - 1;
		filme.setQuantidadeDisponivel(rent);
		return true;
	}

	public Boolean giveBack(MovieModel filme) {
		int rent = filme.getQuantidadeDisponivel();
		rent = rent + 1;
		filme.setQuantidadeDisponivel(rent);
		return true;
	}

	public long quantityOfMovie(MovieModel filmeModel) {
		return movieRepository.count();

	}

	public MovieModel findById( Integer id) {
		return movieRepository.findById(id).get();
	}
	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}
}

