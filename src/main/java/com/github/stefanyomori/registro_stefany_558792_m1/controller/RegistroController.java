package com.github.stefanyomori.registro_stefany_558792_m1.controller;

import com.github.stefanyomori.registro_stefany_558792_m1.dto.RegistroInput;
import com.github.stefanyomori.registro_stefany_558792_m1.dto.RegistroOutput;
import com.github.stefanyomori.registro_stefany_558792_m1.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService service;

    @PostMapping
    public ResponseEntity<RegistroOutput> criar(@RequestBody RegistroInput input) {

        RegistroOutput output = service.create(input);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(output);
    }

    @GetMapping
    public ResponseEntity<List<RegistroOutput>> listar() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroOutput> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroOutput> atualizar( @PathVariable Long id,
            @RequestBody RegistroInput input) {

        RegistroOutput output = service.update(id, input);

        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
