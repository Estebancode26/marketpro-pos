package com.marketpro.pos.dto;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Venta registrada en POS")
public class SaleDto {

    @NotBlank
    @Schema(example = "ALIM-ARROZ-500", description = "SKU del producto vendido")
    public String sku;

    @Positive
    @Schema(example = "2", description = "Cantidad vendida")
    public int cantidad;

    @Schema(example = "CASHIER", description = "Rol del usuario que registró la venta")
    public String registradoPor;
}