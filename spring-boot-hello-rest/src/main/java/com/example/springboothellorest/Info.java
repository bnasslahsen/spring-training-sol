package com.example.springboothellorest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**
 * @author bnasslahsen
 */
@Data
@Entity
public class Info {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String message;

	@Version
	private int version;
}
