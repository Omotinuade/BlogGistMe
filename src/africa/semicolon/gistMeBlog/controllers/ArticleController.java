package africa.semicolon.gistMeBlog.controllers;

import africa.semicolon.gistMeBlog.dtos.requests.CreateArticleRequest;
import africa.semicolon.gistMeBlog.services.ArticleService;
import africa.semicolon.gistMeBlog.services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(CreateArticleRequest request) {
        return articleService.createNewArticle(request);
    }
    public Object findPost(int id) {
        try {
            return articleService.findArticle(id);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
