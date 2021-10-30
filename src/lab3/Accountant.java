package lab3;

public class Accountant {
    private final static float staffSalary = 50000;
    private final static float managerSalary = 100000;
    private final static float executiveSalary = 150000;

    public void paySalary(Employee employee) {
        double salary;
        switch (employee.getRole()) {
            case STAFF: salary = staffSalary; break;
            case MANAGER: salary = managerSalary; break;
            case EXECUTIVE: salary = executiveSalary; break;
            default: throw new IllegalArgumentException("Undefined role");
        }
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " was paid salary: " + salary);
    }

    public void payPremium(Employee employee) {
        double premium;
        switch (employee.getRole()) {
            case STAFF: premium = staffSalary * 0.1; break;
            case MANAGER: premium = managerSalary * 0.2; break;
            case EXECUTIVE: premium = executiveSalary * 0.3; break;
            default: throw new IllegalArgumentException("Undefined role");
        }
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " was paid premium: " + premium);
    }
}
