package br.ufc.lcf.inventory.Storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface GalleryService {
    Gallery uploadFile(MultipartFile file, GalleryDTO galleryDTO);
    byte[] downloadFile(String id);
    List<Gallery> getAllImages();
}
