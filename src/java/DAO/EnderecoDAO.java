/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Endereco;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Marcus Pantoja
 */
public class EnderecoDAO {
     public void salvar(Endereco endereco) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(endereco);//insercao
        t.commit();
        session.close();
    }

    public void remover(Endereco endereco) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(endereco);//insercao
        t.commit();
        session.close();

    }

   

    public List<Endereco> listarUsuarios() {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Endereco").list();
        session.close();
        return lista;
    }

    public void atualizar(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(endereco);//insercao
        t.commit();
        session.close();

    }
}
