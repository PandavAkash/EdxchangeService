package com.hackathon.edxchange.queansservice.repo;

import com.hackathon.edxchange.queansservice.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
