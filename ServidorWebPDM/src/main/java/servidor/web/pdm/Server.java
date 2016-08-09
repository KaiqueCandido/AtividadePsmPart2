/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.web.pdm;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servidor.web.pdm.dao.PessoaDao;
import servidor.web.pdm.entity.Login;
import servidor.web.pdm.entity.Mensagem;
import servidor.web.pdm.entity.Pessoa;

/**
 *
 * @author kaiqu
 */
@Path(value = "/server")
@Stateless
public class Server {

    @EJB
    PessoaDao pd;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Pessoa login(Login l) {
        String login = l.getLogin();
        String senha = l.getSenha();
        return pd.logar(login, senha);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> listPessoas() {
        return pd.listar();        
    }        
}
