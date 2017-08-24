/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import DAO.DocumentoDAO;
import DAO.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Documento;
import modelo.Usuario;

/**
 *
 * @author Marcus Pantoja
 */
// escopo de sessão
@SessionScoped
@ManagedBean(name = "cadastroDocumentoBean")
public class CadastroDocumentoBean {
    
    private Usuario usuario;
    private Documento documento;
    
    public List<Documento> anulaListaDocumento() {
        List<Documento> listaDocumento = null;
        return listaDocumento;
    }
    
    public String salvarDocumento() {
        if (documento.getIdDocumento() == null) {
            UsuarioDAO udao = new UsuarioDAO();
            usuario = udao.carrega(usuario);
            getDocumento().setUsuario(usuario);
            
            usuario.getListaDocumento().add(documento);
            udao.atualizar(usuario);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Salvo com Sucesso", ""));
        } else {
            DocumentoDAO ddao = new DocumentoDAO();
            ddao.atualizar(documento);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Documento Atualizado", ""));
        }
        limpar();
        return "CadastroDocumento";
    }
    
    public void limpar() {
        //setUsuario(null);
        setDocumento(null);
    }
    
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Documento getDocumento() {
        if (documento == null) {
            documento = new Documento();
        }
        return documento;
    }
    
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    
    public String listarDocumento() {
        return "listagemDocumento";
    }
    
}
