package dev.ime.service;

import org.springframework.stereotype.Service;

import dev.protobufs.GrpcServiceGrpc;
import dev.protobufs.GrpcReactiveServiceGrpc;
import dev.protobufs.HelloRequest;
import dev.protobufs.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import reactor.core.publisher.Mono;

@Service
public class ServiceClientReactive {

    @GrpcClient("ms-tuti-server")
    private GrpcServiceGrpc.GrpcServiceStub grpcServiceGrpcStub;
    
    @GrpcClient("ms-tuti-server-reactive")
    private GrpcReactiveServiceGrpc.GrpcReactiveServiceStub grpcReactiveServiceGrpcStub;
    
	public Mono<String> helloWorld(String name) {
		
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        
        return Mono.create(sink -> 
        	grpcServiceGrpcStub.helloWorld(request, new StreamObserver<HelloResponse>() {
                @Override
                public void onNext(HelloResponse response) {
                    sink.success(response.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    sink.error(t);
                }

                @Override
                public void onCompleted() {
                    // Complete
                }
            })
        );
        
    }    
    
	public Mono<String> areYouSure(String name){
		
		HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
		  
	    return Mono.create(sink -> 
	    	grpcReactiveServiceGrpcStub.areYouSure(request, new StreamObserver<HelloResponse>() {
	            @Override
	            public void onNext(HelloResponse response) {
	                sink.success(response.getMessage());
	            }

	            @Override
	            public void onError(Throwable t) {
	                sink.error(t);
	            }

	            @Override
	            public void onCompleted() {
	                // El stream se ha completado
	            }
	        })
	    );
	    
	}

}
