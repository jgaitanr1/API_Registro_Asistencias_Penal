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

import com.csjll.api.Entity.Marcacion;
import com.csjll.api.Entity.Usuario;
import com.csjll.api.Service.MarcacionService;



@RestController
@RequestMapping("/api/marcacion")
@CrossOrigin("*")
public class MarcacionController {
	
	@Autowired
	private MarcacionService marcacionService;

	@GetMapping
	public List<Marcacion> readAll(){
		List<Marcacion> marca = StreamSupport
				.stream(marcacionService.findAll().spliterator(), false).collect(Collectors.toList());
		return marca;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Marcacion> ousers = marcacionService.findById(id);
		if(!ousers.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ousers);
	}
	
	@GetMapping("/usuario/{id}")
	public List<Marcacion> readAllByUsuario(@PathVariable Long id) {
		Usuario user = new Usuario();
		user.setId(id);
		List<Marcacion> marcaciones = StreamSupport.stream(marcacionService.findByusuario(user).spliterator(), false)
				.collect(Collectors.toList());
		return marcaciones;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Marcacion marcacion){
		return ResponseEntity.status(HttpStatus.CREATED).body(marcacionService.save(marcacion));
	}
	
	@PutMapping("/")
    public ResponseEntity<Marcacion> update(@RequestBody Marcacion marcacion){
        return ResponseEntity.ok(marcacionService.update(marcacion));
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!marcacionService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		marcacionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
