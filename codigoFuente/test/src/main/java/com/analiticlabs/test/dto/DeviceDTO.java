package com.analiticlabs.test.dto;

public class DeviceDTO {
	
	private Long id;
	private String ip;
	private String status;
	
	public DeviceDTO() 
	{
		super();
		this.id = new Long(0);
		this.ip = "";
		this.status = "";
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
