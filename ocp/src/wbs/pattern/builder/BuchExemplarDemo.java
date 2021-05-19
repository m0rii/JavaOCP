package wbs.pattern.builder;

import java.io.IOException;

public class BuchExemplarDemo {

      public static void main(String[] args) throws IOException {

              String booksPath = "resources/io/buchexemplare.txt";

              BuchExemplarUtil.exemplareFromFile(booksPath,"\t+")
                              .forEach(System.out::println);
      }
}
