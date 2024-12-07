package com.java.quiz.quizservice.feign;

import com.java.quiz.quizservice.model.QuestionWrapper;
import com.java.quiz.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/api/question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String catagoryName, @RequestParam Integer numQuestions);

    @PostMapping("/api/question//getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/api/question//getScore")
    public ResponseEntity<String> getScore(@RequestBody List<Response> responses);
}
