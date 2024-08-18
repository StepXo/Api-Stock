package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Article;

import java.util.List;

public interface ArticleServicePort {

        Article saveArticle(Article article);

        List<Article> getArticleList();

        void updateArticle(Article article);

        void deleteArticle(String articleId);
}
