package by.delesevich.bestnews.service;

import by.delesevich.bestnews.dao.NewsDAO;
import by.delesevich.bestnews.entity.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

  private final NewsDAO newsDAO;

  public NewsServiceImpl(NewsDAO newsDAO) {
    this.newsDAO = newsDAO;
  }

  @Override
  @Transactional
  public News read(int id) {
    return newsDAO.read(id);
  }

  @Override
  @Transactional
  public boolean delete(int id) {
    return newsDAO.delete(id);
  }

  @Override
  @Transactional
  public News update(News news) {
    return newsDAO.update(news);
  }

  @Override
  @Transactional
  public long getNumberOfNews() {
    return newsDAO.getNumberOfNews();
  }

  @Override
  @Transactional
  public List<News> readPackOfNews(int numberOfSkippedNews, int numberOfReadNews) {
    return newsDAO.readPackOfNews(numberOfSkippedNews, numberOfReadNews);
  }

  @Override
  public List<String> getPageNumbersForPagination(
      long numberOfAllObjects, int currentPage, int objectsOnPage) {
    int numberOfPages = (int) Math.ceil((double) numberOfAllObjects / objectsOnPage);
    int startPage = Math.max(currentPage - 4, 1);
    int lastPage = Math.min(numberOfPages, currentPage + 4);
    List<String> pages = new ArrayList<>();
    if (currentPage > 1) {
      pages.add("<-");
    }
    for (int i = startPage; i < currentPage; i++) {
      pages.add(String.valueOf(i));
    }
    pages.add("<b><u>" + currentPage + "</u></b>");
    for (int i = currentPage + 1; i <= lastPage; i++) {
      pages.add(String.valueOf(i));
    }
    if (currentPage < numberOfPages) {
      pages.add("->");
    }
    return pages;
  }

  public int getNextPageNumber(String page, int currentPage) {
    if (page == null) {
      return currentPage;
    }
    if ("<-".equals(page)) {
      return currentPage - 1;
    }
    if ("->".equals(page)) {
      return currentPage + 1;
    }
    if (page.matches("^\\d+$")) {
      return Integer.parseInt(page);
    }
    return currentPage;
  }

}
