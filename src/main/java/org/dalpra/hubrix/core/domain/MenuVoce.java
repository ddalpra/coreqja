package org.dalpra.hubrix.core.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name = "menu_voci")
public class MenuVoce extends PanacheEntity{
    public String titolo;
    public String icona;
    public String route;
    public int ordine;
    public String ruoloRichiesto; // es. ADMIN, USER
}
