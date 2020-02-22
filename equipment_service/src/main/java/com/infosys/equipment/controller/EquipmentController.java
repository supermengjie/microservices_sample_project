package com.infosys.equipment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.equipment.dto.EquipmentDTO;
import com.infosys.equipment.service.EquipmentService;

@RestController
@RequestMapping("equipments")
@CrossOrigin
public class EquipmentController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EquipmentService equipmentService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EquipmentDTO>> getAllequipment() {
		logger.info("Equipment request for getting all equipments");
		
		List<EquipmentDTO> allEquipments = equipmentService.findEquipment();
		return new ResponseEntity<>( allEquipments, HttpStatus.OK);
	}
	
	@GetMapping(value="/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EquipmentDTO>> getequipment(@PathVariable int customerId) {
		logger.info("Equipment request for custumerId {}", customerId);
		
		List<EquipmentDTO> equipments = equipmentService.findEquipmentByCustomerId(customerId);
		return  new ResponseEntity<>( equipments, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addequipment(@Valid @RequestBody EquipmentDTO equipment) {
		logger.info("Creating Customers for  {}", equipment);
		equipmentService.save(equipment);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

}
