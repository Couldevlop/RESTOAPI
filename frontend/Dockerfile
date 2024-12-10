FROM node:18-alpine

# Cloner le frontend depuis le dépôt Git
RUN apk add --no-cache git && \
    git clone https://github.com/Couldevlop/RESTO.git /app

WORKDIR /app


# Installer les dépendances et construire l'application
RUN npm install && npm run build

# Exposer le serveur ReactJS (si nécessaire pour le développement)
EXPOSE 3000

CMD ["npx", "serve", "-s", "build", "-l", "3000"]
