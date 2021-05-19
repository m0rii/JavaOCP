package wbs.pattern.factory_method;

import java.util.ListResourceBundle;

public class Bundle2_en extends ListResourceBundle {

        private Object[][] contents = { { "one", new StringBuilder("one") } };


        @Override
        public Object[][] getContents() {
                return contents;
        }
}