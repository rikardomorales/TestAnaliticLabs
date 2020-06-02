/**
*
* Classname: DeviceImpl
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analiticlabs.test.dto.DeviceDTO;
import com.analiticlabs.test.model.Bus;
import com.analiticlabs.test.model.Device;
import com.analiticlabs.test.repository.IDeviceRepository;
import com.analiticlabs.test.service.IBus;
import com.analiticlabs.test.service.IDevice;

@Service
public class DeviceImpl implements IDevice {
	@Autowired
	private IDeviceRepository iDeviceRepository;
	
	@Autowired
	private IBus iBus;
	
	/**
	 * This method transform a Device Entity
	 * to DTO Object
	 * @param deviceEt
	 * @return deviceDto
	 */
	public DeviceDTO transformToDto(Device deviceEt)
	{
	  DeviceDTO deviceDto = new DeviceDTO();
	  try
	  {
		deviceDto.setId(deviceEt.getId());
		deviceDto.setIp(deviceEt.getIp());
		deviceDto.setStatus(deviceEt.getStatus());
	  }catch(Exception e)
	  {
		 System.out.println("Error: "+e.getMessage());
	  }
		return deviceDto;
	}
	
	/**
	 * This method transform a DTO Object
	 * to Device Entity
	 * @param deviceEt
	 * @return deviceDto
	 */
	public Device transformToEt(DeviceDTO deviceDto)
	{
	  Device deviceEt = new Device();
	  try
	  {
		deviceDto.setId(deviceEt.getId());
		deviceDto.setIp(deviceEt.getIp());
		deviceDto.setStatus(deviceEt.getStatus());
	  }catch(Exception e)
	  {
		 System.out.println("Error: "+e.getMessage());
	  }
		return deviceEt;
	}
	
	/**
	 * this method return a list of Devices
	 * by busId
	 * @param busId
	 * @return lstDeviceEt
	 */
	@Override
	public List<Device> findByBusId(Long busId) 
	{
		 Bus busEt = new Bus(); 
		 List<Device> lstDeviceEt = new ArrayList<>();
		 try
		 {
		   busEt = this.iBus.findById(busId);
		   if(busEt!=null)
		   {
		    lstDeviceEt = this.iDeviceRepository.findByBusId(busEt);
		   }
		 }catch(Exception e)
		  {
			 System.out.println("Error: "+e.getMessage());
		  }
		 return lstDeviceEt;
	}
}
