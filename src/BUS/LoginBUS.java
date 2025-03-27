package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;

public class LoginBUS {

    public AccountDTO checkLogin(String role, String username, String password) {

        if (role == Role.ADMIN.toString()) {
            return (new AccountDAO()).getAccount(Role.ADMIN.toString(), username, password);
        }
        if (role == Role.TEACHER.toString()) {
            return (new AccountDAO()).getAccount(Role.TEACHER.toString(), username, password);
        }
        if (role == Role.STUDENT.toString()) {
            return (new AccountDAO()).getAccount(Role.STUDENT.toString(), username, password);
        }
        return null;
    }
}
