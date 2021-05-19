package wbs.localization;


import java.util.ListResourceBundle;

public class MyListResourceBundle extends ListResourceBundle {

        private Object[][] contents = { { "language", "language" },
                        { "currency", "currency" }, { "capital", "capital" },
                        { "default", new String[] { "a", "b", "c" } } };

        @Override
        public Object[][] getContents() {
                return contents;
        }
}
