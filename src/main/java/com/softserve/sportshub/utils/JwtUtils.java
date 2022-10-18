package com.softserve.sportshub.utils;

import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtils {
    //TODO: global file: JWT secret
    public static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
}
