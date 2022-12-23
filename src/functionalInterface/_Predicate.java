package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Normal Function");
        System.out.println(isPhoneNumberValid("0100000000"));
        System.out.println(isPhoneNumberValid("0200000000"));

        System.out.println("\nPredicate");
        System.out.println(isPhoneNumberValidPredicate.test("0100000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0200000000"));

        System.out.println("\nUse 2 Predicate");
        System.out.println("AND");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber1).test("0100000000"));
        System.out.println("OR");
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber1).test("0100000000"));

        System.out.println("\nBiPredicate");
        System.out.println(isPhoneNumberPlusVerification.test("0100000000", 0001));

    }

    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("01") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("01") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber1 = phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, Number> isPhoneNumberPlusVerification = (phoneNumber, verificationCode) -> phoneNumber.startsWith("01") && verificationCode.equals(0000);
}
