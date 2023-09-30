package com.espaco.api.controllers;

import com.espaco.api.models.Postal;
import com.espaco.api.services.Postal.PostalService;
import com.espaco.api.utils.ServerRoutines;
import com.espaco.api.validators.PostalDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin(value = {"https://matheuscarneiro.netlify.app", "https://matheuscarneiro.art"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostalController {

    private final PostalService postalService;

    @GetMapping("/postal")
    public ResponseEntity<Page<Postal>> index(@RequestParam int page) {
        Page<Postal> data = postalService.getAll(page);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/postal/create")
    public ResponseEntity<Postal> create(@RequestBody @Valid PostalDTO postalDTO) {
        URI uri = ServerRoutines.toUri("/postal/create");
        Postal postal = postalService.createPostal(postalDTO);
        return ResponseEntity.created(uri).body(postal);
    }

}