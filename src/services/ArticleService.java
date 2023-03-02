package services;

import data.models.Article;
import dtos.requests.CreateArticleRequest;

public interface ArticleService {
    Article createNewArticle(CreateArticleRequest createArticleRequest);

    Article findArticle(int id);

    long count();
}
