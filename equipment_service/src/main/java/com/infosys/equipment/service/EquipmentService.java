package com.infosys.equipment.service;

import java.util.List;

import com.infosys.equipment.dto.EquipmentDTO;

public interface EquipmentService {

	String save(EquipmentDTO equipment);

	List<EquipmentDTO> findEquipment();

	List<EquipmentDTO> findEquipmentByCustomerId(int customerId);



}
