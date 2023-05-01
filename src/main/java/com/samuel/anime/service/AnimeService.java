package com.samuel.anime.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samuel.anime.DTO.AnimeDto;
import com.samuel.anime.DTO.AnimeDtoId;
import com.samuel.anime.exception.BadRequestException;
import com.samuel.anime.model.Anime;
import com.samuel.anime.repository.AnimeRepository;

@Service
public class AnimeService {
	
	@Autowired
	private ModelMapper modelMapper;
		
	@Autowired
	private AnimeRepository animeRepository;
	
	public Page<Anime> findAll(Pageable pageable){
		return animeRepository.findAll(pageable);
	}
	
	public List<Anime> findByName(String name){
		return animeRepository.findByName(name);
	}
	
	public Anime findById(Integer id){
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("anime não encontrado"));
	}

	@Transactional(rollbackFor = Exception.class) //Só comita a transação quando o método é finalizado, em caso de surgir alguma excessão e o usuário achar que não comitou no banco, e comitou. Aplico a funcionalidade para funcionar com excessão checked e unchecked, para que pegue também o Exception.
	public Anime save(AnimeDto animeDto) {
		Anime anime = modelMapper.map(animeDto, Anime.class); 
		return animeRepository.save(anime);
	}

	public void delete(Integer id) {
		animeRepository.delete(findById(id));
	}

	public void replace(AnimeDtoId animeDtoId) {
		findById(animeDtoId.getId());
		Anime anime = modelMapper.map(animeDtoId, Anime.class);
		animeRepository.save(anime);
	}
	
}
