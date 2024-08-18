package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.ArticleDto;
import com.BootcampPragma.Api_Emazon.application.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    @GetMapping
    private List<ArticleDto> getArticleList(){
        return articleService.getArticleList();
    }

    @PostMapping
    private void saveArticle(@RequestBody ArticleDto article){
        articleService.saveArticle(article);
    }

}
