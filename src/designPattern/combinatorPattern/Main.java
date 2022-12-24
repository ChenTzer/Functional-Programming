package designPattern.combinatorPattern;

import java.time.LocalDate;

import static designPattern.combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice", "alice@gmail.com","0100000000", LocalDate.of(2000, 11 , 5));

        //Normal Method
//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        validatorService.isValid(customer);

        //Combinator Pattern
        ValidationResult result = isEmailValid()
                                    .and(isPhoneNumberValid())
                                    .and(isAnAdult())
                                    .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
