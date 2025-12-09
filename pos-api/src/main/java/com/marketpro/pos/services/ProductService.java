package com.marketpro.pos.services;

import com.marketpro.pos.models.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public ProductDto crear(ProductDto dto) {
        return dto;
    }

    public List<ProductDto> listar() {
        return new ArrayList<>();
    }

    public ProductDto obtener(String sku) {
        return new ProductDto();
    }

    public ProductDto actualizar(String sku, ProductDto dto) {
        return dto;
    }

    public void eliminar(String sku) {
        // lógica de eliminación
    }
}