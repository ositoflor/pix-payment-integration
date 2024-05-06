package com.checkout.loja.Pedidos.entity;

import com.checkout.loja.Pedidos.entity.ENUM.StatusPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "status")
    private StatusPagamento status = StatusPagamento.PENDENTE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private LocalDateTime  data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

}
