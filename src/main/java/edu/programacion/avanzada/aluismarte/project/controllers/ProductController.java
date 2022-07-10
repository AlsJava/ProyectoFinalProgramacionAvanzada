package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.GetProductResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.aluismarte.project.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GetProductResponse> get() {
        return ResponseEntity.ok(GetProductResponse.builder()
                .products(productService.getAll())
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(CreateProductResponse.builder()
                .product(productService.create(createProductRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@RequestBody UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(UpdateProductResponse.builder()
                .product(productService.update(updateProductRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> delete(@RequestBody DeleteProductRequest deleteEmployeeRequest) {
        productService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeleteProductResponse.builder().build());
    }
}
