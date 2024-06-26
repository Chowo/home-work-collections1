package pro.sky.home_work_collections1.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Работник не найден")
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Работник не найден");
    }
}
