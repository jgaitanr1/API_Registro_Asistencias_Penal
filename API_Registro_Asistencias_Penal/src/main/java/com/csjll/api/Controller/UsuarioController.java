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

import com.csjll.api.Entity.Usuario;
import com.csjll.api.Service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> readAll(){
		List<Usuario> users = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		return users;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Usuario> ousers = usuarioService.findById(id);
		if(!ousers.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ousers);
	}
	
	@GetMapping("/user/{nrodoc}")
	public Usuario obtenerUsuario(@PathVariable String nrodoc) {
		return usuarioService.obtenerUsuario(nrodoc);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PutMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.update(usuario));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
