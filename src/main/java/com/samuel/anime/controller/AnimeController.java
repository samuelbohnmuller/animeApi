package com.samuel.anime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.anime.DTO.AnimeDto;
import com.samuel.anime.DTO.AnimeDtoId;
import com.samuel.anime.model.Anime;
import com.samuel.anime.service.AnimeService;
import com.samuel.anime.util.DateUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("anime")
public class AnimeController {
	
	@Autowired
	private DateUtil dateUtil;
	
	@Autowired
	AnimeService animeService;
	
	
	@GetMapping
	public ResponseEntity<Page<Anime>> list(@PageableDefault(page = 0, size = 5) Pageable pageable){
		Page<Anime> animes = animeService.findAll(pageable);
		return ResponseEntity.ok(animes); 
	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Integer id){
		return ResponseEntity.ok(animeService.findById(id)); 
	}
	
	@GetMapping(path = "/find")
	public ResponseEntity<List<Anime>> findByName(@RequestParam String name){ //Pega o valor colocado depois de ? .
		return ResponseEntity.ok(animeService.findByName(name)); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Anime> save(@RequestBody @Valid AnimeDto anime){ //O corpo que será entregue deve ser do tipo Anime(atriburos iguais).
		return ResponseEntity.ok(animeService.save(anime));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody AnimeDtoId anime){
		animeService.replace(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	} 

}
