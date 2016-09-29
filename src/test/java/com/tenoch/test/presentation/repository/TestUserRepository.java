package com.tenoch.test.presentation.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;

import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;
import com.tenoch.presentation.WebPresentationApplication;
import com.tenoch.presentation.internal.User;
import com.tenoch.presentation.repository.user.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WebPresentationApplication.class)
public class TestUserRepository {

	@Autowired
	private IUserRepository repo;

	@Test
	public void testSaveUser(){
		User user = new User();
		user.setEmail("admin2@dventura.net");
		user.setEnable(true);
		user.setName("Administrador2");
		user.setPassword(Sha512DigestUtils.shaHex("admin123"));
		Set<String> roles = new HashSet<>();
		roles.add("ADMIN");
		roles.add("CLIENT");
		user.setRoles(roles);
		user.setUser("admin2");

		repo.save(user);
		User user2 = repo.findByUser(user.getUser());
		System.out.println("user2: " + user2.getId() + " - " + user2.getUser());
		repo.delete(user2);
	}
}
