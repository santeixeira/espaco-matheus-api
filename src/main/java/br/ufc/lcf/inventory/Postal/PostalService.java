package br.ufc.lcf.inventory.Postal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostalService {
  Page<Postal> getAll(int page);
  Postal createPostal(PostalDTO postalDTO);
  List<Postal> getByEmail(String id);
  List<Postal> getByNome(String id);
  void deletePostal(String id);
}
