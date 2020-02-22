package com.infosys.equipment.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EquipmentDTO {
	private int id;
	private String name;
	private int customerID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull(message = "Equipment Name must not be null")
	@NotBlank(message="Equipment Name must not be empty")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Min(value=0, message= "Customer id has to be greater than 0")
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "EquipmentDTO [Id=" + id + ", name=" + name + ", customerID=" + customerID + "]";
	}

	

	
}
