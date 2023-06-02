package br.ufc.lcf.inventory.services;

import br.ufc.lcf.inventory.entity.GalleryDTO;
import br.ufc.lcf.inventory.model.Gallery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface GalleryService {
    Gallery uploadFile(MultipartFile file, GalleryDTO galleryDTO);
    byte[] downloadFile(String id);
    List<Gallery> getAllImages();
}
