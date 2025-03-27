package BUS;

import DAO.ResultDAO;
import DTO.ResultDTO;
import DTO.Score;
import java.util.ArrayList;

public class ResultBUS {

    private ResultDAO dao;

    public ResultBUS() {
        dao = new ResultDAO();
    }

    public ArrayList<ResultDTO> getAll() {
        return dao.getAll();
    }

    public ArrayList<ResultDTO> getAllByExam(int examId) {
        return dao.getAllByExam(examId);
    }

    public ArrayList<ResultDTO> getListStudent(int studentId) {
        return dao.getListStudent(studentId);
    }

    public ResultDTO get(int studentId, int examId) {
        return dao.get(studentId, examId);
    }

    public Score getScore(int examId) {
        return dao.getScore(examId);
    }

    public double getAvgScore(int examId) {
        return dao.getAvgScore(examId);
    }

    public int getNumber(int examId) {
        return dao.getNumber(examId);
    }

    public boolean insert(int studentId, int examId) {
        return dao.insert(studentId, examId);
    }
}
