package com.songguoliang.springboot.controller;

import com.songguoliang.springboot.configuration.JwtToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;
import java.util.Arrays;
import java.util.List;

/**
 * @author itinypocket
 * @date 2019-09-03 12:59
 */
@RestController
public class JwtController {
	@Autowired
	private JwtToken jwtToken;

	@PostMapping("/login")
	public String login(String loginName, String password) {
		// 1. 根据登录名从数据库查询用户,验证用户名和密码，为了简单演示jwt，这里假设验证通过
		// Todo
		// 2. 验证成功生成token，并返回
		String token = jwtToken.generateToken(loginName);
		return token;
	}

	@GetMapping("/getUserInfo")
	public String getUserInfo(@RequestHeader("Authorization") String authHeader) throws AuthenticationException {
		// 黑名单token
		List<String> blacklistToken = Arrays.asList("禁止访问的token");
		Claims claims = jwtToken.getClaimByToken(authHeader);
		if (claims == null || JwtToken.isTokenExpired(claims.getExpiration()) || blacklistToken.contains(authHeader)) {
			throw new AuthenticationException("token 不可用");
		}

		String userId = claims.getSubject();
		// 根据用户id获取接口数据返回接口
		return userId;
	}
}
