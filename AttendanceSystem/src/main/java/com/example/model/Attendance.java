package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceid;
	
	@Column
	private String date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;

	public int getAttendanceid() {
		return attendanceid;
	}

	public void setAttendanceid(int attendanceid) {
		this.attendanceid = attendanceid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
		
}
