package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity 
@Table(name = "contatti")
public class Contatto extends PanacheEntity{
    public String nome;
    public String cognome;
    public String ragioneSociale;
    public String partitaIva;
    public String email;
    @Enumerated(EnumType.STRING) public TipoPersona tipo;

}
