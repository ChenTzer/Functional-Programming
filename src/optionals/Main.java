package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //logic
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                    () -> {
                    System.out.println("nice");
                    });

        // 12/30/2022
        Optional<String> hello = Optional.ofNullable("hello");

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        //if null then assign this value
        String orElse = hello
                .orElse("world");

        //map = transformation on the value
        String orElse2 = hello
                .map(String::toUpperCase)
                .orElse("world");

        //orElseGet = can run Supplier
        String orElse3 = hello
                .map(String::toUpperCase)
                .orElseGet(()->{
                    // ... extra computation to retrieve the value
                    return "world";
        });

        //or = can return optional

        //orElseThrow = can throw exception
        String orElse4 = hello
                .map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);

        //ifPresent = take the value and do somthing
        hello.ifPresent(word -> {
            System.out.println(word);
        });

        //ifPresentOrElse
        hello.ifPresentOrElse(System.out::println,
                () -> System.out.println("world"));

        System.out.println(orElse);
        System.out.println();

        Person person = new Person("James", null);
        System.out.println(person.getEmail().map(String::toLowerCase).orElse("No Email"));
    }

    static class Person{
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }

}
