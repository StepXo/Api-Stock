package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Article;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article toArticle(ArticleEntity article);
    ArticleEntity toArticleEntity(Article article);
}
