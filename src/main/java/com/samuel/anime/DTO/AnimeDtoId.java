package com.samuel.anime.DTO;

public class AnimeDtoId {
	
	private Integer id;
	private String name;
	
	public AnimeDtoId(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimeDtoId() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
