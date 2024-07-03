# TP config

Amusons nous un peu avec la configuration du collector.

Quelques liens utiles :

-  https://github.com/open-telemetry/opentelemetry-collector
- https://github.com/open-telemetry/opentelemetry-collector-contrib

## Objectifs

Modifier la configuration dans `otel-collector-config.yaml` (et éventuellement dans d'autres fichiers) afin de répondre aux questions suivantes.

### Setup

Jaeger, Zipkin, Prometheus, un client et un serveur qui génèrent des traces et des metrics.
Un collecteur à configurer (voir le docker-compose.yaml).

### Questions

1. Écrivez la configuration pour que les traces du client et du serveur remonte dans Jaeger, Zipkin

2. Ajoutez la configuration pour que les métriques remontent dans Prometheus.

3. Modifiez la configuration pour filtrer les spans du client.

4. Modifiez la configuration pour envoyer les spans du client vers Zipkin et celles du serveur vers Jaeger

5. Trouvez un moyen de récupérer la télémétrie fournie par Docker (pour avoir la conso cpu/ram par exemple)

6. Ajoutez un label à une métrique

7. Ajoutez des informations provenant de la machine hôte (conteneur)

8. Trouvez un moyen de compter les spans et d'émettre la métrique correspondante.

BONUS : Ajoutez deux collectors supplémentaire, modifiez la configuration pour obtenir :

```
CLIENT --> COLLECTOR A  --> |
                            | --> COLLECTEUR C --> ZIPKIN/JAEGER/PROMETHEUS
SERVER --> COLLECTOR B  --> |
```
