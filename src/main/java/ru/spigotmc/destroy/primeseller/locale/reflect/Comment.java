package ru.spigotmc.destroy.primeseller.locale.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Comment {
    String comment();
    CommentType type() default CommentType.IN_LINE;
}
