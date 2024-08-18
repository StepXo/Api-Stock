package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Article;

import java.util.List;

public interface ArticlePersistencePort {
    Article saveArticle(Article articulo);

    List<Article> getArticleList();

    void updateArticulo(Article articulo);

    void deleteArticulo(String articuloId);
}
