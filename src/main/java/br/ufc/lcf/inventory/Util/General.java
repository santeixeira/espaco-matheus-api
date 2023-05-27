package br.ufc.lcf.inventory.Util;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public interface General {
    public static URI toUri(String path) {
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .toString());
    }




    // public static String encode(String password) {
    //     return new BCryptPasswordEncoder().encode(password);
    // }
}