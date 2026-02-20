package net.app.presentation;

import net.app.dao2.IDaoImplv2;
import net.app.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        IDaoImplv2 d = new IDaoImplv2();
        MetierImpl metier = new MetierImpl(d);
//        metier.setDao(d);

        System.out.println("resultat = " + metier.calcul());
    }
}
