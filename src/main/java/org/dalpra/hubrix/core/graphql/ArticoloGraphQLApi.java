package org.dalpra.hubrix.core.graphql;

import java.util.List;

import org.dalpra.hubrix.core.domain.Articolo;
import org.dalpra.hubrix.core.domain.Lotto;
import org.dalpra.hubrix.core.domain.Magazzino;
import org.dalpra.hubrix.core.domain.UnitaMisura;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;

@GraphQLApi
@Authenticated
public class ArticoloGraphQLApi {

    @Query("allArticoli")
    public List<Articolo> getAllArticoli() {
        return Articolo.listAll();
    }

    @Mutation("creaArticolo")
    @Transactional
    @RolesAllowed({"ADMIN", "USER"})
    public Articolo createArticolo(String codice, String descrizione, Long unitaMisuraId) {
        Articolo articolo = new Articolo();
        articolo.codice = codice;
        articolo.descrizione = descrizione;
        articolo.unitaMisura = UnitaMisura.findById(unitaMisuraId);
        articolo.persist();
        return articolo;
    }

    @Query("allMagazzini")
    public List<Magazzino> getAllMagazzini() {
        return Magazzino.listAll();
    }

    @Query("allLotti")
    public List<Lotto> getAllLotti() {
        return Lotto.listAll();
    }
}