package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.ResultDTO;
import DTO.Score;

public class ResultDAO {

    public ArrayList<ResultDTO> getAll() {
        String query = "select * from Result";
        return ResultSetToData.toResult(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ResultDTO> getAllByExam(int examId) {
        String query = "exec GetResultByExam " + examId;
        return ResultSetToData.toResult(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ResultDTO> getListStudent(int studentId) {
        String query = "exec GetResultStudent " + studentId;
        return ResultSetToData.toResult(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ResultDTO get(int studentId, int examId) {
        String query = "SELECT * FROM Result WHERE student_id = " + studentId + "AND exam_id = " + examId;
        return ResultSetToData.toResult(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public Score getScore(int examId) {
        String query = "SELECT score, COUNT(*) AS count FROM Result WHERE exam_id = " + examId + " GROUP BY score ORDER BY score";
        return ResultSetToData.toScore(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public double getAvgScore(int examId) {
        String query = "SELECT AVG(score) AS average_score FROM Result WHERE exam_id = " + examId;
        return (double) QueryExecutor.getInstance().ExcuteScalar(query);
    }

    public int getNumber(int examId) {
        String query = "SELECT COUNT(*) AS count FROM Result WHERE exam_id = " + examId;
        return (int) QueryExecutor.getInstance().ExcuteScalar(query);
    }

    public boolean insert(int studentId, int examId) {
        String query = "exec InsertResult " + studentId + ", " + examId + ";";
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }
}
