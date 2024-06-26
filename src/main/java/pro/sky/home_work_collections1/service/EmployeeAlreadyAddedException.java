package pro.sky.home_work_collections1.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.ALREADY_REPORTED, reason = "Добавляемый работник уже есть в списке")
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Добавляемый работник уже есть в списке");
    }
}
