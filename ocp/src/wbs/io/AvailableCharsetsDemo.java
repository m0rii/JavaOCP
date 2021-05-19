package wbs.io;

import java.nio.charset.Charset;

public class AvailableCharsetsDemo {

        public static void main(String[] args) {
                Charset.availableCharsets().entrySet().forEach(System.out::println);
                System.out.println("----------------");
                Charset cs = Charset.forName("UTF-8");
                System.out.println(cs);

        }
}
