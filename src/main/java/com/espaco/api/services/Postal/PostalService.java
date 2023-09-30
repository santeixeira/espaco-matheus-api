package com.espaco.api.services.Postal;

import com.espaco.api.models.Postal;
import com.espaco.api.validators.PostalDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostalService {
    Page<Postal> getAll(int page);
    Postal createPostal(PostalDTO postalDTO);
    List<Postal> getByEmail(String email);
    List<Postal> getByNome(String id);
    void deletePostal(String id);
}
