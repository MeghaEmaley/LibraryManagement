package com.project.LibraryManagement.entity;

import javax.persistence.*;


@Entity
@Table(name = "student")

public class Student {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator ="student_gen",strategy = GenerationType.AUTO )
	@SequenceGenerator(name="student_gen",sequenceName = "student_seq",initialValue=20,allocationSize = 1)
    private Long id;

	@Column(name = "studentname")
    private String studentName;
    
    private String email;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getstudentName() {
		return studentName;
	}
	
	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	 public Student() {
			super();
			
		}
}

