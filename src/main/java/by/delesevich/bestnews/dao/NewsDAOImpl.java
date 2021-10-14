package by.delesevich.bestnews.dao;

import by.delesevich.bestnews.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

  private final SessionFactory sessionFactory;

  public NewsDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public News read(int id) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.get(News.class, id);
  }

  @Override
  public boolean delete(int id) {
    Session currentSession = sessionFactory.getCurrentSession();
    News news = currentSession.get(News.class, id);
    currentSession.delete(news);
    return true;
  }

  @Override
  public News update(News news) {
    Session currentSession = sessionFactory.getCurrentSession();
    currentSession.update(news);
    return news;
  }

  @Override
  public long getNumberOfNews() {
    Session currentSession = sessionFactory.getCurrentSession();
    Query theQuery = currentSession.createQuery("select count (*) from News");
    return (Long) theQuery.getSingleResult();
  }

  @Override
  public List<News> readPackOfNews(int numberOfSkippedNews, int numberOfReadNews) {
    Session currentSession = sessionFactory.getCurrentSession();
    Query <News> query =
        currentSession.createQuery("from News order by date desc", News.class)
            .setFirstResult(numberOfSkippedNews).setMaxResults(numberOfReadNews);
    return query.getResultList();
  }

}
