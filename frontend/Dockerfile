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
RUN ls -la /app/build  # Pour vérifier que le build existe

# Étape de production
FROM nginx:alpine

# Copier les fichiers buildés
COPY --from=builder /app/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Vérifier que les fichiers sont bien copiés
RUN ls -la /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]