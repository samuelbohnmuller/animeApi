package com.samuel.anime.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AnimeDto {
	
	@NotNull(message = "Nome não pode ser nulo.") 
	@NotBlank(message = "Nome deve ser obrigatório.")
	private String name;
	
	public AnimeDto(String name) {
		this.name = name;
	}

	public AnimeDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
