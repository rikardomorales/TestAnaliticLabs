/**
*
* Classname: BusImpl
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analiticlabs.test.dto.BusDTO;
import com.analiticlabs.test.dto.DeviceDTO;
import com.analiticlabs.test.model.Bus;
import com.analiticlabs.test.model.Device;
import com.analiticlabs.test.repository.IBusRepository;
import com.analiticlabs.test.service.IBus;
import com.analiticlabs.test.service.IConcessionaire;
import com.analiticlabs.test.service.IDevice;

@Transactional
@Service
public class BusImpl implements IBus{
	@Autowired
	private IBusRepository iBusRepository;
	
	@Autowired
	private IDevice iDevice;
	
	@Autowired
	private IConcessionaire iConcessionaire;
	
	/**
	 * Returna a list of all buses
	 * @return lstAllBuses
	 */
	public List<Bus> findAll()
	{
		 List<Bus> lstAllBuses = new ArrayList<>();
		 try
		 {
			lstAllBuses = this.iBusRepository.findAll();
		 }catch(Exception e)
		  {
			 System.out.println("Error: "+e.getMessage());
		  }
		 return lstAllBuses;
	}
	
	/**
	 * this method save an Bus entity
	 * @param busEt
	 * @return busEt
	 */
	public Bus save(Bus busEt)
	{
	  try
	  {
		busEt = this.iBusRepository.save(busEt);
	  }catch(Exception e)
	   {
		   System.out.println("Error: "+e.getMessage());
	   }
	  return busEt;
	}
	
	/**
	 * this method update an Bus entity
	 * @param busEt
	 * @return busEt
	 */
	public Bus update(Bus busUpdt)
	{
	  Bus busEt = new Bus();
	  try
	  {
		busEt = this.findById(busUpdt.getId());
		if(busEt!=null)
		{
			busEt.setBreaks(busUpdt.getBreaks());
			busEt.setConcessionaireId(busUpdt.getConcessionaireId());
			busEt.setMotor(busUpdt.getMotor());
			busEt.setType(busUpdt.getType());
			busEt = this.iBusRepository.save(busEt);
		}
	  }catch(Exception e)
	   {
		   System.out.println("Error: "+e.getMessage());
	   }
	  return busEt;
	}

	/**
	 * This method return a bus by id
	 * @param id
	 * @return busEt
	 */
	public Bus findById(Long id) 
	{
   	  Bus busEt = new Bus();
	  try
	  {
		busEt = this.iBusRepository.findById(id);
	  }catch(Exception e)
	   {
	      System.out.println("Error: "+e.getMessage());
	   }
	  return busEt;
	}
	
	/**
	 * this method delete a bus entity
	 * @param id
	 */
	public void delete(Long id)
	{
	  Bus busEt = new Bus();
	  try
	  {
		busEt = this.findById(id);
		this.iBusRepository.delete(busEt);
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }	
	}
	
	/**
	 * This method transform a Bus Entity
	 * to DTO Object
	 * @param busEt
	 * @return busDto
	 */
	public BusDTO transformToDto(Bus busEt)
	{
	  BusDTO busDto = new BusDTO();
	  try
	  {
		  busDto.setId(busEt.getId());
		  busDto.setBreaks(busEt.getBreaks());
		  busDto.setConcessionaireDto(this.iConcessionaire.transformToDto(busEt.getConcessionaireId()));
		  
		  List<Device> lstDevicesEt = new ArrayList<>();
		  List<DeviceDTO> lstDevicesDto = new ArrayList<>();
		  lstDevicesEt = busEt.getDeviceList(); 
		  for(Device deviceEt:lstDevicesEt)
		  {
			  lstDevicesDto.add(this.iDevice.transformToDto(deviceEt));  
		  }
		  		  
		  busDto.setDeviceListDto(lstDevicesDto);
		  busDto.setMotor(busEt.getMotor());
		  busDto.setType(busEt.getType());
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }	
	  return busDto;
	}
}
