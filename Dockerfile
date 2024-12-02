# Étape 1 : Utiliser une image officielle Java 17 comme base
FROM openjdk:17-jdk-slim

# Étape 2 : Créer un répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier JAR dans le conteneur
COPY target/your-application.jar app.jar

# Étape 4 : Exposer le port utilisé par l'application (par défaut 8080)
EXPOSE 4000

# Étape 5 : Définir une commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
