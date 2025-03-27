package BUS;

import DAO.ExamQuestionDAO;
import DTO.ExamQuestionDTO;
import java.util.ArrayList;

public class ExamQuestionBUS {

    private ExamQuestionDAO dao;

    public ExamQuestionBUS() {
        dao = new ExamQuestionDAO();
    }

    public ArrayList<ExamQuestionDTO> getAllExamQuestion() {
        return dao.getAllExamQuestions();
    }

    public boolean insert(ExamQuestionDTO o) {
        return dao.insert(o);
    }
}
