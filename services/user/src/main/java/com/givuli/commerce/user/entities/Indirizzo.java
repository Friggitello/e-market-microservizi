package com.givuli.commerce.user.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "indirizzi")
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String via;
    @Column(nullable = false)
    private String civico;
    @Column(nullable = false)
    private String cap;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Comune comune;
}
