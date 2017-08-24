/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author aluno
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {

                AnnotationConfiguration annotation
                        = new AnnotationConfiguration();
                sessionFactory = annotation.configure().buildSessionFactory();
            }
        } catch (Throwable e) {
            System.out.println("Erro ao iniciar conexão " + e);
        }

        return sessionFactory;
    }

}
