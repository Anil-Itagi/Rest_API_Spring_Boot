package com.example.rest_api_app.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "C:\\Users\\itagi\\Downloads\\rest_api_app\\rest_api_app\\src\\main\\resources\\static\\images";

    public boolean uploadFile(MultipartFile f) {
        boolean b = false;

        try {
            //
            InputStream is = f.getInputStream();
            byte data[] = new byte[is.available()];

            is.read(data);
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + f.getOriginalFilename());
            fos.flush();
            fos.close();
            b = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return b;
    }
}
