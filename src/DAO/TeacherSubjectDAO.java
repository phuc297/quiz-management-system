package DAO;

import CONNECT.QueryExecutor;

public class TeacherSubjectDAO {

    public boolean insert(int teacherId, int subjectId) {
        String query = "insert into TeacherSubject (teacher_id, subject_id) values (" + teacherId + ", " + subjectId + ");";
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    public boolean remove(int teacherId, int subjectId) {
        String query = "DELETE TeacherSubject WHERE teacher_id = " + teacherId + " AND subject_id = " + subjectId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }
}
