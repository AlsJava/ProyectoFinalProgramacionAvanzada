package edu.programacion.avanzada.aluismarte.project.model;

import lombok.*;

/**
 * @author aluis on 7/17/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class APIError {

    private int status;
    private String message;
}
