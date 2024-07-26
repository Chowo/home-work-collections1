package pro.sky.home_work_collections1.exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super("Допущена ошибка при вводе имени и фамилии работника");
    }
}
