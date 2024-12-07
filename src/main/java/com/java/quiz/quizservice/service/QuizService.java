package com.java.quiz.quizservice.service;

import com.java.quiz.quizservice.entity.Quiz;
import com.java.quiz.quizservice.exception.InvalidDataException;
import com.java.quiz.quizservice.feign.QuizInterface;
import com.java.quiz.quizservice.model.QuestionWrapper;
import com.java.quiz.quizservice.model.Response;
import com.java.quiz.quizservice.repository.QuizRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    QuizRepository quizRepository;

    QuizInterface quizInterface;

    public QuizService(QuizRepository quizRepository, QuizInterface quizInterface) {
        this.quizRepository = quizRepository;
        this.quizInterface = quizInterface;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizTitle);
        quiz.setQuestionIds(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>(quizTitle + " quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> optionalId = quizRepository.findById(id);
        if (optionalId.isPresent()) {
            return quizInterface.getQuestionsFromId(optionalId.get().getQuestionIds());
        }
        else{
            throw new InvalidDataException("Id Not Found");
        }
    }

    public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> optionalId = quizRepository.findById(id);
        if (optionalId.isPresent()) {
            return quizInterface.getScore(responses);
        }
        else{
            throw new InvalidDataException("Id Not Found");
        }
    }
}
