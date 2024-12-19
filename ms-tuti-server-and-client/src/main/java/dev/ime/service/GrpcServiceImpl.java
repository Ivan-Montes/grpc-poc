package dev.ime.service;

import dev.protobufs.GoodbyeRequest;
import dev.protobufs.GoodbyeResponse;
import dev.protobufs.GrpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {

	@Override
    public void goodbyeWorld(GoodbyeRequest request, StreamObserver<GoodbyeResponse>responseObserver) {
		
		String message = "Goodbye, " + request.getName() + "!";
		
		GoodbyeResponse response = GoodbyeResponse.newBuilder()
				.setMessage(message)
				.build();
		
		 responseObserver.onNext(response);
	     responseObserver.onCompleted();
	}
	
}
