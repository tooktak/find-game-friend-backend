package com.example.crud.v1.presentation.http.util;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.Collections;

public class GoogleIDTokenResolver {
    // https://developers.google.com/identity/gsi/web/guides/verify-google-id-token
    static public UserCreateRequest resolve(String code) throws Exception {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        // TODO: get client code from application setting
        String clientCode = "1033931690858-58kuqhjo9877bcnod4og9jg1av9cusk1.apps.googleusercontent.com";
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(clientCode))
                .build();

        GoogleIdToken idToken = verifier.verify(code);
        if (idToken == null) {
            throw new Exception("Invalid JWT");
        }
        GoogleIdToken.Payload payload = idToken.getPayload();
        String userId = payload.getSubject();
        String email = payload.getEmail();
        return new UserCreateRequest(email, userId);
    }
}
