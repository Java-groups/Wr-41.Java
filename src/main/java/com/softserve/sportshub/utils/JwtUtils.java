package com.softserve.sportshub.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;

public class JwtUtils {
    public static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

}
