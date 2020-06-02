/**
*
* Classname: BusController
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.analiticlabs.test.model.Bus;
import com.analiticlabs.test.service.IBus;

@RestController
@RequestMapping({ "/bus" })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST,RequestMethod.DELETE })
public class BusController {
	@Autowired
	private IBus iBus;
	
	/**
	 * this service return all 
	 * buses entities
	 * @return lstBusEt
	 */
	@GetMapping("/getAll") 
	public List<Bus> getAll()
	{
	  List<Bus> lstBusEt = new ArrayList<>();
	  try
	  {
		  lstBusEt = this.iBus.findAll();
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }
	  return lstBusEt;
	}
	
	/**
	 * this service save a Bus
	 * @return lstBusEt
	 */
	@PostMapping("/save")
	public String save(@RequestBody Bus busEt)
	{
	  Bus busOld = new Bus();
	  String respuesta = "Almacenado Exitosamente";
	  try
	  {
		busOld = this.iBus.findById(busEt.getId());
		if(busOld!=null)
		{
		 respuesta = "Registro ya Existe";
		}else
		{
	     this.iBus.save(busEt);	
		}		
	  }catch(Exception e)
	   {
		 respuesta = "Inconveniente al Almacenar";
		 System.out.println("Error: "+e.getMessage());
	   }
	   return respuesta;
	}
	
	/**
	 * this service save a Bus
	 * @return lstBusEt
	 */
	@PutMapping("/update")
	public String update(@RequestBody Bus busEt)
	{
	  String respuesta = "Actualizado Exitosamente";
	  try
	  {
		this.iBus.update(busEt);
	  }catch(Exception e)
	   {
		 respuesta = "Inconveniente al Actualizar";
		 System.out.println("Error: "+e.getMessage());
	   }
	   return respuesta;
	}
	
	/**
	 * this service delete a Bus
	 * @return lstBusEt
	 */
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") Long id)
	{
	  String respuesta = "Eliminado Exitosamente";
	  try
	  {
		this.iBus.delete(id);
	  }catch(Exception e)
	   {
		 respuesta = "Inconveniente al Eliminar";
		 System.out.println("Error: "+e.getMessage());
	   }
	   return respuesta;
	}

}
