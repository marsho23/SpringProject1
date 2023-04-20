package com.example.demo.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.domain.Cat;
import com.example.demo.repo.CatRepo;
import com.example.demo.service.CatService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CatServiceDBTest {
	
	@Autowired
	private CatService service;
	
	@MockBean
	private CatRepo repo;
	
	@Test
	void testUpdate() {
		int id =1;
		//mocking anything in the update method from CatServiceDB that uses
		//the repo cos we wanna test the service not the repo
		//here we are trying to mock the lines 41 and 50 from CatServiceDb
		Cat existing = new Cat ((long) id, "Tiddles", true, false, 12);
		Cat updated = new Cat((long) id, "fluffy", false, true, 99);
		Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		
		Assertions.assertEquals(updated,this.service.update(id,updated.isHasWhiskers(), updated.getName(),updated.isEvil(), updated.getLength()));
	}
	
	@Test
	void testCreate() {
		Cat created = new Cat("fluffy", false, true, 99);
		Mockito.when(this.repo.save(created)).thenReturn(created);
		
		Assertions.assertEquals(created, this.service.create(created));
	}
	
	@Test
	void testGetAll() {
		ArrayList<Cat> catList = new ArrayList<Cat>();
		catList.add(new Cat("fluffy", false, true, 99));
		Mockito.when(this.repo.findAll()).thenReturn(catList);
		
		Assertions.assertEquals(catList, this.service.getAll());
	}
	
	@Test
	void testGetById() {
		int id =1;
		Cat found = new Cat ((long) id, "Tiddles", true, false, 12);
		Mockito.when(this.repo.findById((long)id)).thenReturn(Optional.of(found));
		
		Assertions.assertEquals(found, this.service.get(id));
	}
	
	@Test
	void testDelete() {
		int id=1;
		Cat deleted = new Cat ((long) id, "Tiddles", true, false, 12);
		Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(deleted));

		Assertions.assertEquals(deleted, this.service.delete(id));
	}
}
