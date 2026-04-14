package com.yazzzeh.twilio.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.yazzzeh.twilio.dtos.SmsRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.from-number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getToPhone())) {
            String message = smsRequest.getMessage();
            Message.creator(
                    new PhoneNumber(smsRequest.getToPhone()),
                    new PhoneNumber(fromNumber),
                    message
            ).create();
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getToPhone() + "] is not a valid number"
            );
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return true;
    }
}
