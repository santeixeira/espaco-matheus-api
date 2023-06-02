package br.ufc.lcf.inventory.services;
import br.ufc.lcf.inventory.Util.GalleryUtil;
import br.ufc.lcf.inventory.entity.GalleryDTO;
import br.ufc.lcf.inventory.model.Gallery;
import br.ufc.lcf.inventory.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepo;

    @Override
    public List<Gallery> getAllImages() {
        return galleryRepo.getAll();
    }


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
        Gallery gallery = galleryRepo.findById(id).orElseThrow(null);
        if(gallery != null) {
            return GalleryUtil.decompressImage(gallery.getImagePath());
        } else { return null; }

    }
}

