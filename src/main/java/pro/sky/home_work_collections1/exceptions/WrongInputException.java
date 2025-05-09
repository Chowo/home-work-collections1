package pro.sky.home_work_collections1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super("Допущена ошибка при вводе имени и фамилии работника");
    }
}
