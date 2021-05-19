package wbs.pattern.factory_method;


import java.util.ListResourceBundle;

public class Bundle1_en extends ListResourceBundle {

        private Object[][] contents = { { "one", new StringBuffer("one") } };

        @Override
        public Object[][] getContents() {
                return contents;
        }
}

