package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cat;
import com.example.demo.service.CatService;

@RestController
public class CatController {

	private CatService service;

	public CatController(CatService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}

	// public Cat createCat(@RequestBody Cat c) {
	// }

	@GetMapping("/getAll")
	public List<Cat> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/get/{id}")
	public Cat get(@PathVariable int id) {
		return this.service.get(id);
	}

	@DeleteMapping("/delete/{id}")
	public Cat delete(@PathVariable int id) {
		return this.service.delete(id);
	}

	@PatchMapping("/update/{id}")
	public Cat update(@PathVariable int id, @RequestParam(name = "hasWhiskers", required = false) Boolean hasWhiskers,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "evil", required = false) Boolean evil,
			@RequestParam(name = "length", required = false) Integer length) {
		return this.service.update(id, hasWhiskers, name, evil, length);
	}

	@PostMapping("/create")

	public ResponseEntity<Cat> create(@RequestBody Cat c) {
		Cat created = this.service.create(c);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
}
