package com.hackathon.edxchange.queansservice.service;

import com.hackathon.edxchange.queansservice.entities.Answer;
import com.hackathon.edxchange.queansservice.entities.Question;

import java.util.List;

public interface QuestionAnswerService {

    public Question addQuestion(Long userId, Question newQuestion);

    public Question getQuestionById(Integer queId);

    public void addVoteToQuestion(Integer queId);

    public List<Question> getAllQuestions();

    public void getVoteCountByQueId(Integer queId);

    /*

     */
    public Answer addAnswer(Integer queId, Long userId, Answer newAns);

    public Answer getAnsById(Integer ansId);

    public void getAllAnsByQueId(Integer queId);

    public void acceptAns(Integer queId, Integer ansId);

    public void addVoteToAns(Integer ansId);

    public void getVoteCountByAnsId(Integer ansId);
}
