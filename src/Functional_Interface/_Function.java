package Functional_Interface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        //User Function
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        //Not Using And Then
        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        //Using And Then
        int incrementAndThenMultiply = addBy1AndThenMultiplyBy10.apply(1);
        System.out.println(incrementAndThenMultiply);
    }

    //Functional
    static Function <Integer, Integer> incrementByOneFunction = num -> num + 1;

    static Function <Integer, Integer> multiplyBy10Function = num -> num*10;

    static Function <Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);

    //Imperative
    static int incrementByOne(int num){
        return num+1;
    }

}
