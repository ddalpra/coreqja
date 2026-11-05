package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "articoli")
public class Articolo extends PanacheEntity{
    @Column(unique = true, nullable = false) 
    public String codice;
    public String descrizione;
    
    @ManyToOne 
    @JoinColumn(name = "unita_misura_id")
    public UnitaMisura unitaMisura;
}
