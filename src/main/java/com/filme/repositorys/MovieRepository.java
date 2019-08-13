package com.filme.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.filme.models.MovieModel;

public interface MovieRepository extends CrudRepository<MovieModel, Integer> {

}
