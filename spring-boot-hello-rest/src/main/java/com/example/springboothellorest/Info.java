package com.example.springboothellorest;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Info {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String message;

	@Version
	private int version;

	// Default constructor required by JPA
	protected Info() {
	}

	// All-arguments constructor
	public Info(Long id, String message, int version) {
		this.id = id;
		this.message = message;
		this.version = version;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public int getVersion() {
		return version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
