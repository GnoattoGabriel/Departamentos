package com.example.Departamentos.controllers;


import com.example.Departamentos.models.DepartModel;
import com.example.Departamentos.services.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping
    public ResponseEntity<DepartModel> criarDepart(@RequestBody DepartModel novoDepart){
        DepartModel departamento = departService.criarDepart(novoDepart);
        return ResponseEntity.status(201).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartModel>> buscarTodos(){
        return ResponseEntity.ok(departService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepart(@PathVariable Long id){
        departService.deletarDepart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartModel> buscarPorId(@PathVariable Long id){
        return departService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartModel> atualizarDepart(@PathVariable Long id,@RequestBody DepartModel novoDepart){
        DepartModel departAtt = departService.atualizarDepart(id, novoDepart);
        return ResponseEntity.ok(departAtt);
    }

}
