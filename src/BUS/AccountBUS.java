package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;

public class AccountBUS implements BUS<AccountDTO> {

    private AccountDAO dao;

    public AccountBUS() {
        dao = new AccountDAO();
    }

    @Override
    public ArrayList<AccountDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public AccountDTO get(int accountId) {
        return dao.get(accountId);
    }

    public ArrayList<AccountDTO> getAllTeachers() {
        return dao.getAllTeachers();
    }

    public ArrayList<AccountDTO> getAllStudents() {
        return dao.getAllStudents();
    }

    public ArrayList<AccountDTO> getAllAdmin() {
        return dao.getAllAdmin();
    }

    @Override
    public ArrayList<AccountDTO> find(String s) {
        ArrayList<AccountDTO> allAccounts = getAll();
        ArrayList<AccountDTO> foundedAccounts = new ArrayList<AccountDTO>();
        for (AccountDTO i : allAccounts) {
            if (i.getUserName().toLowerCase().contains(s.toLowerCase())) {
                foundedAccounts.add(i);
            }
        }
        return foundedAccounts;
    }

    @Override
    public ArrayList<AccountDTO> findById(String s) {
        ArrayList<AccountDTO> allAccounts = getAll();
        ArrayList<AccountDTO> foundedAccounts = new ArrayList<AccountDTO>();
        if (s.equals("")) {
            return allAccounts;
        }
        for (AccountDTO i : allAccounts) {
            if (Integer.toString(i.getAccounId()).contains(s)) {
                foundedAccounts.add(i);
                return foundedAccounts;
            }
        }
        return foundedAccounts;
    }

    public int getLatestId() {
        return dao.getLatestId();
    }

    @Override
    public boolean insert(AccountDTO o) {
        if (dao.insert(o)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(AccountDTO o) {
        if (dao.update(o)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int accountId) {
        if (dao.remove(accountId)) {
            return true;
        }
        return false;
    }

}
