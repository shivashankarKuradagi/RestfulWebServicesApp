package com.shiv.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shiv.restfill.app.RestFullWebServiceApp.User;
import com.shiv.user.exception.UserNotForndException;
import com.shiv.user.service.UserJPAService;

@RestController
public class UserJPAController {

	@Autowired
	private UserJPAService jpaService;

	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		System.out.println("Get All users !! ");
		return jpaService.findAll();

	}

	@GetMapping(path = "jpa/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		Optional<User> option = jpaService.findById(id);

		if (!option.isPresent()) {
			throw new UserNotForndException("User not found for id " + id);
		}

		Resource<User> resource = new Resource<User>(option.get());

		ControllerLinkBuilder linkto = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkto.withRel("all-users"));

		return resource;

	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> addUser( @RequestBody User user) {
		User createdUser = jpaService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}" ).buildAndExpand( createdUser.getId() ).toUri();

        return ResponseEntity.created( uri ).build();
	}
	
	@DeleteMapping(params="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		jpaService.deleteById(id);
	}

}
