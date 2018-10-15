package br.edu.ifpb.shared.entidades;

import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.entidades.Funcionario;
import br.edu.ifpb.shared.entidades.Vaga;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T21:33:41")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, Vaga> vaga;
    public static volatile SingularAttribute<Avaliacao, LocalDate> data;
    public static volatile SingularAttribute<Avaliacao, Boolean> aprovado;
    public static volatile SingularAttribute<Avaliacao, Boolean> cancelado;
    public static volatile SingularAttribute<Avaliacao, LocalDate> hora;
    public static volatile SingularAttribute<Avaliacao, Funcionario> avaliador;
    public static volatile SingularAttribute<Avaliacao, Integer> id;
    public static volatile SingularAttribute<Avaliacao, Candidato> candidato;
    public static volatile SingularAttribute<Avaliacao, Integer> nota;
    public static volatile SingularAttribute<Avaliacao, String> local;

}