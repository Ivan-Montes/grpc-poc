package dev.ime.error;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcExceptionAdvice {
	
	@GrpcExceptionHandler
    public Status handleInvalidArgument(IllegalArgumentException e) {
        return Status.INVALID_ARGUMENT.withDescription("Your IllegalArgumentException").withCause(e);
    }

    @GrpcExceptionHandler(io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2Exception.class)
    public StatusException handleHttp2Exception(io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2Exception e) {
        Status status = Status.NOT_FOUND.withDescription("Your Http2Exception").withCause(e);
        Metadata metadata = new Metadata();
        
        return status.asException(metadata);
    }

	@GrpcExceptionHandler
    public Status handleException(Exception e) {
        return Status.INVALID_ARGUMENT.withDescription("Your Exception").withCause(e);
    }

    
}
