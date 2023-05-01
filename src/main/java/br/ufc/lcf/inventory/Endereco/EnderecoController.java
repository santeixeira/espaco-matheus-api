package br.ufc.lcf.inventory.Endereco;

import br.ufc.lcf.inventory.Util.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api")
public class EnderecoController {
  @Autowired
  private EnderecoService enderecoService;

  @GetMapping("/endereco")
  public ResponseEntity<Page<Endereco>> index(@RequestParam int page, @RequestParam int size){
    Page<Endereco> data = enderecoService.getEndereco(page, size);
    return ResponseEntity.ok().body(data);
  }

  @PostMapping("/endereco/post")
  public ResponseEntity<Endereco> post(@RequestBody @Valid EnderecoDTO enderecoDTO) {
    URI uri = General.toUri("/endereco/post");
    Endereco data = enderecoService.postUser(enderecoDTO);
    return ResponseEntity.created(uri).body(data);
  }
}