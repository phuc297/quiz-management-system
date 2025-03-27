package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.ExamQuestionDTO;

public class ExamQuestionDAO {

    public ArrayList<ExamQuestionDTO> getAllExamQuestions() {
        String query = "select * from ExamQuestion";
        return ResultSetToData.toExamQuestion(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public boolean insert(ExamQuestionDTO o) {
        String query = "INSERT INTO ExamQuestion VALUES (" + o.getExamId() + ", " + o.getQuestionId() + ")";
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

}
