package com.samuel.anime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.anime.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {

	List<Anime> findByName(String name);
}
