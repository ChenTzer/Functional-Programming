package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        //Function
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        //Not Using And Then
        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        //Using And Then
        int incrementAndThenMultiply = addBy1AndThenMultiplyBy10.apply(1);
        System.out.println(incrementAndThenMultiply);

        //BiFunction
        int incrementAndThenMultiply2 = incrementByOneAndMultiplyBiFunction.apply(1,10);
        System.out.println(incrementAndThenMultiply2);
    }

    //Function
    //Functional
    static Function <Integer, Integer> incrementByOneFunction = num -> num + 1;

    static Function <Integer, Integer> multiplyByTenFunction = num -> num*10;

    static Function <Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyByTenFunction);

    //Imperative
    static int incrementByOne(int num){
        return num+1;
    }

    //BiFunction
    //Declarative
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    //Imperative
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

}
