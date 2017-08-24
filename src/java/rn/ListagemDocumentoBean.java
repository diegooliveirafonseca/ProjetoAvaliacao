/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import DAO.DocumentoDAO;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Documento;
import modelo.Usuario;

@SessionScoped
@ManagedBean(name = "listagemDocumentoBean")
public class ListagemDocumentoBean {

    private List<Documento> listaDocumento;
    private Usuario usuario; //preciso do usuario porque a lista vai ser preenchida a partir dos dados do usuario
    private Documento documento;

    public String editarDocumento() {

        return "CadastroDocumento";
    }

    public String excluiDocumento() {
        DocumentoDAO docDAO = new DocumentoDAO();
        usuario.getListaDocumento().remove(documento);
        docDAO.remover(documento);
        setListaDocumento(null);
        getListaDocumento();
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Documento Excluído", ""));
        return null;
    }

    public List<Documento> getListaDocumento() {
        if (listaDocumento == null) {
            listaDocumento = new ArrayList<Documento>(); //criei uma lista vazia
            UsuarioDAO udao = new UsuarioDAO();
            usuario = udao.carrega(usuario);
            listaDocumento.addAll(usuario.getListaDocumento()); //adiciona todos os documentos do usuario numa lista de documentos do usuario  
        }
        return listaDocumento;
    }

    public String listagemUsuario() {
        return "listagem";
    }

    public String cadastroDocumento() {
        return "CadastroDocumento";
    }

    /**
     * @param listaDocumento the listaDocumento to set
     */
    public void setListaDocumento(List<Documento> listaDocumento) {
        this.listaDocumento = listaDocumento;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the documento
     */
    public Documento getDocumento() {
        if (documento == null) {
            documento = new Documento();
        }
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

}
