package services;

import data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceImplTest {
    ArticleService articleService;
    Article article;

    @BeforeEach
    void setUp(){
        articleService = new ArticleServiceImpl();
        article = articleService.createPost("Felix...", "This feelings....", 1);
    }
    @Test public void savePost_postIdIsNotZero(){
        assertTrue(article.getId() != 0);
    }

    @Test public void findPostWithId(){
        Article found = articleService.findPost(1);
        assertEquals("Felix...", found.getTitle());
    }

    @Test public void ThrowExceptionWhenWrongIdIsFound(){
        assertThrows(IllegalArgumentException.class, ()-> articleService.findPost(2));
    }
}