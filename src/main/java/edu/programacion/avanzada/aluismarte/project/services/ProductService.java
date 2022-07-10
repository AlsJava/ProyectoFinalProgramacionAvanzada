package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.domain.Product;
import edu.programacion.avanzada.aluismarte.project.model.dto.ProductDTO;
import edu.programacion.avanzada.aluismarte.project.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.aluismarte.project.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    public ProductDTO create(CreateProductRequest createProductRequest) {
        Product product = productRepository.save(createProductRequest.toProduct());
        return product.toDTO();
    }

    public ProductDTO update(UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId()).orElseThrow();
        product.applyChanges(updateProductRequest);
        productRepository.save(product);
        return product.toDTO();
    }

    public void delete(DeleteProductRequest deleteProductRequest) {
        productRepository.deleteById(deleteProductRequest.getId());
    }
}
