package org.dalpra.hubrix.core.domain;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity 
@Table(name = "magazzini")
public class Magazzino extends PanacheEntity{
    @Column(unique = true, nullable = false) 
    public String codice;
    public String nome;
    
    @OneToMany(mappedBy = "magazzino", cascade = CascadeType.ALL)
    public List<Ubicazione> ubicazioni;
}
