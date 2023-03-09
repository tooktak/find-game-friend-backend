package com.example.crud.v1.presentation;

import com.example.crud.v1.application.Oauth.TokenResponse;
import com.example.crud.v1.application.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private static final String ENDPOINT = "https://accounts.google.com/o/oauth2/v2/auth";
    private static final String CLIENT_ID = "1033931690858-58kuqhjo9877bcnod4og9jg1av9cusk1.apps.googleusercontent.com";
    private static final String REDIRECT_URI = "http://localhost:8080/oauth/google/callback";
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.profile";

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService; //자기 자신의 값을 가짐
    }


    @GetMapping("/login")
    public String login(){

        return "redirect:" + ENDPOINT + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
                + "&response_type" + RESPONSE_TYPE + "&scope=" + SCOPE;
    }
    //redirect 웹 브라우저가 웹 서버에 어떤 URL을 요청했을 때, 서버가 리다이렉트를 지시하는 특정 HTTP응답을 통해 웹 브라우저로 하여금 지정된 다른 URL로 재요청하라고 지시하는 것


    @GetMapping("/oauth/google/callback")
    public ResponseEntity<TokenResponse> oauthLogin(String code){
        System.out.println(code);
        String token = userService.oauthLogin(code);
        return new ResponseEntity(new TokenResponse(token,"bearer"), HttpStatus.OK);
    }

    /*@Autowired
    private UserService userService;

    @PutMapping("/user/info")
    public Long updateUser(@RequestBody UserUpdateRequest updateRequest){
        return userService.update(updateRequest);
    }
`
    @GetMapping("/user/findUser")
    public List<User> findUser(@PathVariable(value = "userName")String userName){
        return userService.findUser(userName);
    }*/
}
