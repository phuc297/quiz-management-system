package BUS;

import DTO.ExamStudentDTO;
import DAO.ExamStudentDAO;

public class ExamStudentBUS {

    private ExamStudentDAO dao;

    public ExamStudentBUS() {
        dao = new ExamStudentDAO();
    }

    public boolean insertClass(ExamStudentDTO o) {
        return dao.insertClass(o);
    }
}
