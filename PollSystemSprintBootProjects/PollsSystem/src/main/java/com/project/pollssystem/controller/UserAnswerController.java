package com.project.pollssystem.controller;
import com.project.pollssystem.model.UserAnswer;
import com.project.pollssystem.service.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/answers")
@RequiredArgsConstructor
public class UserAnswerController {

    @Autowired
    private UserAnswerService service;

    @PostMapping
    public UserAnswer submit(@RequestBody UserAnswer answer) {
        return service.submitAnswer(answer);
    }

    @GetMapping("/question/{questionId}")
    public List<UserAnswer> getByQuestion(@PathVariable Integer questionId) {
        return service.getAnswersByQuestionId(questionId);
    }

    @GetMapping("/user/{userId}")
    public List<UserAnswer> getByUser(@PathVariable Integer userId) {
        return service.getAnswersByUserId(userId);
    }
}
