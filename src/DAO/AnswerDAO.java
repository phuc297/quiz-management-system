package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.AnswerDTO;

public class AnswerDAO {

    public ArrayList<AnswerDTO> getAllAnswers() {
        String query = "select * from Answer";
        return ResultSetToData.toAnswer(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public void insertAnswer(ArrayList<AnswerDTO> answers) {
        for (AnswerDTO answer : answers) {
            String query = String.format("exec InsertAnswer %d, %d, %d, '%s';",
                    answer.getExamId(),
                    answer.getStudentId(),
                    answer.getQuestionId(),
                    answer.getAnswer()
            );
            QueryExecutor.getInstance().ExcuteNonQuery(query);
        }
    }

    public boolean submitExam(int examId, int studentId) {
        String query = String.format("exec SubmitAnswer %s, %s;", examId, studentId);
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    public void insert(ArrayList<AnswerDTO> answers) {
        for (AnswerDTO a : answers) {
            String query = String.format("INSERT INTO Result VALUES (%d, %d, '%s', %d);",
                    a.getResultId(),
                    a.getQuestionId(),
                    a.getAnswer(),
                    a.getIsCorrect()
            );
            QueryExecutor.getInstance().ExcuteNonQuery(query);
        }
    }

}
