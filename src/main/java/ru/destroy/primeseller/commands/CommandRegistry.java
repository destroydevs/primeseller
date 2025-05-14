package ru.destroy.primeseller.commands;

import org.bukkit.command.TabCompleter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandRegistry {
    String command();
    CommandType commandType() default CommandType.COMMAND;
}
