package net.app.metier;

import net.app.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double temp = dao.getData();
        double res = temp * 2 * Math.PI * Math.pow(temp, 2);
        return res;
    }

    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

//    public MetierImpl() {
//    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
