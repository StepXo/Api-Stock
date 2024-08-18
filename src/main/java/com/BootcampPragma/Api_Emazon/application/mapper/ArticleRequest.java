package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticleDto;
import com.BootcampPragma.Api_Emazon.domain.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ArticleRequest {

    Article toArticle(ArticleDto article);
    ArticleDto toArticleDto(Article articleDto);

}
