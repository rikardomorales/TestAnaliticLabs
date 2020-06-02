package com.analiticlabs.test.dto;

import java.util.ArrayList;
import java.util.List;

public class BusDTO {
	private Long id;
	private String type;
	private String motor;
	private String breaks;
	private ConcessionaireDTO concessionaireDto;
	private List<DeviceDTO> deviceListDto;
	
	public BusDTO() 
	{
		super();
		this.id = new Long(0);
		this.type = "";
		this.motor = "";
		this.breaks = "";
		this.concessionaireDto = new ConcessionaireDTO();
		this.deviceListDto = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getBreaks() {
		return breaks;
	}
	public void setBreaks(String breaks) {
		this.breaks = breaks;
	}
	public ConcessionaireDTO getConcessionaireDto() {
		return concessionaireDto;
	}
	public void setConcessionaireDto(ConcessionaireDTO concessionaireDto) {
		this.concessionaireDto = concessionaireDto;
	}
	public List<DeviceDTO> getDeviceListDto() {
		return deviceListDto;
	}
	public void setDeviceListDto(List<DeviceDTO> deviceListDto) {
		this.deviceListDto = deviceListDto;
	}

}
