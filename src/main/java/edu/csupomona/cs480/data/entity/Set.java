package edu.csupomona.cs480.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Set {

	private String title;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String setId;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

}
