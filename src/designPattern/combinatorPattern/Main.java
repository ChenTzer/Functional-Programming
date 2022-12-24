package designPattern.combinatorPattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice", "alice@gmail.com","0100000000", LocalDate.of(2000, 11 , 05));

        CustomerValidatorService validatorService = new CustomerValidatorService();
        validatorService.isValid(customer);
    }
}
