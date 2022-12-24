package finalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Integer number = null;
        int counter = 0;

        //Returning instantly, so don't need {}
        Function<String, String> upperCaseName1 = name -> name.toUpperCase();

        //If you put {}
        Function<String, String> upperCaseName2 = name -> {
            return name.toUpperCase();
        };

        //Got more logic/ not returning instantly, need {}
        Function<String, String> upperCaseName3 = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName4 = (name, age) -> {
            //Can use this, because counter2 is only available in this function
            int counter2 = 0;

            //logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);

            //Cannot do below, because counter is global variable (Check FUNCTIONAL PROGRAMMING TIPS.txt, line 44)
            //Mutating state, not pure function, has side effects.

            //System.out.println(counter);
            //number++;

            return name.toUpperCase();
        };
    }


}
