package dev.ime.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import dev.protobufs.GrpcServiceGrpc;
import dev.protobufs.HelloRequest;
import dev.protobufs.HelloResponse;

@GrpcService
public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {
    
	@Override
    public void helloWorld(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        
        String message = "Hello World, " + request.getName() + "!";
        
        HelloResponse response = HelloResponse.newBuilder()
                                              .setMessage(message)
                                              .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
