package com.example.Departamentos.services;

import com.example.Departamentos.models.DepartModel;
import com.example.Departamentos.repositories.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartService {

    @Autowired
    private DepartRepository departRepository;

    public DepartModel criarDepart(DepartModel novoDepart){
        return departRepository.save(novoDepart);
    }

    public List<DepartModel> listarTodos(){
        return departRepository.findAll();
    }

    public void deletarDepart(Long id){
        departRepository.deleteById(id);
    }

    public Optional<DepartModel> buscarPorId(Long id){
        return departRepository.findById(id);
    }

    public DepartModel atualizarDepart(Long id, DepartModel novoDepart){
        Optional<DepartModel> departNoBanco = departRepository.findById(id);

        if(departNoBanco.isPresent()){
            DepartModel deparEditar = departNoBanco.get();

            deparEditar.setNome(novoDepart.getNome());
            deparEditar.setLocalizacao(novoDepart.getLocalizacao());

            return departRepository.save(deparEditar);

        } else return null;

    }


}
