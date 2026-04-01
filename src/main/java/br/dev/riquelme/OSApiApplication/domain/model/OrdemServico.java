/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.riquelme.OSApiApplication.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.dev.riquelme.OSApiApplication.domain.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OrdemServico {
    
    @Schema(name = "ID da Ordem de Serviço", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Schema(name = "Cliente associado à ordem serviço")
    @ManyToOne
    private Cliente cliente;
    
    @Schema(name = "Lista de comentários registradas na ordem de servico",
            accessMode = Schema.AccessMode.READ_ONLY)
    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    @Schema(name = "Descrição da ordem de serviço", example = "Troca de bateria A54 5G")
    private String descricao;
    
    @Schema(name = "Preço da ordem de serviço", example = "100.00")
    private BigDecimal preco;
    
    @Schema(name = "Status atual da ordem", example = "ABERTA")
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;
    
    
    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, String descricao, BigDecimal preco) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }
    
    @Schema(name = "Data e hora abertura", example = "2026-03-06T08:00:00")
    private LocalDateTime dataAbertura;
    
    @Schema(name = "Data e hora finalização", example = "2026-03-11T17:10:56")
    private LocalDateTime dataFinalizacao;
}
