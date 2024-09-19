package com.onetomany.mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_Id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Class")
	private String cls;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="House_Id")
	private House house;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cls=" + cls + ", house=" + house + "]";
	}
}
