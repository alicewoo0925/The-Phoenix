package com.phoenix.qpproject.service;

import com.phoenix.qpproject.dto.QuestionOptionsDTO;
import com.phoenix.qpproject.dto.QuestionsDTO;
import com.phoenix.qpproject.dto.QuizzesDTO;
import com.phoenix.qpproject.mapper.QuizMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizService {

    //DI 의존성 주입 생성자 메서드 주입방식
    private QuizMapper quizMapper;

    public QuizService(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public List<QuizzesDTO> getQuizListByMember(){
        List<QuizzesDTO> quizList = quizMapper.getQuizListByMember();
        return quizList;
    }

    public List<QuizzesDTO> getQuizList(){
        List<QuizzesDTO> quizList = quizMapper.getQuizList();
        return quizList;
    }

    public void addQuiz(QuizzesDTO quiz) {
        quizMapper.addQuiz(quiz);
    }

    public int getRecentQuizIdOfMember(int memberId){
        return quizMapper.getRecentQuizIdOfMember(memberId);
    }

    public void addQuestion(QuestionsDTO question){
        quizMapper.addQuestion(question);
    }

    public int getRecentQuestionIdOfQuiz(int memberId){
        return quizMapper.getRecentQuestionIdOfQuiz(memberId);
    }

    public void addOptions(QuestionOptionsDTO qo){
        quizMapper.addOptions(qo);
    }
    public List<QuestionsDTO> getQsWhereQuizId(int quizId){
        return quizMapper.getQsWhereQuizId(quizId);
    }
}
