# Workshop Prometheus

## Prérequis

Docker et docker-compose doivent être disponibles.

Eclipse, IntelliJ ou n'importe quel éditeur doit être disponible.

## Lancement

Pour lancer les applications en local :
```
docker-compose up -d
```

## Mettre à jour une application

Après chaque modification du source d'une application, lancer les commandes
suivantes pour builder et recharger les applications :

```
docker-compose build
docker-compose up -d
```

## Mettre à jour la configuration de Prometheus

Après chaque changement de configuration, lancer cette commande pour prendre en
compte les modifications dans Prometheus :

```
docker-compose kill -s SIGHUP prometheus
```
