package com.example.rest_api_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.rest_api_app.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    public FileUploadHelper fileUploadHelper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());


        try {
            
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in uploading");
            }
    
            if (file.getContentType().equals("image/jpg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("content type jpeg only allowed");
            }


            boolean f = fileUploadHelper.uploadFile(file);
            if (f) {
                return ResponseEntity.ok("File is successfully uploaded");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ResponseEntity.ok("working");
   }  
}
