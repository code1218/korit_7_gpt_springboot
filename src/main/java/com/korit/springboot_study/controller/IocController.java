package com.korit.springboot_study.controller;

import com.korit.springboot_study.ioc.ClassA;
import com.korit.springboot_study.ioc.ClassB;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IocController {

    private final ClassA a;
    private final ClassB b;

    @GetMapping("/api/ioc")
    public ResponseEntity<?> call() {
        a.classCallA();
        b.classCallB();
        return ResponseEntity.ok(null);
    }
}
