package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        //Normal Java Function
        System.out.println("Normal Java Function");
        System.out.println(getDBConnectionUrl());

        //Supplier
        System.out.println("Supplier");
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlListSupplier.get());

    }

    //Normal Java Function
    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    //Supplier
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlListSupplier = () -> List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/customer");
}
