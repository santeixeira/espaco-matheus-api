package com.espaco.api.services.Gallery;

import com.espaco.api.models.Gallery;
import com.espaco.api.repository.GalleryRepository;
import com.espaco.api.utils.GalleryUtil;
import com.espaco.api.validators.GalleryDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepo;

    @Override
    public Gallery uploadFile(MultipartFile file, GalleryDTO galleryDTO) {
        Gallery gallery = new Gallery();
        try {
            gallery = galleryRepo.save(Gallery.builder()
                    .name(file.getOriginalFilename())
                    .description(galleryDTO.description())
                    .type(file.getContentType())
                    .imagePath(GalleryUtil.compressImage(file.getBytes())).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gallery;
    }

    @Override
    public byte[] downloadFile(String id) {
        return null;
    }

    @Override
    public List<Gallery> getAllImages() {
        return galleryRepo.findAll(Sort.by("galleryId").descending());
    }
}
