package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "ubicazioni")
public class Ubicazione extends PanacheEntity{
    @Column(nullable = false) 
    public String codice; // es. SCA-01-A
    public String descrizione;
    
    @ManyToOne @JoinColumn(name = "magazzino_id")
    public Magazzino magazzino;
}
