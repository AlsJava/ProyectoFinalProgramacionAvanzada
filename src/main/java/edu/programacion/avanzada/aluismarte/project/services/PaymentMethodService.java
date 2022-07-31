package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.command.payment.GetAllPaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.command.payment.GetPaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.model.request.payment.CreatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.payment.DeletePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.DeletePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class PaymentMethodService {

    private final CommandBus commandBus;

    public GetPaymentMethodResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllPaymentMethodCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetPaymentMethodResponse get(Long id) {
        return commandBus.sendCommand(GetPaymentMethodCommand.builder()
                .id(id)
                .build());
    }

    public CreatePaymentMethodResponse create(CreatePaymentMethodRequest createPaymentMethodRequest) {
        return commandBus.sendCommand(createPaymentMethodRequest.toCommand());
    }

    public UpdatePaymentMethodResponse update(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return commandBus.sendCommand(updatePaymentMethodRequest.toCommand());
    }

    public DeletePaymentMethodResponse delete(DeletePaymentMethodRequest deletePaymentMethodRequest) {
        return commandBus.sendCommand(deletePaymentMethodRequest.toCommand());
    }
}
