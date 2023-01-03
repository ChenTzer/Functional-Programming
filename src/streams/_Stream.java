package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream{
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE,11),
                new Person("Maria", FEMALE,24),
                new Person("Aisha", FEMALE,12),
                new Person("Alex", MALE,27),
                new Person("Alice", FEMALE,12)
        );

//        people.stream()
////                .map(person -> person.name)
////                .mapToInt(String::length)
////                .forEach(System.out::println);\

        boolean containsOnlyFemales = people.stream()
                .anyMatch(person -> person.gender.equals(FEMALE));
        System.out.println(containsOnlyFemales);

        //Filter
        System.out.println("Filter");
        List<Person> females = people.stream()
                .filter(person -> person.gender.equals(FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);
        System.out.println();

        //Sort Ascending
        System.out.println("Sort Ascending");
        List<Person> sortedAsc = people.stream()
                .sorted(Comparator.comparing(person -> person.name)) //.sorted(Comparator.comparing(Person::getName)) is same
                .collect(Collectors.toList());

        sortedAsc.forEach(System.out::println);
        System.out.println();

        //Sort Ascending
        System.out.println("Sort Descending");
        List<Person> sortedDesc = people.stream()
                .sorted(Comparator.comparing(Person::getName).reversed()) //assuming this is int
                .collect(Collectors.toList());

        sortedDesc.forEach(System.out::println);
        System.out.println();

        //Sort 2 Things or more
        System.out.println("Sort 2 Things or more");
        List<Person> sortedComparing = people.stream()
                .sorted(Comparator.comparing(Person::getGender)
                        .thenComparing(Person::getAge)
                        .thenComparing(Person::getName))
                .collect(Collectors.toList());

        sortedComparing.forEach(System.out::println);
        System.out.println();

        //All match
        System.out.println("All Match");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 0);
        System.out.println(allMatch);
        System.out.println();

        //Any match
        System.out.println("All Match");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 26);
        System.out.println(anyMatch);
        System.out.println();

        //None match
        System.out.println("None Match");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);
        System.out.println();

        //Max
        System.out.println("Max");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        System.out.println();

        //Max
        System.out.println("Min");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        System.out.println();

        //Group
        System.out.println("Group");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender,people1)-> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });
        System.out.println();

        //Pipe
        System.out.println("Pipe");
        Optional<String>oldestFemaleAge
                = people.stream().filter(person -> person.getGender().equals(FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;
        private int age;

        Person(String name, Gender gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }

    enum Gender{
        MALE, FEMALE
    }


}
