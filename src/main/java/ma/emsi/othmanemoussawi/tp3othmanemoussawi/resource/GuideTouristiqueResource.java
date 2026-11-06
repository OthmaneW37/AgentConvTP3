package ma.emsi.othmanemoussawi.tp3othmanemoussawi.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.othmanemoussawi.tp3othmanemoussawi.llm.LlmClientForGuideTouristique;

/**
 * Ressource REST qui donne des informations touristiques sur une ville ou un pays.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Client pour interroger le LLM.
     */
    @Inject
    private LlmClientForGuideTouristique llmClient;

    /**
     * Donne les principaux endroits à visiter dans une ville ou un pays,
     * ainsi que le prix moyen d'un repas, en interrogeant le LLM.
     *
     * @param villeOuPays nom de la ville ou du pays.
     * @param nb nombre d'endroits à visiter (paramètre de requête "nb", 2 par défaut).
     * @return un document JSON avec les informations touristiques.
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays,
                                   @QueryParam("nb") @DefaultValue("2") int nb) {
        return llmClient.envoyerRequete(villeOuPays, nb);
    }
}