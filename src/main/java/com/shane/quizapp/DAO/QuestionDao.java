package com.shane.quizapp.DAO;

import com.shane.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

    List<Question> findByCategory(String category);


    @Query(value = "SELECT * FROM question WHERE question.category =:category ORDER BY random() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);
}
