# Utilisation de l'IA dans le TP 3

J'ai utilisé Claude pendant ce TP. 

Il m'a aidé à comprendre et résoudre ces problèmes :
- Erreur 404 au lancement : l'application n'a pas de page d'accueil, elle ne répond
  que sur les URLs qui commencent par /api ; il fallait aussi utiliser le bon
  contexte de l'application dans l'URL.
- Comment la valeur "Nice" arrive dans la méthode : JAX-RS associe le morceau de
  l'URL à {ville_ou_pays} dans @Path, et @PathParam le met dans le paramètre.
- Erreur de compilation : la classe publique LlmClientForGuideTouristique était
  dans un fichier nommé LlmClient.java ; le nom du fichier doit être celui de la
  classe.
- Imports LangChain4j soulignés en rouge dans IntelliJ alors que le code était
  correct : il fallait recharger le projet Maven.
- Le modèle gemini-2.5-flash n'étant plus disponible, j'ai utilisé
  gemini-3.5-flash-lite.