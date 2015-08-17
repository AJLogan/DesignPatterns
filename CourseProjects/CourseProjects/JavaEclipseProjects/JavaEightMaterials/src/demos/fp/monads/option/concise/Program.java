package demos.fp.monads.option.concise;

import java.util.Optional;

public class Program {
    private static Optional<String> fetchSystemProperty(String name) {
        String result = System.getProperty(name);
        if(result == null) {
            return Optional.empty();
        } else {
            return Optional.of(result);
        }
    }
    public static void main(String [] args) {
        Optional<String> result1 = fetchSystemProperty("java.version");
        Optional<String> result2 = fetchSystemProperty("wibble");
        
        result1.ifPresent(s -> System.out.println(s));
        result2.ifPresent(s -> System.out.println(s));
        printDivider();
        result1.ifPresent(System.out::println);
        result2.ifPresent(System.out::println);
        printDivider();
        System.out.println(result1.orElse("No such property!"));
        System.out.println(result2.orElse("No such property!"));
    }

    private static void printDivider() {
        System.out.println("------------");
    }
}
