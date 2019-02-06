package com.cts.newsarticle.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.newsarticle.bean.JwtUser;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.controller.UserController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtGenerator.class);
    public String generate(User user) {


        Claims claims = Jwts.claims().setSubject(user.getName());
		claims.put("userId", String.valueOf(user.getId()));
		claims.put("role", user.getRole().getName());
		LOGGER.info("end jwt generator");
		return (Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "newsarticle").compact());
    }
}
