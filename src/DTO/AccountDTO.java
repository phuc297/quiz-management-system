package DTO;

public class AccountDTO {

    private int accounId;
    private String userName;
    private String password;
    private String role;

    public AccountDTO() {

    }

    public AccountDTO(int accounId, String userName, String password, String role) {
        this.accounId = accounId;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getAccounId() {
        return accounId;
    }

    public void setAccounId(int accounId) {
        this.accounId = accounId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
