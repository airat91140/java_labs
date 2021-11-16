package lab3;

import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String []args) {
        List<Employee> lst = Employee.createShortList();
        Accountant accountant = new Accountant();
        lst.forEach(accountant::paySalary);
        System.out.println();
        lst.stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE))
                .forEach(accountant::payPremium);
        System.out.println();
        lst.stream()
                .filter(employee -> employee.getDept().equals("IFIB"))
                .forEach(accountant::paySalary);
        System.out.println();
        lst.stream()
                .filter(employee -> employee.getAge() > 30)
                .filter(employee -> employee.getDept().equals("ICIS"))
                .forEach(accountant::payPremium);
        System.out.println();
        lst.stream()
                .filter(employee -> employee.getRole().equals(Role.MANAGER))
                .forEach(accountant::paySalary);
        System.out.println();
        lst.stream()
                .filter(employee -> employee.getRole().equals(Role.STAFF))
                .forEach(accountant::payPremium);

        Consumer<Employee> rangUp = employee -> {
            if (employee.getRole().equals(Role.STAFF))
                employee.setRole(Role.MANAGER);
            else if (employee.getRole().equals(Role.MANAGER))
                employee.setRole(Role.EXECUTIVE);
        };

        Function<Employee, String> getFullName = employee -> employee.getGivenName() + " " + employee.getSurName();
        Supplier<Employee> getMe = () -> Employee.builder()
                .givenName("Airat")
                .surName("Makhmutov")
                .age(19)
                .gender(Gender.MALE)
                .role(Role.STAFF)
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
