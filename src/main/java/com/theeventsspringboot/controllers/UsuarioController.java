package com.theeventsspringboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theeventsspringboot.entitys.Usuario;
import com.theeventsspringboot.responses.Response;
import com.theeventsspringboot.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("${origem-permitida}")
//@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> create(HttpServletRequest request, @RequestBody Usuario usuario,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		try {
			validateCreateUsuario(usuario, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			Usuario usuarioPersisted = (Usuario) usuarioService.createOrUpdate(usuario);
			response.setDados(usuarioPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErros().add("E-mail já registrado!");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErros().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateCreateUsuario(Usuario usuario, BindingResult result) {
		if (usuario.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email não informado!"));
			return;
		}
	}

	@PutMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> update(HttpServletRequest request, @RequestBody Usuario usuario,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		try {
			validateUpdate(usuario, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			Usuario userPersisted = (Usuario) usuarioService.createOrUpdate(usuario);
			response.setDados(userPersisted);
		} catch (Exception e) {
			response.getErros().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private void validateUpdate(Usuario user, BindingResult result) {
		if (user.getId() == null) {
			result.addError(new ObjectError("Usuario", "Id não informado!"));
			return;
		}
		if (user.getEmail() == null) {
			result.addError(new ObjectError("Usuario", "Email não informado!"));
			return;
		}
	}

	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> findById(@PathVariable("id") Long id) {
		Response<Usuario> response = new Response<Usuario>();
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			response.getErros().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setDados(usuario);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id) {
		Response<String> response = new Response<String>();
		Usuario usuario = usuarioService.findById(id);
		if (usuario == null) {
			response.getErros().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		usuarioService.delete(id);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Page<Usuario>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<Usuario>> response = new Response<Page<Usuario>>();
		Page<Usuario> usuarios = usuarioService.findAll(page, count);
		response.setDados(usuarios);
		return ResponseEntity.ok(response);
	}
}
