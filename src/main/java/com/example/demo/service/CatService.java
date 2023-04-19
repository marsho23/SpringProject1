package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Cat;

public interface CatService {

	List<Cat> getAll();

	Cat get(int id);

	Cat delete(int id);

	Cat update(int id, Boolean hasWhiskers, String name, Boolean evil, Integer length);

	Cat create(Cat c);

}
