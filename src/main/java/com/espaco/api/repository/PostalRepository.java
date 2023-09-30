package com.espaco.api.repository;

import com.espaco.api.models.Postal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostalRepository extends JpaRepository<Postal, Long> {
    List<Postal> findByEmail(String email);
}
