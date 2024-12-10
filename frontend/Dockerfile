# Étape de build
FROM node:18-alpine as builder

# Installation de git
RUN apk add --no-cache git

# Cloner le frontend
WORKDIR /app
RUN git clone https://github.com/Couldevlop/RESTO.git .

# Installation et build
RUN npm install
RUN npm run build

# Étape de production
FROM nginx:alpine

# Copier les fichiers buildés depuis l'étape précédente
COPY --from=builder /app/build /usr/share/nginx/html

# Définir les permissions appropriées
RUN chmod -R 755 /usr/share/nginx/html

# Exposer le port 80 pour Nginx
EXPOSE 80

# Démarrer Nginx
CMD ["nginx", "-g", "daemon off;"]