package com.intellias.px.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Repeatable()
public @interface CommandId {
    String value();

    String description() default "No description";

   String[] alternativeIds() default {};
}
