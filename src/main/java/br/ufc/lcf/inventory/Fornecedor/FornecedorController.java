package br.ufc.lcf.inventory.Fornecedor;

import br.ufc.lcf.inventory.Util.General;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api")
public class FornecedorController {
  @Autowired
  private FornecedorService fornecedorService;

  @GetMapping("/fornecedores")
  public ResponseEntity<Page<Fornecedor>> index(@RequestParam int page, @RequestParam int size) {
    return ResponseEntity.ok().body(fornecedorService.getFornecedores(page, size));
  }

  @PostMapping("/fornecedores/post")
  public ResponseEntity<Fornecedor> post(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
    URI uri = General.toUri("/fornecedores/post");
    return ResponseEntity.created(uri).body(fornecedorService.postFornecedor(fornecedorDTO));
  }
}
