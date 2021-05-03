package com.hackathon.edxchange.queansservice.repo;

import com.hackathon.edxchange.queansservice.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}
