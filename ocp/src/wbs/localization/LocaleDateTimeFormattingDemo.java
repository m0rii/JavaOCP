package wbs.localization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocaleDateTimeFormattingDemo {

        public static void main(String[] args) {
                Locale[] locales = { Locale.getDefault(), Locale.ITALIAN,
                                Locale.FRENCH, Locale.US,
                                new Locale("pt", "BR"), new Locale("es") };
                LocalDateTime ldt = LocalDateTime.now();
                for (Locale locale : locales) {
                        for (FormatStyle formatStyle : FormatStyle.values()) {
                                System.out.println(formatStyle);
                                System.out.println(ldt.format(
                                                DateTimeFormatter.ofLocalizedDate(formatStyle)
                                                                .withLocale(locale)));
                        }
                        System.out.println("------------");
                }
        }
}
