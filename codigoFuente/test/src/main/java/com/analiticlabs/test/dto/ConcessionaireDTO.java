package com.analiticlabs.test.dto;

import java.util.ArrayList;
import java.util.List;

public class ConcessionaireDTO {
	private Long id;
    private String name;
	private List<BusDTO> busListDto;
	
	
	
	public ConcessionaireDTO()
	{
		super();
		this.id = new Long(0);
		this.name = "";
		this.busListDto = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BusDTO> getBusListDto() {
		return busListDto;
	}
	public void setBusListDto(List<BusDTO> busListDto) {
		this.busListDto = busListDto;
	}

}
