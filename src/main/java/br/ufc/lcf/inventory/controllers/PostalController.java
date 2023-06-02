package br.ufc.lcf.inventory.controllers;

import br.ufc.lcf.inventory.model.Postal;
import br.ufc.lcf.inventory.services.PostalService;
import br.ufc.lcf.inventory.Util.General;
import br.ufc.lcf.inventory.entity.PostalDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    URI uri = General.toUri("/postal/create");
    Postal postal = postalService.createPostal(postalDTO);
    return ResponseEntity.created(uri).body(postal);
  }

}
