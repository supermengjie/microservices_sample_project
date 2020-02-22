package com.example.demo.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.infosys.equipment.EquipmentServiceApplication;
import com.infosys.equipment.controller.EquipmentController;
import com.infosys.equipment.dto.EquipmentDTO;
import com.infosys.equipment.service.EquipmentService;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes=EquipmentServiceApplication.class)
@WebMvcTest(controllers = EquipmentController.class)
public class EquipmentControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	private EquipmentService equipmentService;
	
	@InjectMocks
	EquipmentController equipmentController;
	
	private EquipmentDTO equipment1;
	private EquipmentDTO equipment2;
	
	public void equipment1() {
		equipment1= new EquipmentDTO();
		equipment1.setCustomerID(1);
		equipment1.setName("Book");
	}
	
	public void equipment2() {
		equipment2= new EquipmentDTO();
		equipment2.setCustomerID(1);
		equipment2.setName("Phone");
	}
	
	@Before
	public void setUp() {
		equipment1();
		equipment2();
	}
	 @Test
	 public void getAllequipment() throws Exception {
		 List<EquipmentDTO> equipments= new ArrayList<>();
		 equipments.add(equipment1);
		 given(equipmentController.getequipment(equipment1.getCustomerID())).willReturn(new ResponseEntity<List<EquipmentDTO>>(equipments,HttpStatus.OK));
		 mvc.perform(get("/equipmetn"))
		 .andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name", is(equipment1.getName())))
			.andExpect(jsonPath("$[0].id", is(equipment1.getCustomerID())));
		 
		 
	 }
	
}
