package edu.programacion.avanzada.aluismarte.project.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
