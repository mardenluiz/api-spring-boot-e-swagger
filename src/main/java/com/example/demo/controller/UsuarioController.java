package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Usuario;

@RequestMapping("/users")
@RestController
public class UsuarioController {

	private UsuarioRepository repository;

	private UsuarioService service;

	public UsuarioController(UsuarioRepository repository, UsuarioService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getUser() {
		return repository.findAll();
	}
	
	@GetMapping("/{username}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario getOne(@PathVariable("username") String username) {
		return repository.findByLogin(username);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody Usuario usuario) {
		service.saveUser(usuario);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void putUser(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}
}
