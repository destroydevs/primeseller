package me.byteswing.primeseller.locale.reflect;

import me.byteswing.primeseller.locale.reflect.CommentType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Comment {
    String comment();
    CommentType type() default CommentType.IN_LINE;
}
