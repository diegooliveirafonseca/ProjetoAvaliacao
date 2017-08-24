/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(usuario);//insercao
        t.commit();
        session.close();
    }

    
    public void remover(Usuario usuario) {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);//insercao
        t.commit();
        session.close();

    }

   public Usuario carrega(Usuario usuario){
   Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Usuario us = (Usuario) session.get(Usuario.class, usuario.getCodUsuario());
         t.commit();
        session.close();
        return us;
   }

    public List<Usuario> listarUsuarios() {
        Session session
                = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Usuario").list();
        session.close();
        return lista;
    }

    public void atualizar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(usuario);//insercao
        t.commit();
        session.close();
    }

}
