******
# Projet Makelangelo 
## (Integration continue avec Maven)



#### *Nous tout au long de la modification de notre action considérant que nous connaissions pas grand chose des flags*
####  ![ Nous tout au long de la modification de notre action](https://github.com/AsmaaZohra/Makelangelo-software/blob/master/michael%20joke.jpeg?raw=true)
### Les 5 flags de la JVM et leurs impacts sur la qualité, la performance,l'observabilité

#### FLAG 1 : -XX:+TieredCompilation (Optomisation de la performance)
- ###### Performance : Ce flag permet de compiler le code en plusieurs phases. Il permet un démarrage rapide pour l'application et permet une optimisation progressive de la performance du code considérant que "le compilateur est capable de collecter des données pendant une activité de compilateur à faible impact, qui peuvent être utilisées pour des optimisations plus avancées ultérieurement".Cela est utile vu qu'il y a des mises à jour fréquentes du code et des changements continus dans la gestion des instructions de dessin.
- ###### Qualité : Permet une expérience uilisateur fluide en réduisant les délais.
- ###### Observabilité : Ce flag n'est pas un flag de diagnostic, mais il offre quand même une meilleure compréhension du JVM lors du démarrage.


#### FLAG 2: -Xmx4G (Type: Heap size max 4G)
- ###### Performance : Makelangelo est une application qui gère souvent des gros dessins complexes et des séquences de commandes longues ce qui veut dire qu'il faut avoir suffisament de mémoire pour éviter de réduire l'efficacité en engendrant des ralentissements. L'application devrait alors éviter les erreurs de mémoire et ce flag devrait aider à vérifier cela. 
- ###### Qualité : Une mémoire suffisante évite les problèmes d'execution de tâches ce qui permet une expérience utilisateur satisfaisante et stable. Il n'y a rien de pire que de se faire interrompre pour manque de mémoire.
- ###### Observabilité : Ce flag facilite la surveillance de l'utilisation de la mémoire et permet une meilleure gestion de cette dernière évitant des problèmes d'exécutions


#### FLAG 3 : -XX:+HeapDumpOnOutOfMemoryError (Bon pour le diagnostic)
- ###### Performance : Ce flag permet un déboggage efficace en permettant de capturer l'état de la mémoire en cas de fuite ou d'excessivité. S'il y a des problèmes avec la gestion de fichiers volumineux ou des séquences de commandes complexes il va être beaucoup plus facile de trouver le problème pour pouvoir le résoudre.
- ###### Qualité : Permet de facilité la gestion des problèmes de mémoire pour les développeurs ce qui impact positivement la fiabilité de l'application.
- ###### Observabilité : Améliore considérablement l'observabilité en offrant un appercu de l'état de la mémoire au moment de l'erreur (OutOfMemoryError) ce qui facilite énormémenet la correction des fuites de mémoire. 


#### FLAG 4 : -XX:+UseG1GC (Type : Garbage Collector)
- ###### Performance : Ce GC est connu pour ses courtes pauses lors du nettoyage de la mémoire. Il est utile pour des applications avec des piles de taille 4GB ou plus comme dans notre cas (-Xmx4G). Tout cela est essentiel si on veut que l'application en temps réel continue à fonctionner correctement même lorsque le système nettoie la mémoire.
- ###### Qualité : Améliore la gestion de la mémoire et réduit les risques de faibles performances.
- ###### Observabilité : Ce flag maintient des logs détaillées sur les cycles de collecte des déchets,temps de pause et phases de collecte. Cela est nécesssaire afin d'optimiser les performances et pour comprendre comment la collecte de déchets affecte Makelangelo en temps réel.

  
#### FLAG 5 : -XX:+UseStringDeduplication (Optimisation de la mémoire)
- ###### Performance : Ce flag permet de réduire l'empreinte mémoire globale causée par des chaines de caractères répétitives (noms de commandes/messages d'erreurs). Il y a aussi une possibilité que "la déduplication peut réduire la quantité de travail nécessaire dans d'autres phases d'une pause du GC (comme la réduction du nombre d'objets à évacuer) ainsi que la fréquence du GC (en raison de la pression réduite sur le tas)" .  
- ###### Qualité : Makelangelo intéragit souvent avec les utilisateurs afin de sauvegarder/charger des dessins et ce flag permet une application plus fiable considérant qu'il y a moins de pression sur le système de gestion de mémoire. 
- ###### Observabilité : Ce flag n'offre pas vraiment une sorte d'observabilité certaine, mais il reste utile pour donner des indices sur comment améliorer la gestion de la mémoire.


#Sources:
- https://blog.gceasy.io/usestringdeduplication/#more-2861
- https://aboullaite.me/understanding-jit-compiler-just-in-time-compiler/
- https://stackoverflow.com/questions/14763079/what-are-the-xms-and-xmx-parameters-when-starting-jvm
  



