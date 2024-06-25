package pro.sky.home_work_collections1.service;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Лимит сотрудников превышен");
    }
}
