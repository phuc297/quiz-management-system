package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.ExamDTO;

public class ExamDAO implements DAO<ExamDTO> {

    @Override
    public ArrayList<ExamDTO> getAll() {
        String query = "exec GetAllExams";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public ExamDTO get(int examId) {
        String query = "select * from Exam where exam_id = " + examId;
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<ExamDTO> getAllOfStudent(int studentId) {
        String query = "exec GetExamForStudent " + studentId;
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllOfTeacher(int teacherId) {
        String query = "exec GetExamTeacherClass " + teacherId;
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllOrderBySubject() {
        String query = "exec GetAllExamsOrderBySubject";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllPending() {
        String query = "SELECT * FROM Exam e JOIN Subject s ON s.subject_id = e.subject_id WHERE status = 'pending' ORDER BY exam_id DESC";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllInProgress() {
        String query = "SELECT * FROM Exam e JOIN Subject s ON s.subject_id = e.subject_id WHERE status = 'in progress' ORDER BY exam_id DESC";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllFinished() {
        String query = "SELECT * FROM Exam e JOIN Subject s ON s.subject_id = e.subject_id WHERE status = 'finished' ORDER BY exam_id DESC";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ExamDTO> getAllOrderByStatus() {
        String query = "exec GetAllExamsOrderByStatus";
        return ResultSetToData.toExam(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public int getLatestId() {
        String query = "SELECT * FROM Exam ORDER BY exam_id DESC";
        return (int) QueryExecutor.getInstance().ExcuteScalar(query);
    }

    public boolean startExam(int examId) {
        String query = query = "exec StartExam " + examId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    public boolean finishExam(int examId) {
        String query = "UPDATE Exam SET status = 'finished' WHERE exam_id = " + examId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean insert(ExamDTO o) {
        String query = String.format("INSERT INTO Exam (exam_name, subject_id, status, duration, start_time, total_question) VALUES(N'%s', %d, '%s', %d, '%s', %d)",
                o.getExamName(),
                o.getSubjectId(),
                o.getStatus(),
                o.getDuration(),
                o.getStartTime(),
                o.getTotalQuestion()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int examId) {
        String query = "delete Exam WHERE exam_id = " + examId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean update(ExamDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
