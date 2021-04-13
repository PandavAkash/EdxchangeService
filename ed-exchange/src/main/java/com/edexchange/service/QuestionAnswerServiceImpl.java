package com.edexchange.service;

import com.edexchange.entities.Answer;
import com.edexchange.entities.Question;
import com.edexchange.entities.UserEntity;
import com.edexchange.repo.AnswerRepo;
import com.edexchange.repo.QuestionRepo;
import com.edexchange.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Question addQuestion(Question newQuestion) {
        System.out.println("Question: " + newQuestion);
        try {
           UserEntity userEntity =  newQuestion.getCreate_by();
            Optional<UserEntity> user = userRepo.findById(userEntity.getUserId());
            System.out.println("user info: " + user.get());
            if (user.isPresent()) {
                newQuestion.setCreate_by(user.get());
            }
            newQuestion.setCreated_date(Timestamp.valueOf(LocalDateTime.now()));
            newQuestion.setVote(0);
            return questionRepo.save(newQuestion);
        } catch (RuntimeException re) {
            //Exception occured
            re.printStackTrace();
        }
        return null;
    }

    @Override
    public Question getQuestionById(Integer queId) {

        try {
            Optional<Question> result = questionRepo.findById(queId);
            if (result.isPresent()) {
                return result.get();
            }
        } catch (RuntimeException re) {

        }
        return null;
    }

    @Override
    public void addVoteToQuestion(Integer queId) {

        Optional<Question> result = questionRepo.findById(queId);
        if(result.isPresent()){
            Question question = result.get();
            question.setVote(question.getVote()+1);
        }
    }

    @Override
    public List<Question> getAllQuestions() {

        try {
            List<Question> listOfAllQuestions = questionRepo.findAll();
            return listOfAllQuestions;
        } catch (RuntimeException re) {

        }
        return null;
    }

    @Override
    public void getVoteCountByQueId(Integer queId) {

    }

    @Override
    public void addAnswer(Answer newAns) {

    }

    @Override
    public void getAnsById(Integer ansId) {

    }

    @Override
    public void getAllAnsByQueId(Integer queId) {

    }

    @Override
    public void acceptAns(Answer answer) {

    }

    @Override
    public void addVoteToAns(Integer ansId) {

    }

    @Override
    public void getVoteCountByAnsId(Integer ansId) {

    }
}
