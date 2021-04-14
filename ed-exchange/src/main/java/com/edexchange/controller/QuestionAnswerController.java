package com.edexchange.controller;


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

    @PostMapping("/questions/post-que")
    public ResponseEntity<String> addNewQuestion(@RequestBody Question question) {

        Question savedQuestion = questionAnswerService.addQuestion(question);

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


    @PostMapping("/answers/post-ans")
    public void addNewAns() {

    }

    @GetMapping("/answers/get-ans/{id}")
    public void getAns() {

    }

    @PostMapping("/answers/add-vote")
    public void addVoteToAns() {

    }

    @GetMapping("/answers/get-all")
    public void getAllAns() {

    }
}
