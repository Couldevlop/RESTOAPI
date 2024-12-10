# Dockerfile
FROM node:18-alpine as builder

# Installation de git
RUN apk add --no-cache git

# Cloner le frontend
WORKDIR /app
RUN git clone https://github.com/Couldevlop/RESTO.git .

# Installation et build
RUN npm install
RUN npm run build