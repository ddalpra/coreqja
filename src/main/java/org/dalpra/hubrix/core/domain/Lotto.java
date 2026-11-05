package org.dalpra.hubrix.core.domain;

import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;


@Entity 
@Table(name = "lotti")
public class Lotto extends PanacheEntity{
    @Column(nullable = false) 
    public String codiceLotto;
    public LocalDate dataScadenza;
    
    @ManyToOne @JoinColumn(name = "articolo_id")
    public Articolo articolo;
    
    @ManyToOne @JoinColumn(name = "ubicazione_id")
    public Ubicazione ubicazione;
    
    public double giacenza;
}
