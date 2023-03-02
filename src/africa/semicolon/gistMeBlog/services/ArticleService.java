package africa.semicolon.gistMeBlog.services;

import africa.semicolon.gistMeBlog.data.models.Article;
import africa.semicolon.gistMeBlog.dtos.requests.CreateArticleRequest;

public interface ArticleService {
    Article createNewArticle(CreateArticleRequest createArticleRequest);

    Article findArticle(int id);

    long count();
}
