package org.dalpra.hubrix.core.graphql;

import java.util.List;

import org.dalpra.hubrix.core.domain.Contatto;
import org.dalpra.hubrix.core.domain.TipoPersona;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;

@GraphQLApi
@Authenticated
public class ContattoGraphQLApi {

    @Query("allContatti")
    public List<Contatto> getAllContatti() {
        return Contatto.listAll();
    }

    @Mutation("salvaContatto")
    @Transactional
    @RolesAllowed({"ADMIN", "USER"})
    public Contatto saveContatto(String nome, String cognome, String ragioneSociale, String pIva, String email, TipoPersona tipo) {
        Contatto c = new Contatto();
        c.nome = nome;
        c.cognome = cognome;
        c.ragioneSociale = ragioneSociale;
        c.partitaIva = pIva;
        c.email = email;
        c.tipo = tipo;
        c.persist();
        return c;
    }
}