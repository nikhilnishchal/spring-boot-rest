package com.niknis.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.niknis.cms.model.User;
import com.niknis.cms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService service;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService service, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.service = service;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid User studentEntry) {
		studentEntry.setPassword(bCryptPasswordEncoder.encode(studentEntry.getPassword()));
		service.create(studentEntry);
    }
	
	@RequestMapping(value = "/find/{idUser}", method = RequestMethod.GET)
    public User findByID(@PathVariable String idUser) {
        return service.findByID(idUser);
    }
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<User> list() {
        return service.list();
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public User update(@RequestBody @Valid User studentEntry) {
		return service.update(studentEntry);
    }
	/*
	@RequestMapping(value = "/delete/{idUser}", method = RequestMethod.GET)
    public void delete(@PathVariable Long idUser) {
		service.delete(idUser);
    }*/
}