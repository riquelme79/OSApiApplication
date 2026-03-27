/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.riquelme.OSApiApplication.api.controller;

import br.dev.riquelme.OSApiApplication.domain.dto.ComentarioDTO;
import br.dev.riquelme.OSApiApplication.domain.model.Comentario;
import br.dev.riquelme.OSApiApplication.domain.model.OrdemServico;
import br.dev.riquelme.OSApiApplication.domain.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @PostMapping("/ordem-servico/{ordemServicoID}/comentar")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Comentario adicionarComentario (
            @PathVariable Long ordemServicoID,
            @Valid @RequestBody ComentarioDTO comentarioDTO) {
        return ordemServicoService.adicionarComentario(ordemServicoID, comentarioDTO.descricao());
    }
    
}
