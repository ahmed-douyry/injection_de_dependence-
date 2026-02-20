package net.app.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de données");
        double temp = 25;
        return temp;
    }
}
