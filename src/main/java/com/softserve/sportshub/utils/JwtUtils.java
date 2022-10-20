package com.softserve.sportshub.utils;

import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtils {
    public static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
}
