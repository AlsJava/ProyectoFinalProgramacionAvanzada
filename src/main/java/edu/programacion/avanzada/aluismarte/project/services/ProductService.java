package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.command.product.GetAllProductCommand;
import edu.programacion.avanzada.aluismarte.project.command.product.GetProductCommand;
import edu.programacion.avanzada.aluismarte.project.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.GetProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final CommandBus commandBus;

    public GetProductResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllProductCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetProductResponse get(Long id) {
        return commandBus.sendCommand(GetProductCommand.builder().id(id).build());
    }

    public CreateProductResponse create(CreateProductRequest createProductRequest) {
        return commandBus.sendCommand(createProductRequest.toCommand());
    }

    public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
        return commandBus.sendCommand(updateProductRequest.toCommand());
    }

    public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
        return commandBus.sendCommand(deleteProductRequest.toCommand());
    }
}
