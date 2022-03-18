package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="rollno")
	private String rollno;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
	
 
	public Student() {
	}


	public Batch getBatch() {
		return batch;
	}


	public void setBatch(Batch batch) {
		this.batch = batch;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollno=" + rollno + ", name=" + name + ", email=" + email + ", batch=" + batch
				+ "]";
	}
	
	
 
}