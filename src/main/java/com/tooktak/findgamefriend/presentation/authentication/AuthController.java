package com.tooktak.findgamefriend.presentation.authentication;

import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.presentation.dto.AuthResponse;
import com.tooktak.findgamefriend.presentation.dto.LoginRequest;
import com.tooktak.findgamefriend.presentation.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
//        if(memberRepository.existsByEmail(signUpRequest.getEmail())) {
//            throw new BadRequestException("Email address already in use.");
//        }
//
//        // Creating user's account
//        User user = new User();
//        user.setName(signUpRequest.getName());
//        user.setEmail(signUpRequest.getEmail());
//        user.setPassword(signUpRequest.getPassword());
//        user.setProvider(AuthProvider.local);
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        User result = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/user/me")
//                .buildAndExpand(result.getId()).toUri();
//
//        return ResponseEntity.created(location)
//                .body(new ApiResponse(true, "User registered successfully@"));
        return null;
    }

}
