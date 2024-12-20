#  R E S T O A P I  dabali 

## 1. Vérifiez que le Réseau resto_network Existe
   Assurez-vous que le réseau Docker resto_network est bien créé. Exécutez la commande suivante pour lister les réseaux Docker 
      ``` docker network ls
   Recherchez une ligne contenant resto_network. Si le réseau n’existe pas, recréez-le avec :
      ``` docker network create resto_network
   Ensuite, relancez vos conteneurs :
      ``` docker-compose down
      ``` docker-compose up --build

## 2. Assurez-vous que les Conteneurs Sont Connectés au Réseau
   Pour chaque conteneur, vérifiez qu’il est connecté au réseau resto_network :
       ``` docker network inspect resto_network
   Vous devriez voir une section Containers listant vos conteneurs, notamment java_app et mysql_db. Si l’un des conteneurs n’apparaît pas :

  Ajoutez le Conteneur au Réseau

  Relancez vos conteneurs ou ajoutez le conteneur manuellement au réseau :
       ``` docker network connect resto_network <container_name>


## 3. Vérifiez que les Services MySQL et Spring Boot Fonctionnent
  Assurez-vous que les conteneurs java_app et mysql_db sont bien démarrés. Vérifiez leur statut avec :
       ``` docker ps
       ``` docker logs -f <container_name>


## 4. Testez la Résolution DNS Entre les Conteneurs
  Relancez un test avec un conteneur temporaire dans le réseau resto_network :
       ``` docker run --rm --network=resto_network alpine ping mysql_db
  Si le Ping Fonctionne :

  Cela confirme que le réseau est opérationnel et que mysql_db est résolu correctement. 
  Le problème pourrait alors provenir de la configuration de Spring Boot ou MySQL.
  Si le Ping Échoue :

## 5. Vérifiez la Connexion entre les Conteneurs
  Spring Boot essaie de se connecter à MySQL via l’hôte mysql_db. Assurez-vous que les conteneurs java_app et mysql_db sont bien connectés au même réseau Docker
  et que le service MySQL fonctionne correctement.

      a. Test de Résolution de Nom
  Lancez un conteneur temporaire dans le réseau Docker et testez la résolution DNS pour mysql_db :
       ``` docker run --rm --network=resto_network alpine ping mysql_db

  Si le ping échoue, vérifiez que java_app et mysql_db sont bien sur le même réseau (resto_network).
      b. Test de Connexion à MySQL

  Si le ping réussit, essayez de vous connecter directement à MySQL depuis un conteneur temporaire :
        ``` docker run --rm --network=resto_network mysql:8.0 mysql -h mysql_db -u root -pAbidjan@2023 -e "SHOW DATABASES;"

  - Si cette commande échoue, il y a un problème avec MySQL (configuration, état ou credentials).
  - Si elle réussit, le problème vient probablement de la configuration de Spring Boot.


## 6. Testez la Connectivité

Une fois les conteneurs redémarrés, testez si le conteneur MySQL fonctionne correctement et si vous pouvez vous y connecter depuis un conteneur temporaire :
     ``` docker run --rm --network=resto_network mysql:8.0 mysql -h mysql_db -u root -pAbidjan@2023 -e "SHOW DATABASES;"

## 7. Vérifiez la Connectivité avec MySQL

   Votre base de données est accessible sur le port 3306. Vous pouvez tester la connexion via un outil comme MySQL Workbench, DBeaver, ou la ligne de commande.
   Depuis la machine hôte :
Si vous avez MySQL installé localement, utilisez la commande suivante pour vous connecter :
        ``` mysql -h 127.0.0.1 -P 3306 -u root -pAbidjan@2023



 
 
