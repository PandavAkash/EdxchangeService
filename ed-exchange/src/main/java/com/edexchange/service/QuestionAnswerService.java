package com.edexchange.service;

import com.edexchange.entities.Answer;
import com.edexchange.entities.Question;

import java.util.List;

public interface QuestionAnswerService {

    public Question addQuestion(Question newQuestion);

    public Question getQuestionById(Integer queId);

    public void addVoteToQuestion(Integer queId);

    public List<Question> getAllQuestions();

    public void getVoteCountByQueId(Integer queId);

    /*

     */
    public void addAnswer(Answer newAns);

    public void getAnsById(Integer ansId);

    public void getAllAnsByQueId(Integer queId);

    public void acceptAns(Answer answer);

    public void addVoteToAns(Integer ansId);

    public void getVoteCountByAnsId(Integer ansId);
}
