package com.shiv.user.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shiv.restfill.app.RestFullWebServiceApp.User;
import com.shiv.user.exception.UserNotForndException;
import com.shiv.user.service.UserService;

@RestController
public class UserController
{

    @Autowired
    private UserService mUserService;

    @RequestMapping( path = "/sayHi" )
    public String sayHi()
    {
        return "Hellow Shiva Here";
    }

    @GetMapping( path = "/users" )
    public List<User> getUsers()
    {
        return mUserService.getUsers();

    }

    @GetMapping( path = "/users/{id}" )
    public Resource<User> getUser( @PathVariable int id )
    {
        User user = mUserService.getUser( id );

        if( null == user )
        {
            throw new UserNotForndException( "User not found for id " + id );
        }

        Resource<User> resource = new Resource<User>( user );

        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo( ControllerLinkBuilder.methodOn( this.getClass() ).getUsers() );
        resource.add( linkto.withRel( "all-users" ) );

        return resource;

    }

    @PostMapping( path = "/users" )
    public ResponseEntity<Object> createUser( @Valid @RequestBody User user )
    {
        User createdUser = mUserService.createUser( user );

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}" ).buildAndExpand( createdUser.getId() ).toUri();

        return ResponseEntity.created( uri ).build();

    }

}
