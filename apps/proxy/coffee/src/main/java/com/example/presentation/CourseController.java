package com.example.presentation;

import com.example.application.CourseService;
import com.example.application.SessionRequest;
import com.example.application.SessionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping("/sessions/enroll")
    public SessionResponse enrollSession(@RequestBody SessionRequest request) {
        SessionResponse response = service.enrollSession(request);
        return response;
    }
}