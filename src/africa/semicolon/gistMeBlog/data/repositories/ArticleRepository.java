package africa.semicolon.gistMeBlog.data.repositories;

import africa.semicolon.gistMeBlog.data.models.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
