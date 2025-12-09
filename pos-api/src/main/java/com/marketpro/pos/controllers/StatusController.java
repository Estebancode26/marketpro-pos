package com.marketpro.pos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@Tag(name = "Estado del sistema", description = "Verifica que el backend de MarketPro esté activo")
public class StatusController {

    @Operation(summary = "Estado del backend", description = "Retorna un mensaje de confirmación")
    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of("estado", "activo");
    }
}