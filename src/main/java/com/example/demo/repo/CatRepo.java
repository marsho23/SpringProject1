package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
	List<Cat> findByName(String name); // spring will auto generate functionailty for you based on the name of the
										// method
	// the above statement will generate basically the follwoing query for you
	// select * from cat where 'name'=%name%
	// findByAnything will generate a similar query for anything else as writing the
	// name this way is a convention
}
