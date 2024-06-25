package pro.sky.home_work_collections1.service;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Работник не найден");
    }
}
