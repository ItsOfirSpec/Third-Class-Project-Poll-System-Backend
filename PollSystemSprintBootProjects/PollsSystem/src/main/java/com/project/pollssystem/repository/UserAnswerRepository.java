package com.project.pollssystem.repository;
import com.project.pollssystem.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
    List<UserAnswer> findByQuestionId(Integer questionId);
    List<UserAnswer> findByUserId(Integer userId);
}
