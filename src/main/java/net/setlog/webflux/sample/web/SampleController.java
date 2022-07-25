package net.setlog.webflux.sample.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.webflux.sample.service.IPostService;
import net.setlog.webflux.sample.vo.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
public class SampleController {

    private IPostService postService;

    @PostMapping("/sample/{name}")
    public Mono<String> sample(@PathVariable("name") String name) {
        log.info("-----sample");
        postService.saveAll();
        return Mono.just("hello, " + name);
    }

    @GetMapping("/sample/findAll")
    public Flux<Post> findAll() {
        log.info("-----findAll");
        return postService.findAll();
    }
}
