package com.project.pollssystem.controller;
import com.project.pollssystem.model.Question;
import com.project.pollssystem.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    @Autowired
    private QuestionService service;

    @PostMapping
    public Question create(@RequestBody Question q) {
        return service.createQuestion(q);
    }

    @GetMapping
    public List<Question> getAll() {
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Integer id) {
        return service.getQuestionById(id);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Integer id, @RequestBody Question q) {
        return service.updateQuestion(id, q);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteQuestion(id);
    }
}
