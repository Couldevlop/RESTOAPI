# Dockerfile
FROM node:18-alpine as builder

# Installation de git
RUN apk add --no-cache git

# Cloner le frontend
WORKDIR /app
RUN git clone https://github.com/Couldevlop/RESTO.git .

# Installation des dépendances
RUN npm install

# Build de l'application
RUN npm run build

# Étape de runtime
FROM node:18-alpine

# Copier les fichiers nécessaires
WORKDIR /app
COPY --from=builder /app /app

# Installer les dépendances de runtime
RUN npm install --production

# Exposer le port d'exécution
EXPOSE 3000

# Commande pour démarrer l'application
CMD ["npm", "run", "start"]
