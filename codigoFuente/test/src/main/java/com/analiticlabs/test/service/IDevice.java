package com.analiticlabs.test.service;

import java.util.List;

import com.analiticlabs.test.dto.DeviceDTO;
import com.analiticlabs.test.model.Device;

public interface IDevice {
	public DeviceDTO transformToDto(Device deviceEt);
	public Device transformToEt(DeviceDTO deviceDto);
	public List<Device> findByBusId(Long busId);
}
