package com.theeventsspringboot.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.theeventsspringboot.security.jwt.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_KEY_EXPIRED = "exp";

	// VARIAVEL CONFIGURADA NO ARQUIVO application.properties
	@Value("${jwt.secret}")
	private String secret;

	// VARIAVEL CONFIGURADA NO ARQUIVO application.properties
	@Value("${jwt.expiration}")
	private Long expiration;

	/**
	 * METODO Q SERVE P/ OBTER O EMAIL Q ESTA DENTRO DO token
	 * 
	 * @param token
	 * @return O EMAIL DO USUARIO
	 */
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * METODO Q SERVE P/ RETORNAR A DATA D EXPIRACAO DO token JWT
	 * 
	 * @param token
	 * @return RETORNA A DATA D EXPIRACAO DO token
	 */
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * METODO Q REALIZA O parse (ANALISE) DO token JWT P/ EXTRAIR AS INFORMACOES
	 * CONTIDAS NO CORPO DELE
	 * 
	 * @param token
	 * @return AS INFORMACOES
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * METODO Q SERVE P/ VERIFICAR O TEMPO D EXPIRACAO DO token
	 * 
	 * @param token
	 * @return FALSE/TRUE DEPENDENDO DO TEMPO DE EXPIRACAO
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * METODO RESPONSAVEL POR GERAR O token
	 * 
	 * @param userDetails
	 * @return O METODO AUXILIAR doGenerateToken() C/ O TOKEN
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();

		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

		final Date createdDate = new Date();
		claims.put(CLAIM_KEY_CREATED, createdDate);

		//
		return doGenerateToken(claims);
	}

	/**
	 * METODO AUXILIAR NA GERACAO DO token
	 * 
	 * @param claims
	 * @return O token GERADO
	 */
	private String doGenerateToken(Map<String, Object> claims) {
		final Date createdDate = (Date) claims.get(CLAIM_KEY_CREATED);
		final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	/**
	 * METODO Q SERVE P VERIFICAR SE O TOKNE PODE SER ATUALIZADO
	 * 
	 * @param token
	 * @return false/true SE O token PODE OU N SER ATUALIAZADO
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token));
	}

	/**
	 * METODO Q SERVE PARA DAR O refreshed (ATUALIZAR) NO token
	 * 
	 * @param token
	 * @return O token ATUALIZADO
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = doGenerateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	/**
	 * METODO Q VERIFICA SE O token ESTA VALIDO!
	 * 
	 * @param token
	 * @param userDetails
	 * @return false/true SE O token ESTA VALIDO OU N
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}
}
