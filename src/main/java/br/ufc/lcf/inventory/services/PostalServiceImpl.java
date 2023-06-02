package br.ufc.lcf.inventory.services;

import br.ufc.lcf.inventory.entity.PostalDTO;
import br.ufc.lcf.inventory.model.Postal;
import br.ufc.lcf.inventory.repository.PostalRepository;
import br.ufc.lcf.inventory.services.PostalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostalServiceImpl implements PostalService {

    private final PostalRepository postalRepository;

    @Override
    public Page<Postal> getAll(int page) {
        Pageable pageable = PageRequest.of(page, 15, Sort.by("date").descending());
        return postalRepository.findAll(pageable);
    }

    @Override
    public Postal createPostal(PostalDTO postalDTO) {
        Postal data = Postal.builder()
                .name(postalDTO.name())
                .phone(postalDTO.phone())
                .email(postalDTO.email())
                .message(postalDTO.message())
                .date(LocalDateTime.now()).build();
        return postalRepository.save(data);
    }

    @Override
    public List<Postal> getByEmail(String id) {
        return null;
    }

    @Override
    public List<Postal> getByNome(String id) {
        return null;
    }

    @Override
    public void deletePostal(String id) {

    }
}
