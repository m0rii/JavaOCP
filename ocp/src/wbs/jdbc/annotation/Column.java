package wbs.jdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// die annotation wird in den bytecode übertragen
// und kann zur laufzeit über das reflection-api abgefragt werden
@Retention(RetentionPolicy.RUNTIME)

// die annotation muss vor einem feld der klasse positioniert werden
@Target(ElementType.FIELD)
public @interface Column {

}
