package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name = "servizi_configurati")
public class ServizioConfigurato extends PanacheEntity{
    @Column(unique = true, nullable = false) 
    public String nomeServizio;
    public String endpointUrl;
    public String descrizione;
    public boolean attivo;
}
