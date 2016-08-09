/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.web.pdm.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import servidor.web.pdm.entity.Pessoa;

/**
 *
 * @author kaiqu
 */
@Stateless 
public class PessoaDao {

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServidorWebPDM");
//    EntityManager em = emf.createEntityManager();
    @PersistenceContext(unitName = "ServidorWebPDM")
    EntityManager em;

    public PessoaDao() {
    }

    public boolean salvar(Pessoa pessoa) {
        em.persist(pessoa);
        return true;
    }

    public boolean excluir(Pessoa pessoa) {
        em.remove(pessoa);
        return true;
    }

    public boolean atualizar(Pessoa pessoa) {
        em.merge(pessoa);
        return true;
    }

    public Pessoa procurar(Class<Pessoa> pessoa, Object chave) {
        return em.find(pessoa, chave);
    }

    public List<Pessoa> listar() {
        Query query = em.createQuery("SELECT p FROM Pessoa p ORDER BY p.nome");
        List<Pessoa> pessoas = query.getResultList();
        if (pessoas.size() > 0) {
            return pessoas;
        }
        return null;
    }

    public Pessoa logar(String login, String senha) {
        Query query = em.createQuery("SELECT p FROM Pessoa p WHERE p.login.login = :login AND p.login.senha = :senha");
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        List<Pessoa> pessoas = query.getResultList();

        if (pessoas.size() > 0) {
            return pessoas.get(0);
        }
        return null;
    }
}
