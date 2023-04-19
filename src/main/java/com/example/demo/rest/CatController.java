package com.example.demo.rest;

import java.util.ArrayList;
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

@RestController
public class CatController {

	List<Cat> cats = new ArrayList<>();

	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}

	public Cat createCat(@RequestBody Cat c) {
		this.cats.add(c);
		return this.cats.get(this.cats.size() - 1);
	}

	@GetMapping("/getAll")
	public List<Cat> getAll() {
		return this.cats;
	}

	@GetMapping("/get/{id}")
	public Cat get(@PathVariable int id) {
		return this.cats.get(id);
	}

	@DeleteMapping("/delete/{id}")
	public Cat delete(@PathVariable int id) {
		return this.cats.remove(id);
	}

	@PatchMapping("/update/{id}")
	public Cat update(@PathVariable int id, @RequestParam(name = "hasWhiskers", required = false) Boolean hasWhiskers,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "evil", required = false) Boolean evil,
			@RequestParam(name = "length", required = false) Integer length) {
		Cat c = new Cat();
		if (hasWhiskers != null)
			c.setHasWhiskers(hasWhiskers);
		if (name != null)
			c.setName(name);
		if (evil != null)
			c.setEvil(evil);
		if (length != null)
			c.setLength(length);
		return c;
	}

	@PostMapping("/create")

	public ResponseEntity<Cat> Create(@RequestBody Cat c) {
		cats.add(c);
		Cat created = cats.get(cats.size() - 1);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
}
