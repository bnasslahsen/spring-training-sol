package com.example.springboothellorest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnasslahsen
 */
@RestController
@RequestMapping("/infos")
public class InfoController {

	@Autowired
	private InfoRepository infoRepository;

	@GetMapping
	public List<Info> findAll() {
		return infoRepository.findAll();
	}

	@GetMapping("/{idInfo}")
	public ResponseEntity<Info> findOneRepo(@PathVariable Long idInfo) {
		try {
			Info info = infoRepository.findById(idInfo).get();
			return ResponseEntity.ok(info);
		}
		catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
