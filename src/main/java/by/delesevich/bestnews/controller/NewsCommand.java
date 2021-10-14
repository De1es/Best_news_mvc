package by.delesevich.bestnews.controller;

import by.delesevich.bestnews.entity.News;
import by.delesevich.bestnews.service.NewsService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQueries;
import javax.validation.Valid;

@Controller
@RequestMapping("/news")
public class NewsCommand {

  private final NewsService newsService;

  public NewsCommand(NewsService newsService) {
    this.newsService = newsService;
  }

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }


  @GetMapping("/{id}")
  public String toTheNewsPage(@PathVariable("id") int id, Model model) {
    News news = newsService.read(id);
    model.addAttribute("news", news);
    return "news";
  }

  @PostMapping("/update")
  public String toUpdateNewsPage(@RequestParam("id") int id, Model model) {
    News news = newsService.read(id);
    model.addAttribute("news", news);
    return "updateNews";
  }

  @PostMapping("/delete/{id}")
  public String toDeletePage(@PathVariable("id") int id, Model model) {
    News news = newsService.read(id);
    model.addAttribute("news", news);
    return "deleteNews";
  }

  @PostMapping("/deleteNews/{id}")
  public String deleteNews(@PathVariable("id") int id, @RequestParam("choice") int choice) {
    if (choice == 1) {
      newsService.delete(id);
    }
    return "redirect:/";
  }

  @PutMapping(value = "/update")
  public String updateNews(@RequestParam("id") int id, @Valid @ModelAttribute("news") News news
      , BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      System.out.println(112233);
      return "redirect:/news/update?id=" + id;
    } else {
      newsService.update(news);
      return "redirect:/";
    }
  }

}
