package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.StudentDTO;

public class StudentDAO implements DAO<StudentDTO> {

    @Override
    public ArrayList<StudentDTO> getAll() {
        String query = "select * from Student";
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public StudentDTO get(int studentId) {
        String query = "select * from Student where student_id = " + studentId;
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public StudentDTO getByAccountId(int studentId) {
        String query = "select * from Student where account_id = " + studentId;
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<StudentDTO> getAllInClass(int classId) {
        String query = "exec GetStudentsInClass " + classId;
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<StudentDTO> getAllBirthdayAsc() {
        String query = "SELECT * FROM Student ORDER BY birth_day ASC";
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<StudentDTO> getAllBirthdayDesc() {
        String query = "SELECT * FROM Student ORDER BY birth_day DESC";
        return ResultSetToData.toStudent(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public boolean insert(StudentDTO o) {
        String query = String.format("exec InsertStudent '%s','%s', N'%s', N'%s', '%s', N'%s', '%s', '%s'",
                o.getUserName(),
                o.getPassword(),
                o.getFirstName(),
                o.getLastName(),
                o.getBirthday(),
                o.getGender(),
                o.getPhoneNumber(),
                o.getEmail()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean update(StudentDTO o) {
        String query = String.format("exec UpdateStudent %d, N'%s', N'%s', '%s', N'%s', '%s', '%s'",
                o.getStudentId(),
                o.getFirstName(),
                o.getLastName(),
                o.getBirthday(),
                o.getGender(),
                o.getPhoneNumber(),
                o.getEmail()
        );
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int studentId) {
        return (QueryExecutor.getInstance().ExcuteNonQuery("delete from Student where student_id = " + Integer.toString(studentId)) != -1);
    }

}
