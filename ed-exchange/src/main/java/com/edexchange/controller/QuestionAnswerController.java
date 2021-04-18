package com.edexchange.controller;


import com.edexchange.entities.Answer;
import com.edexchange.entities.Question;
import com.edexchange.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @PostMapping("/questions/post-que/{userId}")
    public ResponseEntity<String> addNewQuestion(@RequestBody Question question,
                                                 @PathVariable("userId") Long userId) {

        Question savedQuestion = questionAnswerService.addQuestion(userId, question);

        return savedQuestion != null ? new ResponseEntity<String>(HttpStatus.CREATED) :
                new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/questions/get/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Integer id) {

        Question question = questionAnswerService.getQuestionById(id);
        return  new ResponseEntity<Question>(question, new HttpHeaders(),
                question!=null? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }

    @PostMapping("/questions/add-vote/{id}")
    public ResponseEntity<String> addVoteToQuestion(@PathVariable("id") Integer id) {
            try {
                questionAnswerService.addVoteToQuestion(id);
                return new ResponseEntity<String>(HttpStatus.OK);
            }catch (RuntimeException e) {
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @GetMapping("/questions/get-all")
    public ResponseEntity<List<Question>> getAllQuestions() {

        List<Question> allQuestions = questionAnswerService.getAllQuestions();
        return new ResponseEntity<List<Question>>(allQuestions, new HttpHeaders(),
                allQuestions!=null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }


    @PostMapping("/answers/post-ans/{queId}/{userId}")
    public ResponseEntity<String> addNewAns(@PathVariable("queId")Integer queId,
                                            @PathVariable("userId")Long userId,
                                            @RequestBody Answer answer) {
        Answer savedAnswer = questionAnswerService.addAnswer(queId, userId, answer);

        return savedAnswer != null ? new ResponseEntity<String>(HttpStatus.CREATED) :
                new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/answers/get-ans/{id}")
    public ResponseEntity<Answer> getAns(@PathVariable("id")Integer ansId) {
        Answer answer = questionAnswerService.getAnsById(ansId);
        return new ResponseEntity<Answer>(answer, new HttpHeaders(),
                answer!=null? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

    @PostMapping("/answers/accept-ans/{id}")
    public ResponseEntity<String> acceptAns(@PathVariable("id")Integer ansId) {
        try {
            questionAnswerService.acceptAns(ansId);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (RuntimeException e) {
           return  new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/answers/add-vote/{id}")
    public ResponseEntity<String> addVoteToAns(@PathVariable("id")Integer ansId) {

        try {
            questionAnswerService.addVoteToAns(ansId);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return  new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/answers/get-all")
    public void getAllAns() {

    }
}
 