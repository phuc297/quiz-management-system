package BUS;

import DAO.TeacherSubjectDAO;

public class TeacherSubjectBUS {

    private TeacherSubjectDAO dao;

    public TeacherSubjectBUS() {
        dao = new TeacherSubjectDAO();
    }

    public boolean insert(int teacherId, int subjectId) {
        return dao.insert(teacherId, subjectId);
    }

    public boolean remove(int teacherId, int subjectId) {
        return dao.remove(teacherId, subjectId);
    }
}
