package com.example.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entity.Usuario;
import com.example.curso.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}

	@PostMapping("/sign_up")
	public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario){
		if(usuarioService.findUsuario(usuario) == null) {
			usuarioService.save(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUsuario(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario){
		Usuario usuarioDB = null;
		
		usuarioDB = usuarioService.findById(id);
		
		if(usuarioDB != null) {
			usuarioDB.setEmail(usuario.getEmail());
			usuarioDB.setNombre(usuario.getNombre());
			usuarioService.updateUsuario(usuarioDB);
			return new ResponseEntity<>(usuarioDB, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable(value = "id") Long id){

			usuarioService.deleteUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);

	}
}
