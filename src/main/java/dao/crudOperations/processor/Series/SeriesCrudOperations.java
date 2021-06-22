package dao.crudOperations.processor.Series;

import entity.processor.Series;

import java.util.Set;

public interface SeriesCrudOperations {
    Series getSeriesById(Long id);
    void deleteSeries(Long id);
    void saveSeries(Series series);
    Set<Series> getAllSeries();
    void updateSeries(Series series);
}
