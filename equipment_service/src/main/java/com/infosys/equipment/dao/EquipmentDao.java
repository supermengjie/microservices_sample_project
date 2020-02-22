package com.infosys.equipment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infosys.equipment.entity.EquipmentEntity;

public interface EquipmentDao extends CrudRepository<EquipmentEntity, Integer> {
	
	@Query("SELECT e FROM EquipmentEntity e WHERE e.customerID = ?1")
	List<EquipmentEntity> findByCustomerId(int custID);
	
}
