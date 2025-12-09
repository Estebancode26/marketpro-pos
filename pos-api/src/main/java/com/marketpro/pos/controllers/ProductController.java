package com.marketpro.pos.controllers;

import com.marketpro.pos.models.dto.ProductDto;
import com.marketpro.pos.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Inventario", description = "Gestión de productos en el sistema POS")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Operation(summary = "Crear producto")
    public ResponseEntity<ProductDto> crear(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.crear(dto));
    }

    @GetMapping
    @Operation(summary = "Listar productos")
    public ResponseEntity<List<ProductDto>> listar() {
        return ResponseEntity.ok(productService.listar());
    }

    @GetMapping("/{sku}")
    @Operation(summary = "Consultar producto por SKU")
    public ResponseEntity<ProductDto> obtener(@PathVariable String sku) {
        return ResponseEntity.ok(productService.obtener(sku));
    }

    @PutMapping("/{sku}")
    @Operation(summary = "Actualizar producto")
    public ResponseEntity<ProductDto> actualizar(@PathVariable String sku, @Valid @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.actualizar(sku, dto));
    }

    @DeleteMapping("/{sku}")
    @Operation(summary = "Eliminar producto")
    public ResponseEntity<Void> eliminar(@PathVariable String sku) {
        productService.eliminar(sku);
        return ResponseEntity.noContent().build();
    }
}