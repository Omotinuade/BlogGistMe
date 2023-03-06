package africa.semicolon.gistMeBlog.controllers;

import africa.semicolon.gistMeBlog.dtos.requests.CreateArticleRequest;
import africa.semicolon.gistMeBlog.services.ArticleService;
import africa.semicolon.gistMeBlog.services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController( ArticleService articleService){
        this.articleService = articleService;
    }

    @PostMapping("/post")
    public Object createPost(@RequestBody CreateArticleRequest request) {
        return articleService.createNewArticle(request);
    }

    @GetMapping("/post/{id}")
    public Object findPost(@PathVariable String id) {
        try {
            return articleService.findArticle(id);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
