package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.ArticleServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Article;
import com.BootcampPragma.Api_Emazon.domain.spi.ArticlePersistencePort;

import java.util.List;

public class ArticleHU implements ArticleServicePort {

    private final ArticlePersistencePort articlePersistencePort;

    public ArticleHU(ArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public Article saveArticle(Article article) {
        return articlePersistencePort.saveArticle(article);
    }

    @Override
    public List<Article> getArticleList() {
        return articlePersistencePort.getArticleList();
    }

    @Override
    public void updateArticle(Article article) {
        articlePersistencePort.saveArticle(article);
    }

    @Override
    public void deleteArticle(String articleId) {
        articlePersistencePort.deleteArticulo(articleId);
    }

}
