package com.sistemapizzaria.sistemapizzaria.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.sistemapizzaria.sistemapizzaria.enums.StatusPedido;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name= "tb_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Usuario comprador;  

    @OneToMany(mappedBy = "pedido")
    private List<PedidoProduto> produtos;

    @CreationTimestamp
    private LocalDateTime dataCompra;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
