package com.analiticlabs.test.service;

import java.util.List;
import com.analiticlabs.test.model.Bus;

public interface IBus {
	public List<Bus> findAll();
	public Bus findById(Long id);
	public void delete(Long id);
	public Bus save(Bus busEt);
	public Bus update(Bus busUpdt);
}
