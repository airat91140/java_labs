package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> lst = Employee.createShortList();
        System.out.println(lst);

        System.out.println("=============map and peek=============");
        System.out.println(Arrays.toString(lst.stream().map(Employee::getAge).toArray()));
        System.out.println(Arrays.toString(lst.stream().map(empl -> empl.getGivenName() + " " + empl.getSurName()).toArray()));

        System.out.println(Arrays.toString(lst.stream().peek(empl -> empl.setAge(empl.getAge() + 1)).toArray()));
        lst.stream().peek(empl -> System.out.println(empl.getGivenName()))
                .filter(employee -> employee.getAddress().equals("Moscow"))
                .forEach(employee -> System.out.println(employee.getGivenName()));

        lst = Employee.createShortList();
        System.out.println("=============findFirst and lazy=============");
        System.out.println(lst.stream().filter(empl -> empl.getAge() < 25).findFirst().get().getGivenName());
        System.out.println(lst.stream().filter(empl -> empl.getAddress().equals("Moscow")).findFirst().get().getGivenName());

        lst.stream().peek(i -> System.out.println(i.getGivenName()))
                .filter(i -> i.getSalary() > 30000)
                .filter(i -> i.getGender().equals(Gender.MALE))
                .forEach(i -> System.out.println(i.getGivenName()));

        System.out.println("=============max and min=============");
        System.out.println(lst.stream().max(Comparator.comparingInt(Employee::getAge)));
        System.out.println(lst.stream().filter(i -> i.getGender().equals(Gender.FEMALE)).max(Comparator.comparingInt(Employee::getAge)));

        System.out.println(lst.stream().min(Comparator.comparingInt(Employee::getAge)));
        System.out.println(lst.stream().filter(i -> i.getGender().equals(Gender.FEMALE)).min(Comparator.comparingInt(Employee::getAge)));

        System.out.println("=============average and sum=============");
        System.out.println(lst.stream().filter(i -> i.getRole().equals(Role.STAFF)).mapToDouble(Employee::getSalary).sum());
        System.out.println(lst.stream().mapToDouble(Employee::getSalary).sum());

        System.out.println(lst.stream().filter(i -> i.getGender().equals(Gender.FEMALE)).mapToInt(Employee::getAge).average());
        System.out.println(lst.stream().filter(i -> i.getRole().equals(Role.STAFF)).mapToInt(Employee::getAge).average());

    }
}
