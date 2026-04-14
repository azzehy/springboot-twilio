package com.yazzzeh.twilio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public class SmsRequest {

    @NotBlank
    private final String toPhone; // destination

    @NotBlank
    private final String message;

    public SmsRequest(@JsonProperty("toPhone") String toPhone,
                      @JsonProperty("message") String message) {
        this.toPhone = toPhone;
        this.message = message;
    }

    public String getToPhone() {
        return toPhone;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
