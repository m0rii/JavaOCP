package wbs.jdbc.annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {

        public static void main(String[] args) throws ClassNotFoundException {

              //  Class<BuchGZ> cls = BuchGZ.class; compile time
                Class<?> cls = Class.forName(args[0]); // wbs.jdbc.annotation.BuchGZ runtime
                // wer liest der byte code? framework und runtime excute
             
                
                Column column;
                PrimaryKey primaryKey;
               
                // wir iterieren über a l l e felder der klasse (auch private fields...)
                for (Field field : cls.getDeclaredFields()) {
                        // wir prüfen, ob das aktuelle feld die annotation @Column hat
                        column = field.getAnnotation(Column.class);
                        if (column != null) {
                                // das aktuelle feld hat die annotation @Column
                                // wir geben den namen des feldes und seinen typ aus
                                System.out.println(field.getName() + " -> "
                                                + field.getType().getSimpleName());
                                // wir prüfen, ob das aktuelle feld die annotation @PrimaryKey hat
                                primaryKey = field.getAnnotation(PrimaryKey.class);
                                if (primaryKey != null) {
                                        // das aktuelle feld hat die annotation @PrimaryKey
                                        // index() liefert den wert des attributs index: @PrimaryKey(index = 1)
                                        System.out.println(field.getName()
                                                        + " is column in primary key at index : "
                                                        + primaryKey.index());
                                }
                        }
                }
        }
}
