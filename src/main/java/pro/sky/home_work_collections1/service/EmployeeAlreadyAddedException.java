package pro.sky.home_work_collections1.service;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Добавляемый работник уже есть в списке");
    }
}
