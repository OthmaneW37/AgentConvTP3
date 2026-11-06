package ma.emsi.othmanemoussawi.tp3othmanemoussawi.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique. Pour la ville ou le pays donné par l'utilisateur,
            tu indiques les {{nb}} principaux endroits à visiter et le prix moyen d'un repas
            dans la devise du pays.
            N'utilise pas Markdown, réponds uniquement avec du JSON, avec exactement ce format :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2", ...],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    String chat(@UserMessage String villeOuPays, @V("nb") int nb);
}