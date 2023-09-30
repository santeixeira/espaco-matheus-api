package com.espaco.api.services.Gallery;

import com.espaco.api.models.Gallery;
import com.espaco.api.validators.GalleryDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryService {
    Gallery uploadFile(MultipartFile file, GalleryDTO galleryDTO);
    byte[] downloadFile(String id);
    List<Gallery> getAllImages();
}
