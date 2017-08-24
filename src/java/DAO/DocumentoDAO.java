/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Documento;
import modelo.Endereco;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Marcus Pantoja
 */
public class DocumentoDAO {
     public void salvar(Documento documento) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(documento);//insercao
        t.commit();
        session.close();
    }

    public void remover(Documento documento) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(documento);//insercao
        t.commit();
        session.close();

    }

   

    public List<Documento> listarDocumentos() {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Documento").list();
        session.close();
        return lista;
    }

    public void atualizar(Documento documento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(documento);//insercao
        t.commit();
        session.close();

    }
}
