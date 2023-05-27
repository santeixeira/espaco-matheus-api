package br.ufc.lcf.inventory.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


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
        Gallery gallery = galleryRepo.findById(id).orElseThrow(null);
        if(gallery != null) {
            return GalleryUtil.decompressImage(gallery.getImagePath());
        } else { return null; }

    }
}

