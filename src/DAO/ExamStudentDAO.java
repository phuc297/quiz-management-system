package DAO;

import DTO.ExamStudentDTO;
import CONNECT.QueryExecutor;

public class ExamStudentDAO {

    public boolean insertClass(ExamStudentDTO o) {
        String query = String.format("exec InsertAllStudentInClassToExam %d, %d;",
                o.getExamId(),
                o.getClassId()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }
}
