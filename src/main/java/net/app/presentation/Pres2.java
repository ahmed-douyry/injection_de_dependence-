package net.app.presentation;

import net.app.dao.IDao;
import net.app.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(new File("config.txt"));
        String daoClassName = sc.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();
//        System.out.println( dao.getData());

        String metierClassname = sc.nextLine();
        Class cMetier = Class.forName(metierClassname);
        IMetier  metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
        System.out.println("resultat = " + metier.calcul());

    }
}
