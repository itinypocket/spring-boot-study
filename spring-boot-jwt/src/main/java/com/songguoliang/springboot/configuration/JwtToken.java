package com.songguoliang.springboot.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author itinypocket
 * @date 2019-09-03 12:56
 */
@Configuration
public class JwtToken {
	private static Logger logger = LoggerFactory.getLogger(JwtToken.class);
	/**
	 * 秘钥
	 */
	@Value("${jwt.secret}")
	private String secret;

	/**
	 * 过期时间(秒)
	 */
	@Value("${jwt.expire}")
	private long expire;


	/**
	 * 生成jwt token
	 * @author itinypocket
	 * @date 2019-09-03 16:24:33
	 * @param loginName 登录名
	 * @return
	 **/
	public String generateToken(String loginName) {
		Date nowDate = new Date();
		Date expireDate = new Date(nowDate.getTime() + expire * 1000);
		return Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setSubject(loginName)
				.setIssuedAt(nowDate)
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	/**
	 * 反向解析token获取用户信息
	 * @author itinypocket
	 * @date 2019-09-03 16:25:01
	 * @param token
	 * @return
	 **/
	public Claims getClaimByToken(String token) {
		if (StringUtils.isEmpty(token)) {
			return null;
		}

		String[] header = token.split("Bearer");
		token = header[1];
		try {
			return Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			logger.debug("validate is token error ", e);
			return null;
		}
	}

	/**
	 * token是否过期
	 *
	 * @return true：过期
	 */
	public static boolean isTokenExpired(Date expiration) {
		return expiration.before(new Date());
	}
}
