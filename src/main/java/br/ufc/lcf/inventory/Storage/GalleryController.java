package br.ufc.lcf.inventory.Storage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class GalleryController {
    private final GalleryService galleryService;

    @PostMapping("/galeria/post")
    public ResponseEntity<Gallery> uploadFile(@RequestParam("image") MultipartFile file, GalleryDTO galleryDTO) throws IOException {
        Gallery uploadImage = galleryService.uploadFile(file, galleryDTO);
        return ResponseEntity.ok().body(uploadImage);
    }

    @GetMapping("/galeria/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable String id) {
        byte[] image = galleryService.downloadFile(id);
        return ResponseEntity.ok().contentType(MediaType.valueOf("image/png")).body(image);
    }
}
