package com.onetomany.mapping.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "house_details")
public class House {
	@Id
	@Column(name = "House_Id")
	private int houseId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Dress")
	private String dress;
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
//	@JoinColumn(name = "Student_Id") Not allowed to write here
	private List<Student> student;
	
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDress() {
		return dress;
	}
	public void setDress(String dress) {
		this.dress = dress;
	}

	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	                                                                                     
	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", name=" + name + ", dress=" + dress + ", student=" + student + "]";
	}
	
}
