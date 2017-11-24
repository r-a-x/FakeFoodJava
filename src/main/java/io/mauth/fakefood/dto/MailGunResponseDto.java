
package io.mauth.fakefood.dto;

import java.io.Serializable;

public class MailGunResponseDto implements Serializable {

    private String id;

    private String message;

    public MailGunResponseDto() {

    }

    public MailGunResponseDto(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
