package net.app.metier;

import net.app.dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double temp = dao.getData();
        double res = temp * 2 * Math.PI * Math.pow(temp, 2);
        return res;
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
