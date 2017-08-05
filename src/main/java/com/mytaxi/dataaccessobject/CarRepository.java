package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.CarDO;

public interface CarRepository extends CrudRepository<CarDO, Long>{
	
	List<CarDO> findByIsAvailable(Boolean isAvailable);

}
