package by.delesevich.bestnews.dao;

import by.delesevich.bestnews.entity.News;

import java.util.List;

public interface NewsDAO {

  News read (int id);
  boolean delete (int id);
  News update (News news);
  long getNumberOfNews ();
  List<News> readPackOfNews (int numberOfSkippedNews, int numberOfReadNews);
}
