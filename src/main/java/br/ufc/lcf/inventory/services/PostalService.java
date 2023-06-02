package br.ufc.lcf.inventory.services;

import br.ufc.lcf.inventory.entity.PostalDTO;
import br.ufc.lcf.inventory.model.Postal;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PostalService {
  Page<Postal> getAll(int page);
  Postal createPostal(PostalDTO postalDTO);
  List<Postal> getByEmail(String id);
  List<Postal> getByNome(String id);
  void deletePostal(String id);
}
