package com.example.firstproject.Controller;

import com.example.firstproject.Dto.ArticleForm;
import com.example.firstproject.Dto.CommentDto;
import com.example.firstproject.Entity.Article;
import com.example.firstproject.Repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/Articles/new")
    public String newArticleForm(){
        return "Articles/new";
    }

    @PostMapping("/Articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());
        Article saved = articleRepository.save(article);
        log.info(article.toString());
        //System.out.println(saved.toString());
        return "redirect:/Articles/"+saved.getId();
    }
    @GetMapping("/Articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id="+id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentsDtos);
        return "Articles/show";
    }
    @GetMapping("/Articles")
    public String index(Model model){
        ArrayList<Article> articleEntityList = articleRepository.findAll();

        model.addAttribute("articleList", articleEntityList);

        return "Articles/index";
    }

    @GetMapping("/Articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("Articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if (target != null){
            articleRepository.save(articleEntity);
        }

        return "redirect:/Articles/" + articleEntity.getId();
    }

    @GetMapping("Articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청");
        //1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null); // 데이터 찾기

        //2. 대상 엔티티 삭제하기
        if (target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료!");
        }
        //3. 결과 페이지로 리다이렉트하기
        return "redirect:/Articles";
    }
}
