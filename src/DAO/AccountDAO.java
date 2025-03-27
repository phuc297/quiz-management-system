package DAO;

import CONNECT.QueryExecutor;
import java.util.ArrayList;
import DTO.AccountDTO;

public class AccountDAO implements DAO<AccountDTO> {

    @Override
    public ArrayList<AccountDTO> getAll() {
        String query = "select * from Account";
        return ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    @Override
    public AccountDTO get(int accountId) {
        String query = "select * from Account WHERE accountId = " + accountId;
        return ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
    }

    public ArrayList<AccountDTO> getAllTeachers() {
        String query = "select * from Account where role = 'teacher'";
        return ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<AccountDTO> getAllStudents() {
        String query = "select * from Account where role = 'student'";
        return ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public ArrayList<AccountDTO> getAllAdmin() {
        String query = "select * from Account where role = 'admin'";
        return ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query));
    }

    public int getLatestId() {
        Object o = QueryExecutor.getInstance().ExcuteScalar("SELECT * FROM Account order by account_id desc");
        if (o != null) {
            return (int) o;
        }
        return -1;
    }

    public AccountDTO getAccount(String role, String username, String password) {
        String query = String.format("SELECT * FROM Account WHERE username = '%s' AND password = '%s' AND role = '%s';",
                username,
                password,
                role
        );
        try {
            Object o = ResultSetToData.toAccount(QueryExecutor.getInstance().ExcuteQuery(query)).get(0);
            if (o != null) {
                return (AccountDTO) o;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean insert(AccountDTO o) {
        String query = String.format("INSERT INTO Account (username, password, role) VALUES ('%s', '%s', '%s')",
                o.getUserName(),
                o.getPassword(),
                o.getRole()
        );
        System.out.println(query);
        return (QueryExecutor.getInstance().ExcuteNonQuery(query) != -1);
    }

    @Override
    public boolean remove(int account_id) {
        return (QueryExecutor.getInstance().ExcuteNonQuery("delete from Account where account_id = " + Integer.toString(account_id)) != -1);
    }

    @Override
    public boolean update(AccountDTO o) {
        return (QueryExecutor.getInstance().ExcuteNonQuery("exec UpdateAccount " + o.getAccounId() + ", " + o.getPassword()) != -1);
    }
}
