package finalSection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

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
    }


}
