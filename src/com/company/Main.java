package com.company;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
String sentence = "Hello alan i am here where are you and what are you doing hello are you there";
    List<String> words = Arrays.asList(sentence.split(" "));

    List<String> result =
            words.stream()
                 .map(String::toLowerCase)
                 .collect(groupingBy(identity(), counting()))
                 .entrySet().stream()
                 .sorted(Map.Entry.<String, Long> comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                 .limit(7)
                 .map(Map.Entry::getKey)
                 .collect(toList());

    System.out.println(result);
}
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        HashMap<String, Integer> hs = new HashMap<>(); //для хранения повторов

        Stream<String> stream = in.lines();
        stream
                .flatMap(s -> Stream.of(s.split("[^a-zA-Z_0-9]+")))//получение из строки подстрок
                .map(t -> t.toLowerCase(Locale.ROOT))
                .forEach(t -> {
                    if (hs.containsKey(t)) {
                        hs.put(t, hs.get(t) + 1);
                    } else {
                        hs.put(t, 1);
                    }
                });
        hs.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());})
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
        //.sorted()
        //.distinct()//чтобы не было  повторов

       /* sBase.chars()//строку в массив символов
                .filter(Character::isLetterOrDigit) //только бувы и цифры
                .map(Character::toLowerCase) //нижний регистр
                .sorted()//сортировка по возрастанию
                .forEach(sb::appendCodePoint);//записать в sb
        System.out.println(sb.toString());
        */
//        s=s.toLowerCase(Locale.ROOT);//приведение к нижнему регистру
//        String[] ssplit = s.split("[^a-zA-Z_0-9]");//только буквенно-цифровые
//        for (String str: ssplit) {
//            System.out.println(str);

        }



    }


