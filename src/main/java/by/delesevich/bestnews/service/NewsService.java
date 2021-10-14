package by.delesevich.bestnews.service;

import by.delesevich.bestnews.entity.News;

import java.util.List;

public interface NewsService {
  News read(int id);

  boolean delete (int id);

  News update (News news);

  long getNumberOfNews();

  List<News> readPackOfNews(int numberOfSkippedNews, int numberOfReadingNews);

  List<String> getPageNumbersForPagination(
      long numberOfAllObjects, int currentPage, int objectsOnPage);

  int getNextPageNumber(String page, int currentPage);
}
