package com.espaco.api.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ServerRoutines {
    public static URI toUri (String path) {
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .toString());
    }

    // public static String encode(String password) {
    //     return new BCryptPasswordEncoder().encode(password);
    // }
}
