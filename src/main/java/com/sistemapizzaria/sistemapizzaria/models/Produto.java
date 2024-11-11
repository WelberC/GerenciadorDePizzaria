package com.sistemapizzaria.sistemapizzaria.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sistemapizzaria.sistemapizzaria.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Classe de modelo produto. Serve para conter as regras de negócio dos produtos em geral (Pizzas, Esfihas, Refrigerantes etc)

@Entity
@Table(name= "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column
    private String urlImagem;

    @Column
    private BigDecimal preco;

    @CreationTimestamp
    @Column
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column
    private LocalDateTime dataAlteracao;

}
