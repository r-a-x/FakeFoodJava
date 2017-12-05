package io.mauth.fakefood.dto;

/**
 * Created by rahulb on 3/12/17.
 */
public class FilePathDto {
    private String frontImageName;
    private String backImageName;
    private String logoImageName;

    public FilePathDto(String frontImageName, String backImageName, String logoImageName) {
        this.frontImageName = frontImageName;
        this.backImageName = backImageName;
        this.logoImageName = logoImageName;
    }

    public FilePathDto() {
    }

    public String getFrontImageName() {
        return frontImageName;
    }

    public void setFrontImageName(String frontImageName) {
        this.frontImageName = frontImageName;
    }

    public String getBackImageName() {
        return backImageName;
    }

    public void setBackImageName(String backImageName) {
        this.backImageName = backImageName;
    }

    public String getLogoImageName() {
        return logoImageName;
    }

    public void setLogoImageName(String logoImageName) {
        this.logoImageName = logoImageName;
    }
}
