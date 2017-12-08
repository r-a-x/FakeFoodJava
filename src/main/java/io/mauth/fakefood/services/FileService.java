package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.FilePathDto;
import io.mauth.fakefood.repo.FileRepo;
import io.mauth.fakefood.util.Utility;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by rahulb on 3/12/17.
 */
@Service
@Transactional
@Loggable
public class FileService  {

    @Autowired
    private FileRepo fileRepo;

    @Value("${file.location}")
    private String dir;

    private String saveFile(MultipartFile multipartFile) throws IOException {
        String fileName = Utility.getRandomName();
        String filePath = dir+'/' + fileName ;
        File file = new  File(filePath);
        if (file.createNewFile()){
            System.out.print("File created");

        }else{
            throw new FileNotFoundException("Unable to create File");
        }

        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        IOUtils.closeQuietly(outputStream);

        io.mauth.fakefood.model.File savedFile = new io.mauth.fakefood.model.File();
        savedFile.setName(fileName);
        savedFile.setPath(filePath);

        fileRepo.save(savedFile);
        return fileName;

    }
    public FilePathDto uploadFile(MultipartFile logoMultipartFile, MultipartFile backMultiPartFile, MultipartFile frontMultipartFile) throws IOException {
        String logoImageName = saveFile(logoMultipartFile);
        String backImageName = saveFile(backMultiPartFile);
        String frontImageName = saveFile(frontMultipartFile);
        FilePathDto filePathDto = new FilePathDto();
        filePathDto.setBackImageName(backImageName);
        filePathDto.setFrontImageName(frontImageName);
        filePathDto.setLogoImageName(logoImageName);
        return filePathDto;
    }

    public ResponseEntity<byte[]> getFile(String fileName) throws IOException {
        io.mauth.fakefood.model.File file = fileRepo.findByName(fileName);
        if ( file == null)
            throw new FileNotFoundException();
        File systemFile = new File(file.getPath());
        byte[] filebytes = org.apache.commons.io.FileUtils.readFileToByteArray(systemFile);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(filebytes);

    }
}
