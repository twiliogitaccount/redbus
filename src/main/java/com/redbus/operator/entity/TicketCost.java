package com.redbus.operator.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "ticket_cost")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Add an ID field for primary key

    @Column(name = "ticket_id", unique = true)
    private String ticketId;

    @OneToOne(mappedBy = "ticketCost")
    @JoinColumn(name = "bus_id") // Refer to the column in the BusOperator table
    private BusOperator busOperator;

    private double cost;

    private String code;

    @Column(name = "discount_amount", unique = true)
    private double discountAmount;


}
