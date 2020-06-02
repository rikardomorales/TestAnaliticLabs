/**
*
* Classname: DeviceController
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.analiticlabs.test.model.Device;
import com.analiticlabs.test.service.IDevice;

@RestController
@RequestMapping({ "/device" })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST,RequestMethod.DELETE })
public class DeviceController {
	@Autowired
	private IDevice iDevice;
	
	/**
	 * this service return all 
	 * devices by DeviceId
	 * @return lstDevicesEt
	 */
	@GetMapping("/getDeviceByDeviceId") 
	public List<Device> getAll(@RequestParam("busId") Long busId)
	{
	  List<Device> lstDeviceEt = new ArrayList<>();
	  try
	  {
		  lstDeviceEt = this.iDevice.findByBusId(busId);
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }
	  return lstDeviceEt;
	}
}
