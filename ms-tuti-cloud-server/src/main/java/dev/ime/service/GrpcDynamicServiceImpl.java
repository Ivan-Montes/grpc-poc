package dev.ime.service;

import dev.protobufs.GrpcDynamicServiceGrpc;
import dev.protobufs.HelloRequest;
import dev.protobufs.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcDynamicServiceImpl extends GrpcDynamicServiceGrpc.GrpcDynamicServiceImplBase {

    @Override
    public void sayHi(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    	String message = "Kaitxo, " + request.getName() + "!";
        
        HelloResponse response = HelloResponse.newBuilder()
                                              .setMessage(message)
                                              .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        
    }    
    
}
