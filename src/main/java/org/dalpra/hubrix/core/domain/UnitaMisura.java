package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity 
@Table(name = "unita_misura")
public class UnitaMisura extends PanacheEntity{
    @Column(unique = true, nullable = false) 
    public String codice; // es. PZ, KG
    public String descrizione;
}
