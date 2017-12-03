package io.mauth.fakefood.dto;

/**
 * Created by rahulb on 3/12/17.
 */
public class FilePathDto {
    private String fileName;

    public FilePathDto(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
