package controllers;

import services.ArticleService;
import services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(String title, String body, int id) {
        return articleService.createPost(title, body, id).toString();
    }
    public Object findPost(int id) {
        try {
            return articleService.findPost(id);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
