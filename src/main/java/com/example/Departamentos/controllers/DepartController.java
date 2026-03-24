package com.example.Departamentos.controllers;


import com.example.Departamentos.models.DepartModel;
import com.example.Departamentos.services.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping
    public DepartModel criarDepart(@RequestBody DepartModel novoDepart){
        return departService.criarDepart(novoDepart);
    }

    @GetMapping
    public List<DepartModel> buscarTodos(){
        return departService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarDepart(@PathVariable Long id){
        departService.deletarDepart(id);
    }

    @GetMapping("/{id}")
    public Optional<DepartModel> buscarPorId(@PathVariable Long id){
        return departService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DepartModel atualizarDepart(@PathVariable Long id,@RequestBody DepartModel novoDepart){
        return departService.atualizarDepart(id, novoDepart);
    }

}
