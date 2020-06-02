package com.analiticlabs.test.service;

import com.analiticlabs.test.dto.ConcessionaireDTO;
import com.analiticlabs.test.model.Concessionaire;

public interface IConcessionaire {
	public ConcessionaireDTO transformToDto(Concessionaire concessionaireEt);

}
