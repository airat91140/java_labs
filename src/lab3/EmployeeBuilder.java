package lab3;

public class EmployeeBuilder {
    private String givenName = null;
    private String surName = null;
    private Integer age = null;
    private Gender gender = null;
    private Role role = null;
    private String dept = null;
    private String eMail = null;
    private String phone = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String code = null;

    public EmployeeBuilder givenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public EmployeeBuilder surName(String surName) {
        this.surName = surName;
        return this;
    }

    public EmployeeBuilder age(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public EmployeeBuilder dept(String dept) {
        this.dept = dept;
        return this;
    }

    public EmployeeBuilder eMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public EmployeeBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public EmployeeBuilder address(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder city(String city) {
        this.city = city;
        return this;
    }

    public EmployeeBuilder state(String state) {
        this.state = state;
        return this;
    }

    public EmployeeBuilder code(String code) {
        this.code = code;
        return this;
    }

    public Employee build() {
        return new Employee(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);
    }
}
