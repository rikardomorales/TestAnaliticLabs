package com.analiticlabs.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.analiticlabs.test.model.Bus;

public interface IBusRepository extends CrudRepository<Bus, Integer>
{
	public List<Bus> findAll();	
	public Bus findById(@Param("id") Long id);
	public void delete(@Param("bus") Bus bus);
}
