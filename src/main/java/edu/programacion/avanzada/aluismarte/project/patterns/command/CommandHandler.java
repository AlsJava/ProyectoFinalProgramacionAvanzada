package edu.programacion.avanzada.aluismarte.project.patterns.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
