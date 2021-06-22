package dao.daoImpl.processor.series;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.processor.Series.SeriesCrudOperations;
import entity.processor.Series;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SeriesDaoImpl implements SeriesCrudOperations {

    private static SeriesDaoImpl seriesDao;

    private SeriesDaoImpl(){

    }

    public static SeriesDaoImpl getInstance(){
        return seriesDao != null ? seriesDao : (seriesDao = new SeriesDaoImpl());
    }

    @Override
    public Series getSeriesById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(Series.class, id);
    }

    @Override
    public void deleteSeries(Long id) {
        Series series = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((series = getSeriesById(id)) != null) {
            session.beginTransaction();
            session.delete(series);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveSeries(Series series) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(series);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Series> getAllSeries() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Series> query = builder.createQuery(Series.class);
        Root<Series> root = query.from(Series.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateSeries(Series series) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(series);
        session.getTransaction().commit();
        session.close();
    }
}
