package com.cts.newsarticle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.newsarticle.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);
	User findUserByName(String name);
}