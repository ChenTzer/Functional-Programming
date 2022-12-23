package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        //Normal Java Function
        Customer maria = new Customer("Maria", "9999");
        System.out.println("Normal Java Function");
        greetCustomer(maria);
        System.out.println();
        greetCustomer2(maria, false);
        System.out.println();

        //Consumer Functional Interface
        System.out.println("Consumer");
        greetCustomerConsumer.accept(maria);
        System.out.println("\nBiConsumer");
        greetCustomerConsumerV2.accept(maria, false);
    }

    //Consumer
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +(showPhoneNumber ? customer.customerPhoneNumber : "****"));

    //Normal Java Function
    static void greetCustomer(Customer customer){
        System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +customer.customerPhoneNumber);
    }

    static void greetCustomer2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +(showPhoneNumber ? customer.customerPhoneNumber : "****"));
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }



    }
}
