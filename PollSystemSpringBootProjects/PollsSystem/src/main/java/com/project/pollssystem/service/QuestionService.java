package com.project.pollssystem.service;
import com.project.pollssystem.model.Question;
import com.project.pollssystem.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public Question createQuestion(Question q) {
        return repository.save(q);
    }

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    public Question getQuestionById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public Question updateQuestion(Integer id, Question q) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(q.getTitle());
                    existing.setOption1(q.getOption1());
                    existing.setOption2(q.getOption2());
                    existing.setOption3(q.getOption3());
                    existing.setOption4(q.getOption4());
                    return repository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public void deleteQuestion(Integer id) {
        repository.deleteById(id);
    }
}
