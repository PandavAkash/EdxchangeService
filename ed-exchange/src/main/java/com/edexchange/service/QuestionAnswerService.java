package com.edexchange.service;

import com.edexchange.entities.Answer;
import com.edexchange.entities.Question;

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

    public void acceptAns(Integer answer);

    public void addVoteToAns(Integer ansId);

    public void getVoteCountByAnsId(Integer ansId);
}
