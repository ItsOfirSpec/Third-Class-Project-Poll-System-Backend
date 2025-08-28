package com.project.pollssystem.service;
import com.project.pollssystem.Dtos.UserDto;
import com.project.pollssystem.client.UserClient;
import com.project.pollssystem.model.UserAnswer;
import com.project.pollssystem.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAnswerService {
    @Autowired
    private UserAnswerRepository repository;
    @Autowired
    private UserClient userClient; // Feign client

    public UserAnswer submitAnswer(UserAnswer answer) {
        // Check if user exists in Users System
        ResponseEntity<UserDto> userResponse = userClient.getUserById(answer.getUserId());
        if (!userResponse.getStatusCode().is2xxSuccessful() || userResponse.getBody() == null) {
            throw new RuntimeException("User does not exist. Cannot submit answer.");
        }

        // Set timestamp and save
        answer.setAnswerDate(LocalDateTime.now());
        return repository.save(answer);
    }

    public List<UserAnswer> getAnswersByQuestionId(Integer questionId) {
        return repository.findByQuestionId(questionId);
    }

    public List<UserAnswer> getAnswersByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
}