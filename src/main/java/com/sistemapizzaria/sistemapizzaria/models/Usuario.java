package com.sistemapizzaria.sistemapizzaria.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sistemapizzaria.sistemapizzaria.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String CEP;

    @Column
    private String senha;

    @CreationTimestamp
    @Column
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column
    private LocalDateTime dataAlteracao;
    
    
}
