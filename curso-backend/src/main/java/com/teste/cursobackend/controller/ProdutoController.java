package com.teste.cursobackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cursobackend.model.Produto;
import com.teste.cursobackend.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService ProdutoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return ProdutoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return ProdutoService.obterPorId(id);
    }
    
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return ProdutoService.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        ProdutoService.deletar(id);
        return "Produto com id:" + id + "foi deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return ProdutoService.atualizar(id, produto);

    }

}
