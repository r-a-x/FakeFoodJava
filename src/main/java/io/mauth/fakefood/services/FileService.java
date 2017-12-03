package io.mauth.fakefood.services;

import io.mauth.fakefood.dto.FilePathDto;
import io.mauth.fakefood.repo.FileRepo;
import io.mauth.fakefood.util.Utility;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by rahulb on 3/12/17.
 */
@Service
@Transactional
public class FileService  {

    @Autowired
    private FileRepo fileRepo;

    @Value("${file.location}")
    private String dir;

    public FilePathDto uploadFile(MultipartFile multipartFile) throws IOException {
        String fileName = Utility.getRandomName();
        String filePath = dir+'/' + fileName ;
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        IOUtils.closeQuietly(outputStream);

        io.mauth.fakefood.model.File savedFile = new io.mauth.fakefood.model.File();
        savedFile.setName(fileName);
        savedFile.setPath(filePath);

        fileRepo.save(savedFile);

        return new FilePathDto(fileName);
    }

}
