package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.ClassDTO;

public class ClassDAO implements DAO<ClassDTO> {

    @Override
    public ArrayList<ClassDTO> getAll() {
        String query = "exec GetAllClass";
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public ClassDTO get(int classId) {
        String query = "select * from Class where class_id =" + classId;
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public int getLatest() {
        String query = "SELECT * FROM Class ORDER BY class_id DESC";
        return (int) QueryExecutor.getInstance().ExcuteScalar(query);
    }

    public ArrayList<ClassDTO> getAllOfTeacherTotalStudents(int teacherId) {
        String query = "exec GetClassesOfTeacherTotalStudents " + teacherId;
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ClassDTO> getAllOfTeacher(int teacherId) {
        String query = "SELECT * FROM Class WHERE teacher_id = " + teacherId;
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ClassDTO> getAllOfStudent(int studentId) {
        String query = "exec GetClassesOfStudent " + studentId;
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<ClassDTO> getAllOfSubject(int subjectId) {
        String query = "SELECT * FROM Class WHERE subject_id = " + subjectId;
        return ResultSetToData.toClass(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public int getNumberStudent(int classId) {
        String query = "SELECT COUNT(*) FROM StudentClass WHERE class_id = " + classId;
        return (int) QueryExecutor.getInstance().ExcuteScalar(query);
    }
    
    @Override
    public boolean insert(ClassDTO o) {
        String query = String.format("INSERT INTO Class (class_name, teacher_id, subject_id) VALUES (N'%s', %d, %d)",
                o.getClassName(),
                o.getTeacherId(),
                o.getSubjectId()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    public boolean insertStudent(int studentId, int classId) {
        String query = "INSERT INTO StudentClass (student_id, class_id) VALUES (" + studentId + ", " + classId + ")";
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int classId) {
        String query = "DELETE Class WHERE class_id = " + classId;
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean update(ClassDTO o) {
        String query = "UPDATE Class SET class_name = '" + o.getClassName() + "', teacher_id = " + o.getTeacherId() + " WHERE class_id = " + o.getClassId();
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }
}
