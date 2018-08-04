package pl.pwlctk.patterns.behavior.iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Iterator {

    //wzorzec jest już zaimplementowany w Javie i bardzo często wykorzystywany

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        java.util.Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
        }
    }

    public static void main2(String[] args) throws IOException {


        new java.util.Iterator<String>() {
            private String nextLine;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("plik.txt"));

            @Override
            public boolean hasNext() {
                try {
                    nextLine = bufferedReader.readLine();
                } catch (IOException e) {
                    nextLine = null;
                }
                return nextLine != null;
            }

            @Override
            public String next() {
                return nextLine;

            }

        };
    }
}




