/**
*
* Classname: ConcessionaireImpl
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.service.impl;

import org.springframework.stereotype.Service;

import com.analiticlabs.test.dto.ConcessionaireDTO;
import com.analiticlabs.test.model.Concessionaire;
import com.analiticlabs.test.service.IConcessionaire;

@Service
public class ConcessionaireImpl implements IConcessionaire {
		
	public ConcessionaireDTO transformToDto(Concessionaire concessionaireEt)
	{
	  ConcessionaireDTO concessionaireDTO = new ConcessionaireDTO();
	  try
	  {
	   concessionaireDTO.setId(concessionaireEt.getId());
	   concessionaireDTO.setName(concessionaireEt.getName());
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }
		return null;
	}

}
