package BUS;

public enum Role {
    ADMIN("admin"),
    TEACHER("teacher"),
    STUDENT("student");
    
    private String stringValue;

    private Role(String s) {
        stringValue = s;
    }

    public String toString() {
        return stringValue;
    }
}
