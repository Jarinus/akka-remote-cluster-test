# Akka Remote Cluster Test

Serves to test akka cluster configuration for remote deployment.

Run by issuing:
```
docker run \
    --rm \
    -it \
    -p 8080:8080 \
    jarinus/akka-remote-cluster-test \
    -akka.cluster.seed-nodes [\"akka.tcp://AkkaRemoteClusterTest@EXTERNAL_IP:8080\"] \
    -akka.remote.netty.tcp.hostname EXTERNAL_IP \
    -akka.remote.netty.tcp.bind-hostname 172.18.0.2 \
    -akka.remote.netty.tcp.bind-port 8080
```

Another node can access the cluster by using the exact same seed node argument.

Note that `172.18.0.2` was a consistent inner IP address for my docker containers. This may change in time, so check
your docker container's IP address if something goes wrong.

Overwrite any `application.conf` configuration by passing them as arguments after `jarinus/akka-remote-cluster-test \`
