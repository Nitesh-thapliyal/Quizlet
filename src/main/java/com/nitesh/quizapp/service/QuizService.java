package com.nitesh.quizapp.service;

import com.nitesh.quizapp.dao.QuestionDao;
import com.nitesh.quizapp.dao.QuizDao;
import com.nitesh.quizapp.model.Question;
import com.nitesh.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ, title);

        Quiz quiz  = new Quiz();
        quiz.setTitle(title);
        quiz.setId(numQ);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
