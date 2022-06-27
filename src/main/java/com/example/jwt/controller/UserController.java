package com.example.jwt.controller;

import com.example.jwt.config.jwt.JwtTokenProvider;
import com.example.jwt.model.Users;
import com.example.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    @PostMapping("/api/join")
    public Long join(@RequestParam Map<String, String> user) {
        return userRepository.save(Users.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    // 로그인
    @PostMapping("/api/login")
    public String login(@RequestParam Map<String, String> user) {

        Users member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> {
                    return new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
                });
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }


}
