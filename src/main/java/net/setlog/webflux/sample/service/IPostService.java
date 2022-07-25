package net.setlog.webflux.sample.service;

import net.setlog.webflux.sample.vo.Post;
import reactor.core.publisher.Flux;

public interface IPostService {

    public void saveAll();
    public Flux<Post> findAll();


}
