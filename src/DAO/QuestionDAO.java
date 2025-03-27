package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.QuestionDTO;

public class QuestionDAO implements DAO<QuestionDTO> {

    @Override
    public ArrayList<QuestionDTO> getAll() {
        String query = "exec GetAllQuestions";
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public QuestionDTO get(int questionId) {
        String query = "exec GetQuestionById " + questionId;
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<QuestionDTO> getAllOfTeacher(int teacherId) {
        String query = "exec GetQuestionsInTeacher " + teacherId;
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<QuestionDTO> getAllOfExam(int examId) {
        String query = "exec GetQuestionsInExam " + examId;
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<QuestionDTO> getAllOfSubject(int subjectId) {
        String query = "exec GetQuestionsInSubject " + subjectId;
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<QuestionDTO> getAllOrderbySubject() {
        String query = "exec GetAllQuestionsOrderBySubject";
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<QuestionDTO> getOrderbySubject(int teacherId) {
        String query = "exec GetQuestionsOrderBySubject " + teacherId;
        return ResultSetToData.toQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public boolean insert(QuestionDTO o) {
        String query = String.format("INSERT INTO Question VALUES (N'%s', N'%s', N'%s', N'%s', N'%s', '%s', %d)",
                o.getQuestionText(),
                o.getOptionA(),
                o.getOptionB(),
                o.getOptionC(),
                o.getOptionD(),
                o.getCorrectAnswer(),
                o.getSubjectId()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int questionId) {
        String query = "DELETE Question WHERE question_id = " + questionId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean update(QuestionDTO o) {
        String query = String.format("UpdateQuestion %d, N'%s', N'%s', N'%s', N'%s', N'%s', '%s'",
                o.getQuestionId(),
                o.getQuestionText(),
                o.getOptionA(),
                o.getOptionB(),
                o.getOptionC(),
                o.getOptionD(),
                o.getCorrectAnswer()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

}
