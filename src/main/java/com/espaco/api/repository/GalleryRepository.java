package com.espaco.api.repository;

import com.espaco.api.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
//    List<Gallery> getDescending();
    List<Gallery> findByDescription(String description);
}