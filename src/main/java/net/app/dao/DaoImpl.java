package net.app.dao;

import org.springframework.stereotype.Component;

@Component("d")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de données");
        double temp = 25;
        return temp;
    }
}
