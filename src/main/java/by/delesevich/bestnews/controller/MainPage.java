package by.delesevich.bestnews.controller;

import by.delesevich.bestnews.entity.News;
import by.delesevich.bestnews.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainPage {

  private static final int NUMBER_OF_NEWS_ON_PAGE = 5;

  private final NewsService newsService;

  public MainPage(NewsService newsService) {
    this.newsService = newsService;
  }

  @GetMapping
  public String execute(HttpServletRequest request, Model model) {
    String paginationPage = request.getParameter("nextPage");
    String currentPage = request.getParameter("currentPage");
    int page;
    if (currentPage != null) {
       page = Integer.parseInt(currentPage);
    } else {
      page = 1;
    }
    int nextPage = newsService.getNextPageNumber(paginationPage, page);
    long countOfAllNews = newsService.getNumberOfNews();
    List<News> newsList = newsService.readPackOfNews((nextPage-1)*NUMBER_OF_NEWS_ON_PAGE,
        NUMBER_OF_NEWS_ON_PAGE);
    List <String> pagesNumbers = newsService.getPageNumbersForPagination(countOfAllNews, nextPage,
        NUMBER_OF_NEWS_ON_PAGE);
    model.addAttribute("pages", pagesNumbers);
    model.addAttribute("newsList", newsList);
    model.addAttribute("currentPage", nextPage);
    return "index";
  }
}
