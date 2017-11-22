package io.mauth.fakefood.dto;

import java.io.Serializable;

/**
 * Created by rahulb on 4/11/17.
 */
public class ResponseDto implements Serializable {
    private Boolean success ;
    private String messsage;

    public ResponseDto(Boolean success, String messsage) {
        this.success = success;
        this.messsage = messsage;
    }

    public ResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
