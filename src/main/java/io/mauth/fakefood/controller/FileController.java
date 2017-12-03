package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.FilePathDto;
import io.mauth.fakefood.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by rahulb on 3/12/17.
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/file/logo",method = RequestMethod.POST)
    public FilePathDto postFile(@RequestParam("logoImage")MultipartFile multipartFile) throws IOException {
            return fileService.uploadFile(multipartFile);
    }
}
