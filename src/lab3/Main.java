package lab3;

import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String []args) {
        List<Employee> lst = Employee.createShortList();
        Accountant accountant = new Accountant();
        lst.stream()
                .filter(employee -> employee.getGender() == Employee.Gender.FEMALE)
                .forEach(accountant::payPremium);
        lst.stream()
                .filter(employee -> employee.getDept().equals("IFIB"))
                .forEach(accountant::paySalary);
        lst.stream()
                .filter(employee -> employee.getAge() > 30)
                .filter(employee -> employee.getDept().equals("ICIS"))
                .forEach(accountant::payPremium);
        lst.stream()
                .filter(employee -> employee.getRole() == Employee.Role.MANAGER)
                .forEach(accountant::paySalary);
        lst.stream()
                .filter(employee -> employee.getRole() == Employee.Role.STAFF)
                .forEach(accountant::payPremium);

        Consumer<Employee> rangUp = employee -> {
            if (employee.getRole() == Employee.Role.STAFF)
                employee.setRole(Employee.Role.MANAGER);
            else if (employee.getRole() == Employee.Role.MANAGER)
                employee.setRole(Employee.Role.EXECUTIVE);
        };

        Function<Employee, String> getFullName = employee -> employee.getGivenName() + " " + employee.getSurName();
        Supplier<Employee> getMe = () -> Employee.builder()
                .givenName("Airat")
                .surName("Makhmutov")
                .age(19)
                .gender(Employee.Gender.MALE)
                .role(Employee.Role.STAFF)
                .dept("ICIS")
                .eMail("airatmak@gmail.com")
                .phone("89520332887")
                .city("Kazan")
                .state("Tatarstan")
                .code("420132")
                .address("Koshkina")
                .build();
        BiPredicate<Employee, String> nameEqualsToString = ((employee, s) -> employee.getGivenName().equals(s));
    }
}
