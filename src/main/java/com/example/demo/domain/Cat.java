package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // tells spring its a table
public class Cat {
	@Id
	@GeneratedValue
	private Long id;

	public Cat() {
	}
	
	public Cat(String name, boolean hasWhiskers, boolean evil, int length) {
		this.hasWhiskers = hasWhiskers;
		this.name = name;
		this.evil = evil;
		this.length = length;
	}
	

	public Cat(Long id, String name, boolean hasWhiskers, boolean evil, int length) {
		this.id = id;
		this.hasWhiskers = hasWhiskers;
		this.name = name;
		this.evil = evil;
		this.length = length;
	}

	boolean hasWhiskers;
	String name;
	boolean evil;
	int length;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEvil() {
		return evil;
	}

	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
