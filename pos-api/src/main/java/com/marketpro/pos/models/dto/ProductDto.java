package com.marketpro.pos.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Datos del producto")
public class ProductDto {

    @NotBlank
    @Schema(example = "ARROZ ROA 500g")
    private String nombre;

    @NotBlank
    @Schema(example = "ALIM-ARROZ-500")
    private String sku;

    @Positive
    @Schema(example = "6500")
    private int precio;

    @Min(0)
    @Schema(example = "120")
    private int stock;

    // Getters y setters
}