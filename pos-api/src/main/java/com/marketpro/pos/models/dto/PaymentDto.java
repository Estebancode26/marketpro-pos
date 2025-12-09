package com.marketpro.pos.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Datos de un pago en el POS")
public class PaymentDto {
    @NotBlank
    @Schema(example = "VENTA-2025-000123")
    private String idVenta;

    @NotBlank
    @Schema(example = "EFECTIVO")
    private String metodo;

    @NotNull
    @Min(1)
    @Schema(example = "6500")
    private Integer monto;

    @Schema(example = "COP")
    private String moneda = "COP";

    // Getters y setters
    public String getIdVenta() { return idVenta; }
    public void setIdVenta(String idVenta) { this.idVenta = idVenta; }
    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
    public Integer getMonto() { return monto; }
    public void setMonto(Integer monto) { this.monto = monto; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
}