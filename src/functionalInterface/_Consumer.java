package functionalInterface;

import java.util.function.Consumer;

import static functionalInterface._Consumer.Customer.greetCustomer;

public class _Consumer {

    public static void main(String[] args) {
        //Normal Java Function
        Customer maria = new Customer("Maria", "9999");
        greetCustomer(maria);

        //Consumer Functional Interface
        greetCustomerConsumer.accept(maria);
    }

    //Consumer
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +customer.customerPhoneNumber);

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        //Normal Java Function
        static void greetCustomer(Customer customer){
            System.out.println("Hello " +customer.customerName +", thanks for registering phone number " +customer.customerPhoneNumber);
        }

    }
}
