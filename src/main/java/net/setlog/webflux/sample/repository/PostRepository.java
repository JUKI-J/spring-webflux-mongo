package net.setlog.webflux.sample.repository;

import net.setlog.webflux.sample.vo.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
}