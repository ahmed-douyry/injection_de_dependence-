package net.app.dao2;

import net.app.dao.IDao;

public class IDaoImplv2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version capteur ....");
        double temp = 25;
        return temp;
    }
}
