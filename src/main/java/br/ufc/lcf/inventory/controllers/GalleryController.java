package br.ufc.lcf.inventory.controllers;

import br.ufc.lcf.inventory.entity.GalleryDTO;
import br.ufc.lcf.inventory.services.GalleryService;
import br.ufc.lcf.inventory.model.Gallery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin(value = "http://matheuscarneiro.art")
@RequiredArgsConstructor
@RequestMapping("/api")
public class GalleryController {
    private final GalleryService galleryService;

    @GetMapping("/galeria")
    public ResponseEntity<List<Gallery>> getAll() {
        return ResponseEntity.ok().body(galleryService.getAllImages());
    }

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
