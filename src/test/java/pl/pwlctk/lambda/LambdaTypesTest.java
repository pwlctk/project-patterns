package pl.pwlctk.lambda;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

class LambdaTypesTest {
    @Test
    void beforeLambda() {
        LambdaTypes lambdaTypes = new LambdaTypes();
        String string = lambdaTypes.createString();
        String string2 = string.toUpperCase();
        String string3 = string2.replaceAll(" ", "_");
        String string4 = parseToEmoji(string3);
        String wordStartWithP = findWordStartWithP(string4);
        if (wordStartWithP != null) {
            System.out.println(wordStartWithP);
        }

    }

    private String findWordStartWithP(String string4) {

        String[] s = string4.split(" ");
        for (String s1 : s) {
            if (s1.startsWith("P")) {
                return s1;
            }
        }
        return null;
    }

    private Optional<String> findOptionalWordStartWithP(String string4) {

        String[] s = string4.split("_");
        for (String s1 : s) {
            if (s1.startsWith("P")) {
                return Optional.of(s1);
            }
        }
        return Optional.empty();
    }


    @Test
    void afterLambda() {
        getParsedName().ifPresent(System.out::println);
    }


    @Test
    void shouldName3() {
        //OdElse wykona się zawsze nawet jak Optional nie bedzie pusty. Przez co jesli metoda bedzie skomplikowana program się zamuli
        String tom = getParsedName().orElse(getDefaultValue());
        System.out.println(tom);

        //orElseGet nie wykonuje się od razu tylko wtedy kiedy jest faktycznie potrzebny
        //orElse oraz orElseGet mowi nam, że jezeli wynik bedzie pusty to rob to co orElse albo orElseGet
        String tom2 = getParsedName().orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return getDefaultValue();
            }
        });
        //to jest to samo co wyzej
        //przekazanie referencji na metodę
        String tom3 = getParsedName().orElseGet(() -> getDefaultValue());
        //to tez jets to samo co wyzej
        String tom4 = getParsedName().orElseGet(this::getDefaultValue);
        System.out.println(tom3);


        getParsedName().orElseThrow(()-> new NoSuchElementException());

        //przekazanie referencji na konstruktor
        getParsedName().orElseThrow(NoSuchElementException::new);
    }

    private String getDefaultValue() {
        //pobieranie z serwera
        //jakies parsowania
        //i tak dalej i tak dalej....
        return "Tomek";
    }

    private Optional<String> getParsedName() {
        return Optional.of(new LambdaTypes())
                .map(LambdaTypes::createString)
                .map(String::toUpperCase)
                .map(string -> string.replaceAll(" ", "_"))
                .map(this::parseToEmoji)
                .flatMap(this::findOptionalWordStartWithP)
                .filter(s -> s.length() > 3);
    }

    private String parseToEmoji(String text) {
        return text.replaceAll(":D", "x313131313");
    }

}