package com.marketpro.pos.controllers;

import com.marketpro.pos.models.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Pagos", description = "Registro y consulta de pagos")
@SecurityRequirement(name = "basicAuth")
public class PaymentsController {

    @PostMapping
    @Operation(summary = "Registrar pago")
    public ResponseEntity<PaymentDto> registrar(@Valid @RequestBody PaymentDto dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Listar pagos")
    public ResponseEntity<List<PaymentDto>> listar() {
        return ResponseEntity.ok(List.of());
    }
}