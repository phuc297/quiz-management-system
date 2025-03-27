package DTO;

public class TeacherDTO {

    private int teacherId;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private String phoneNumber;
    private String email;
    private int accountId;
    private String userName;
    private String password;

    public TeacherDTO() {

    }

    public TeacherDTO(int teacherId, String firstName, String lastName, String birthday, String gender, String phoneNumber, String email, int accountId) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountId = accountId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + teacherId + ")";
    }

    public String toString1() {
        return teacherId + ", " + firstName + ", " + lastName + ", " + birthday + ", " + gender + ", " + phoneNumber + ", " + email + ", " + accountId;
    }

}
