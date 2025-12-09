package com.marketpro.pos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta del estado del sistema")
public class StatusResponse {

    @Schema(example = "activo", description = "Estado actual del backend")
    public String estado;

    public StatusResponse(String estado) {
        this.estado = estado;
    }
}