package servidor.web.pdm.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import servidor.web.pdm.entity.Login;
import servidor.web.pdm.entity.Mensagem;
import servidor.web.pdm.entity.Pessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-08T16:14:25")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile ListAttribute<Pessoa, Pessoa> contatos;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Integer> id;
    public static volatile SingularAttribute<Pessoa, Login> login;
    public static volatile ListAttribute<Pessoa, Mensagem> mensagens;
    public static volatile SingularAttribute<Pessoa, String> email;

}