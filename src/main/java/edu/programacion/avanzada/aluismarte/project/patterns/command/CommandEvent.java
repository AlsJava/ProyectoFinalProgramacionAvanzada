package edu.programacion.avanzada.aluismarte.project.patterns.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandEvent {

    Class<? extends Command> command() default Command.class;
}
