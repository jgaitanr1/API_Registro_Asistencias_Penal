package com.csjll.api.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csjll.api.Entity.Taller;
import com.csjll.api.Service.TallerService;

@RestController
@RequestMapping("/api/taller")
@CrossOrigin("*")
public class TallerController {

	@Autowired
	private TallerService tallerService;

	@GetMapping
	public List<Taller> readAll() {
		List<Taller> users = StreamSupport.stream(tallerService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
	
	@GetMapping("/grupo/{grupo}")
	public List<Taller> readAllByGrupo(@PathVariable String grupo) {
		List<Taller> talleres = StreamSupport.stream(tallerService.findByGrupo(grupo).spliterator(), false)
				.collect(Collectors.toList());
		return talleres;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Taller> ousers = tallerService.findById(id);
		if(!ousers.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ousers);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Taller taller){
		return ResponseEntity.status(HttpStatus.CREATED).body(tallerService.save(taller));
	}
	
	@PutMapping("/")
    public ResponseEntity<Taller> update(@RequestBody Taller taller){
        return ResponseEntity.ok(tallerService.update(taller));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!tallerService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		tallerService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
