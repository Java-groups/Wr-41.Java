package com.softserve.sportshub.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;

public class JwtUtils {
    //TODO: global file: JWT secret
    public static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

    public static String getUsernameFromTokenInsideRequest (HttpServletRequest request) throws Exception {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String refresh_token = authHeader.substring("Bearer ".length());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(refresh_token);
            return decodedJWT.getSubject();
        } else {
            throw new Exception("Authorization header is missing or invalid");
        }
    }
}
