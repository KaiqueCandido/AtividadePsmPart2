/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.web.pdm.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kaiqu
 */
//@Named
//@RequestScoped
public class Main {

//    @EJB
//    private PessoaDao dao;
//
//    public Main() {
//        Pessoa pessoa1 = new Pessoa("Karol", "karol@hotmail.com", "karol", "123",
//                new ArrayList<Mensagem>(), new ArrayList<Pessoa>());
//
//        Pessoa pessoa2 = new Pessoa("Kauan", "kauan@hotmail.com", "kauan", "123",
//                new ArrayList<Mensagem>(), new ArrayList<Pessoa>());
//
//        ArrayList<Pessoa> contatos = new ArrayList<Pessoa>();
//        contatos.add(pessoa1);
//        contatos.add(pessoa2);
//        Pessoa pessoa3 = new Pessoa("Kaique", "kaique@hotmail.com", "kaique", "123",
//                new ArrayList<Mensagem>(), contatos);
//
//        dao.salvar(pessoa1);
//    }
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.github.com/users/{users}/repos");
        Response get = target.resolveTemplate("users", "kaiquecandido").request(MediaType.APPLICATION_JSON).get();
        System.out.println(get.readEntity(String.class));
        
    }

}
