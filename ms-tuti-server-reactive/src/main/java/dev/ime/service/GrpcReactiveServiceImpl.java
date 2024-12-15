package dev.ime.service;

import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;
import dev.protobufs.ReactorGrpcReactiveServiceGrpc;
import dev.protobufs.HelloRequest;
import dev.protobufs.HelloResponse;

@GrpcService
public class GrpcReactiveServiceImpl extends ReactorGrpcReactiveServiceGrpc.GrpcReactiveServiceImplBase{

	@Override
    public Mono<HelloResponse> areYouSure(Mono<HelloRequest> request){
		
		return request
				.map( r -> "Are you sure, " + r.getName() + "?")
				.map( rs -> HelloResponse.newBuilder().setMessage(rs).build())
				;		
		
	}
	
}
