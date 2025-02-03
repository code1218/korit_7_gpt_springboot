package com.korit.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class FirstRestController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello(HttpServletRequest request) {
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "김준일");
    }

    @GetMapping("/api/hello2")
    public Map<String, Object> hello2(@RequestParam int age, @RequestParam String address) {

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "김준일");
    }

    // /api/student/1
    public Map<String, Object> getStudent(int id) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", "11", "name", "최석현", "age", 26));
        students.add(Map.of("id", "22", "name", "백진우", "age", 32));
        students.add(Map.of("id", "33", "name", "이주원", "age", 28));
        students.add(Map.of("id", "44", "name", "정영훈", "age", 26));

        return students.get();
    }
}
