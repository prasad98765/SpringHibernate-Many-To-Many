package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	// define fields 
	
	// define constructor
	
	// define getter and setter 
	
	// define toString
	
	// annotate fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comment")
	private String commit;
	
	public Review() {
		
	}
	
	public Review(String commit) {
		super();
		this.commit = commit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", commit=" + commit + "]";
	}
	
	
}
