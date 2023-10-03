# TP varlogpod

Vous souhaitez utiliser OpenTelemetryCollector pour récupérer les logs des Pods d'un cluster Kubernetes.

## Objectifs

Écrire une configuration dans le `otel-collector-config.yaml` qui :
* Lis les fichiers de logs dans `varlogpods`.
* Filtre les logs provenant des conteneurs ``
* Ajoute l'attribut `attributes.time` depuis le timestamp du log
* Extrait les informations de pod_name, container_name, restart_count
* Remplis les informations dans les attributs conventionnés `log.iostream`, `k8s.container.name`, `k8s.namespace.name`, `k8s.pod.name, `k8s.container.restart_count`, `k8s.pod.uid`

Le résultat sera affiché sur la sortie standard du collecteur.

### Setup

Le docker compose contient déjà le collector, vous devez choisir une image de conteneur adaptée, et réaliser la configuration dans `otel-collector-config.yaml`.

#### Description des fichiers

`varlogpods` contient des fichiers de log d'example.
Chaque dossier présente des logs dans différents formats (`CRI-O`, `CRI-Containerd` ou `Docker`).
Ce dossier est monté dans le conteneur à l'emplacement standard (`/var/log/pods`).