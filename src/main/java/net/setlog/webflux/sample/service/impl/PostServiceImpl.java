package net.setlog.webflux.sample.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.webflux.sample.repository.PostRepository;
import net.setlog.webflux.sample.service.IPostService;
import net.setlog.webflux.sample.vo.Post;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements IPostService {

    private final PostRepository postRepository;

    @Override
    public void saveAll() {
        log.info("start data initialization  ...");
        Mono<Long> cnt = this.postRepository.count();
        this.postRepository
                //.deleteAll()
                .saveAll(
                //.thenMany(
                        Flux
                                .just("Post one", "Post two")
                                .flatMap(
                                        title -> this.postRepository.save(Post.builder().title(title).content("content of " + title).build())
                                )
                )
                .log()
                .subscribe(
                        null,
                        null,
                        () -> log.info("done initialization...")
                );

    }

    @Override
    public Flux<Post> findAll() {
        return postRepository.findAll();
    }


}
