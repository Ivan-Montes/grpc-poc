package dev.ime.service;

import org.springframework.stereotype.Service;

import dev.protobufs.GrpcServiceGrpc;
import dev.protobufs.HelloRequest;
import dev.protobufs.HelloResponse;
import dev.protobufs.GoodbyeRequest;
import dev.protobufs.GrpcReactiveServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class ServiceClient {

    @GrpcClient("ms-tuti-server")
    private GrpcServiceGrpc.GrpcServiceBlockingStub grpcServiceStubServer;
    
    @GrpcClient("ms-tuti-server-and-client")
    private GrpcServiceGrpc.GrpcServiceBlockingStub grpcServiceStubServerAndClient;

    @GrpcClient("ms-tuti-server-reactive")
    private GrpcReactiveServiceGrpc.GrpcReactiveServiceBlockingStub grpcServiceStubReactiveBlock;    
    
	public String helloWorld(String name) {
		
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return grpcServiceStubServer.helloWorld(request).getMessage();
        
    }
    
    public String helloWorld2(final String name) {
    	
        try {
        	HelloRequest request = HelloRequest.newBuilder()
        			.setName(name)
        			.build();
            final HelloResponse response = this.grpcServiceStubServer.helloWorld(request);
            return response.getMessage();
            
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode();
        }
        
    }

	public String goodbyeWorld(String name) {
		
		GoodbyeRequest request = GoodbyeRequest.newBuilder()
                .setName(name)
                .build();
        return grpcServiceStubServerAndClient.goodbyeWorld(request).getMessage();
        
    }

    public String areYouSure(String name){

    	HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();

        return grpcServiceStubReactiveBlock.areYouSure(request).getMessage();
    	
    }
    
}
