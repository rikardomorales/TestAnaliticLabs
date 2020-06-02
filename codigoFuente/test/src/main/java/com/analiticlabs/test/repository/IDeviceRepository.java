package com.analiticlabs.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.analiticlabs.test.model.Bus;
import com.analiticlabs.test.model.Device;

public interface IDeviceRepository extends CrudRepository<Device,Integer>{
	
	@Query("SELECT a FROM Device a WHERE a.busId=:bus")
	public List<Device> findByBusId(@Param("bus") Bus bus);

}
