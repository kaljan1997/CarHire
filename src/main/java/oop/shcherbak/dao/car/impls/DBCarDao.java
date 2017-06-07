package oop.shcherbak.dao.car.impls;

import oop.shcherbak.dao.car.interfaces.ICarDao;
import oop.shcherbak.model.car.impls.Car;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public class DBCarDao implements ICarDao{
   DataSource dataSource;
    private List<Car> cars;
    private static Car temp;
    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
    }

    public DBCarDao() {
    }

    public DBCarDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Car> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM cars", new CarRowMapper());


    }
    @Override
    public Car getCar(Integer id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return ((List<Car>) select.query("SELECT * FROM cars", new CarRowMapper())).stream().filter(p->p.getId()== id.intValue()).findFirst().get();
    }

    @Override
    public void createCar(Car car) {
        cars.add(car);

    }

    @Override
    public void deleteCar(Integer id) {
        temp = null;
        cars.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        cars.remove(temp);

    }

    @Override
    public void updateCar(Integer id, Car car) {
        temp = null;
        cars.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        cars.set(cars.indexOf(temp),car);
    }
}
