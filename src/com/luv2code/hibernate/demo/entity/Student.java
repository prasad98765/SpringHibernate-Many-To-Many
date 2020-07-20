package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String emial;
	
	@ManyToMany( fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST })
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name  = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")   // inverser  = other side table ids
			)
	private List<Cource> cource;

	public Student() {

	}

	public Student(String firstName, String lastName, String emial) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emial = emial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public List<Cource> getCource() {
		return cource;
	}

	public void setCource(List<Cource> cource) {
		this.cource = cource;
	}
	
//	// add a convenience method
//
//	public void addCourse(Cource theCource) {
//		if (cource == null) {
//			cource= new ArrayList<>();
//		}
//		cource.add(theCource);
//	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emial=" + emial + "]";
	}

}
