package com.infosys.profile.dto;

import java.util.List;

public class ProfileDTO {
	String name;
	String address;
	Integer Id;
	List<EquipmentDTO> equipment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public List<EquipmentDTO> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<EquipmentDTO> equipment) {
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return "ProfileDTO [name=" + name + ", address=" + address + ", Id=" + Id + ", equipment=" + equipment + "]";
	}
	

}
