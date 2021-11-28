package lab4;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private Employee(){}

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public String toString() {
        return "Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + role +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee(String givenName, String surName, int age, Gender gender, Role role, String dept, String eMail, String phone, String address, String city, String state, String code, float salary) {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.dept = dept;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
        this.salary = salary;
    }

    public static List<Employee> createShortList() {
        List<Employee> list = new ArrayList<>();
        list.add(Employee.builder()
                .givenName("Airat")
                .surName("Makhmutov")
                .age(19)
                .salary(10000)
                .gender(Gender.MALE)
                .role(Role.STAFF)
                .dept("ICIS")
                .eMail("airatmak@gmail.com")
                .phone("89520332887")
                .city("Kazan")
                .state("Tatarstan")
                .code("420132")
                .address("Koshkina")
                .build());

        list.add(Employee.builder()
                .givenName("Marat")
                .surName("Korol")
                .age(43)
                .gender(Gender.MALE)
                .role(Role.EXECUTIVE)
                .salary(150000)
                .dept("LAPLAS")
                .eMail("Marat@mail.ru")
                .phone("+72322458259")
                .city("Moscow")
                .state("Moscow")
                .code("115228")
                .address("Koroleva")
                .build());

        list.add(Employee.builder()
                .givenName("Albina")
                .surName("Kamalova")
                .age(33)
                .gender(Gender.FEMALE)
                .role(Role.MANAGER)
                .salary(50000)
                .dept("IPHTIS")
                .eMail("Albina@yandex.ru")
                .phone("88005553535")
                .city("Samara")
                .state("Samara")
                .code("345786")
                .address("Kashirsky")
                .build());

        list.add(Employee.builder()
                .givenName("Artem")
                .surName("Pavlov")
                .age(24)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .dept("IMO")
                .salary(50000)
                .eMail("artem@internet.ru")
                .phone("515-93-25")
                .city("Yakutsk")
                .state("Saha")
                .code("689030")
                .address("Lenina")
                .build());

        list.add(Employee.builder()
                .givenName("Alina")
                .surName("Gazizova")
                .age(22)
                .gender(Gender.FEMALE)
                .role(Role.STAFF)
                .salary(15000)
                .dept("ICIS")
                .eMail("Gazizova@vk.ru")
                .phone("89453574854")
                .city("Moscow")
                .state("Moscow")
                .code("122458")
                .address("Pelevina")
                .build());

        list.add(Employee.builder()
                .givenName("Maxim")
                .surName("Grusha")
                .age(29)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .salary(70000)
                .dept("Tashkent")
                .eMail("grusha@skushat.ru")
                .phone("85355235454")
                .city("Tashkent")
                .state("Tajikistan")
                .code("23456")
                .address("Adoratsky")
                .build());

        list.add(Employee.builder()
                .givenName("Maria")
                .surName("Efremova")
                .age(17)
                .gender(Gender.FEMALE)
                .role(Role.STAFF)
                .salary(20000)
                .dept("IFIB")
                .eMail("maria@rambler.ru")
                .phone("234-65-78")
                .city("Bryansk")
                .state("Bryansk")
                .code("573935")
                .address("Amirkhana")
                .build());
        return list;
    }
}
