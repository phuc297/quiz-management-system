package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.SubjectDTO;

public class SubjectDAO implements DAO<SubjectDTO> {

    @Override
    public ArrayList<SubjectDTO> getAll() {
        String query = "SELECT * FROM Subject ORDER BY subject_id ASC";
        return ResultSetToData.toSubject(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public SubjectDTO get(int subjectId) {
        String query = "SELECT * FROM Subject WHERE subject_id =" + subjectId;
        return ResultSetToData.toSubject(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<SubjectDTO> getAllOfTeacher(int teacherId) {
        String query = "exec GetSubjectsOfTeacher " + teacherId;
        return ResultSetToData.toSubject(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public String getSubjectOfClass(int classId) {
        String query = "SELECT subject_name FROM Class c JOIN Subject s ON s.subject_id=c.subject_id WHERE c.class_id= " + classId;
        return (String) (QueryExecutor.getInstance().ExcuteScalar(query));
    }

    public String getName(int subjectId) {
        String query = "SELECT subject_name FROM Subject WHERE subject_id= " + subjectId;
        return (String) (QueryExecutor.getInstance().ExcuteScalar(query));
    }

    @Override
    public boolean insert(SubjectDTO o) {
        String query = String.format("INSERT INTO Subject (subject_name) VALUES (N'%s')",
                o.getSubjectName()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int subjectId) {
        return (QueryExecutor.getInstance().ExcuteNonQuery("delete from Subject where subject_id = " + subjectId) != -1);
    }

    @Override
    public boolean update(SubjectDTO o) {
        String query = "UPDATE Subject SET subject_name = '" + o.getSubjectName() + "' WHERE subject_id = " + o.getSubjectId();
        System.out.println(query);
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

}
