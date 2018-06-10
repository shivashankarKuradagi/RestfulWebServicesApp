package com.shiv.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shiv.restfill.app.RestFullWebServiceApp.User;

@Service
public class UserService
{

    public static List<User> users = new ArrayList<>();
    int count = 4;

    static
    {
        users.add( new User( 1, "Shiva", new Date() ) );
        users.add( new User( 2, "Sai", new Date() ) );
        users.add( new User( 3, "Ved", new Date() ) );
        users.add( new User( 4, "Vidya", new Date() ) );
    }

    public List<User> getUsers()
    {
        return users;

    }

    public User getUser( int id )
    {
        for( User user : users )
        {
            if( id == user.getId() )
            {
                return user;
            }
        }
        return null;
    }

    public User createUser( User user )
    {
        user.setId( ++count );
        users.add( user );
        return user;
    }

    public void deleteUser( User user )
    {

    }

    public void deleteUserByID( int id )
    {

    }

}
