/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

@ManagedBean(name = "listagemBean")
public class ListagemBean {

    List<Usuario> listaUsuario;
    private Usuario usuario;

    public List<Usuario> getListaUsuario() {
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<Usuario>();
            UsuarioDAO dao = new UsuarioDAO();
            listaUsuario.addAll(dao.listarUsuarios());
        }
        return listaUsuario;
    }

    public String removerUsuario() {
        UsuarioDAO udao = new UsuarioDAO();
        udao.remover(getUsuario());
        setListaUsuario(null);
        return "listagem";
    }
    
    public String cadastrarDocumentos(){
        return "CadastroDocumento";
    }
    
    
    public String cadastroUsuario(){
           return "index";
    }

    public String atualizarUsuario() {
        return "index";
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
