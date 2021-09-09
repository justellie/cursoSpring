package com.ellie.restdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@Component
class DataLoader {
	private final CoffeeRepository coffeeRepository;

	public DataLoader(CoffeeRepository coffeeRepository){
		this.coffeeRepository=coffeeRepository;
	}
	@PostConstruct
	private void loadData(){
		this.coffeeRepository.saveAll(List.of(new Coffee("Cafe Cereza"),
				new Coffee("Cafe Ganador"),
				new Coffee("Cafe Lara"),
				new Coffee("Cafe Tres Pontas")));
	}

}

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {

	
	
	private final CoffeeRepository coffeeRepository;

	RestApiDemoController(CoffeeRepository coffeeRepository) {
		this.coffeeRepository=coffeeRepository;
	}

	@GetMapping
	Iterable<Coffee> getCoffees() {
		return this.coffeeRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id) {

		return coffeeRepository.findById(id);
	}

	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		
		return coffeeRepository.save(coffee);
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		

		
		return (coffeeRepository.existsById(id))
				? new ResponseEntity<Coffee>(coffee,HttpStatus.OK)
				: new ResponseEntity<Coffee>(postCoffee(coffee), HttpStatus.CREATED) ;

	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffeeRepository.deleteById(id);
	}	
}
