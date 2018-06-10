package com.shiv.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shiv.restfill.app.RestFullWebServiceApp.User;

@Repository
public interface UserJPAService extends JpaRepository<User, Integer>{

}
