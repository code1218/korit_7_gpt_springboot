package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqSignupDto;
import com.korit.springboot_study.entity.User;
import com.korit.springboot_study.entity.UserRole;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.repository.UserRepository;
import com.korit.springboot_study.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional(rollbackFor = Exception.class)
    public User signup(ReqSignupDto reqSignupDto) {
        User user = reqSignupDto.toUser(passwordEncoder);
        User saveUser = userRepository
                .save(user)
                .orElseThrow(() -> new CustomDuplicateKeyException("이미 존재하는 사용자이름입니다.", Map.of("username", "이미 존재하는 사용자이름입니다.")));
        userRoleRepository.save(UserRole.builder()
                        .userId(user.getUserId())
                        .roleId(1)
                        .build());
        return saveUser;
    }
}










