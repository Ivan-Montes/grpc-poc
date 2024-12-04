package dev.ime.service;

import org.springframework.stereotype.Service;

import dev.protobufs.GrpcDynamicServiceGrpc;
import dev.protobufs.HelloRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class ServiceClient {

    @GrpcClient("ms-tuti-cloud-server")
    private GrpcDynamicServiceGrpc.GrpcDynamicServiceBlockingStub grpcServiceStub;
    
    public String sayHi(String name) {
    	
    	HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return grpcServiceStub.sayHi(request).getMessage();
        
    }
    
}
