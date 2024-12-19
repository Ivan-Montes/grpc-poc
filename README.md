
# grpc-poc

Playing with [Spring](https://spring.io/) and [gRPC](https://grpc.io/) using [gRPC-Spring-Starter](https://grpc-ecosystem.github.io/grpc-spring/en/)

### Components

| Name | gRPC Port | Web Port |
|------|-----------|-------------|
| ms-tuti-server | 50051 | x |
| ms-tuti-client | x | 8082 |
| ms-tuti-server-and-client | 50053 | 8083 |
| ms-tuti-cloud-server | 0 | 0 |
| ms-tuti-cloud-client | x | 8084 |
| ms-tuti-server-reactive | 50055 | x |
| ms-tuti-client-reactive | x | 8086 |
| eureka-discovery-server | x | 8761 |

### Installation

Download and compile

```
mvn clean compile
```
Then if you don't find all generated classes, please update your project from the specific pom.xml of that module

### Usage

You can use [grpcurl](https://github.com/fullstorydev/grpcurl) to call gRPC services

```
- List services
    grpcurl --plaintext localhost:50051 list
   
- Call method
    grpcurl --plaintext -d '{"name": "Bego"}' localhost:50051 net.protobufs.GrpcService.helloWorld
    grpcurl --plaintext -d '{"name": "Marian"}' localhost:50055 net.protobufs.GrpcReactiveService.areYouSure
    grpcurl --plaintext -d '{"name": "Maite"}' localhost:50053 net.protobufs.GrpcService.goodbyeWorld
        
```

It is possible to use a browser for calling a gRPC service using the client web server

```
http://localhost:8086/reactive/ays?name=Alazne
http://localhost:8083/api/bye?name=Frantxu
http://localhost:8084/cloud/sayHi?name=Leire

```

There is a ready eureka discovery server necessary to check the cloud version.

---

[![Java](https://badgen.net/static/JavaSE/21/orange)](https://www.java.com/es/)
[![Maven](https://badgen.net/badge/icon/maven?icon=maven&label&color=red)](https://https://maven.apache.org/)
[![Spring](https://img.shields.io/badge/spring-blue?logo=Spring&logoColor=white)](https://spring.io)
[![GitHub](https://badgen.net/badge/icon/github?icon=github&label)](https://github.com)
[![Eclipse](https://badgen.net/badge/icon/eclipse?icon=eclipse&label)](https://https://eclipse.org/)
[![GPLv3 license](https://badgen.net/static/License/GPLv3/blue)](https://choosealicense.com/licenses/gpl-3.0/)
