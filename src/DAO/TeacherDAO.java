package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.TeacherDTO;

public class TeacherDAO implements DAO<TeacherDTO> {

    @Override
    public ArrayList<TeacherDTO> getAll() {
        String query = "select * from Teacher";
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public TeacherDTO get(int teacherId) {
        String query = "select * from Teacher where teacher_id = " + teacherId;
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public TeacherDTO getByAccount(int accountId) {
        String query = "select * from Teacher where account_id = " + accountId;
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<TeacherDTO> getAllBySubject(int subjectId) {
        String query = "exec GetTeacherBySubject " + subjectId;
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<TeacherDTO> getAllBirthdayAsc() {
        String query = "SELECT * FROM Teacher ORDER BY birth_day ASC";
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<TeacherDTO> getAllBirthdayDesc() {
        String query = "SELECT * FROM Teacher ORDER BY birth_day DESC";
        return ResultSetToData.toTeacher(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public boolean insert(TeacherDTO o) {
        String query = String.format("exec InsertTeacher '%s','%s', N'%s', N'%s', '%s', N'%s', '%s', '%s';",
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
    public boolean update(TeacherDTO o) {
        String query = String.format("exec UpdateTeacher %d, N'%s', N'%s', '%s', N'%s', '%s', '%s'",
                o.getTeacherId(),
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
    public boolean remove(int teacherId) {
        return (QueryExecutor.getInstance().ExcuteNonQuery("delete from Teacher where teacher_id = " + teacherId) != -1);
    }
}
