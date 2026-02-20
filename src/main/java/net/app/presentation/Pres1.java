package net.app.presentation;

import net.app.dao.DaoImpl;
import net.app.dao.IDao;
import net.app.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d);
        System.out.println("resultat = " + metier.calcul());
    }
}
