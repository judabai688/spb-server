package edu.zcs.spbserver.service;

import edu.zcs.news.proto.NewsProto;
import edu.zcs.news.proto.NewsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class NewsService extends NewsServiceGrpc.NewsServiceImplBase {
    @Override
    public void hello(NewsProto.StringRequest request, StreamObserver<NewsProto.StringReponse> responseObserver) {
        String name = request.getName();
        NewsProto.StringReponse build = NewsProto.StringReponse.newBuilder().setResult("hi," + name).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
}
