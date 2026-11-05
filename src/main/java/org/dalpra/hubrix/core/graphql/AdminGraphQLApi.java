package org.dalpra.hubrix.core.graphql;

import java.util.List;

import org.dalpra.hubrix.core.domain.MenuVoce;
import org.dalpra.hubrix.core.domain.ServizioConfigurato;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@GraphQLApi
@Authenticated
public class AdminGraphQLApi {

    @Inject
    SecurityIdentity securityIdentity;

    @Query("serviziConfigurati")
    @RolesAllowed("ADMIN")
    public List<ServizioConfigurato> getServiziConfigurati() {
        return ServizioConfigurato.listAll();
    }

    @Mutation("registraServizio")
    @Transactional
    @RolesAllowed("ADMIN")
    public ServizioConfigurato registerServizio(String nomeServizio, String endpointUrl, String descrizione) {
        ServizioConfigurato s = new ServizioConfigurato();
        s.nomeServizio = nomeServizio;
        s.endpointUrl = endpointUrl;
        s.descrizione = descrizione;
        s.attivo = true;
        s.persist();
        return s;
    }

    @Query("menuUtente")
    public List<MenuVoce> getMenuUtente() {
        if (securityIdentity.hasRole("ADMIN")) {
            return MenuVoce.listAll();
        } else {
            return MenuVoce.list("ruoloRichiesto", "USER");
        }
    }
}