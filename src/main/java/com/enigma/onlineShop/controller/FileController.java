package com.enigma.onlineShop.controller;

import com.enigma.onlineShop.entity.FileStorage;
import com.enigma.onlineShop.service.impl.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FileStorageService fileStorageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileStorage uploadFile(@RequestPart("file")MultipartFile file){
        return fileStorageService.storageFile(file);
//        return FileStorage.builder()
//                .filename(file.getOriginalFilename())
//                .dateTime(LocalDateTime.now())
//                .build();
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){
        Resource resource;
        try {
            resource = fileStorageService.downloadFile(filename);
        }catch (FileNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+ "\"")
                .body(resource);
    }
}
