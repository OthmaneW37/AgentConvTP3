package ma.emsi.othmanemoussawi.tp3othmanemoussawi.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Ressource REST qui donne des informations touristiques sur une ville ou un pays.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Donne les principaux endroits à visiter dans une ville ou un pays.
     *
     * @param villeOuPays nom de la ville ou du pays.
     * @return un document JSON avec les informations touristiques.
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return new String[]{villeOuPays};
    }
}