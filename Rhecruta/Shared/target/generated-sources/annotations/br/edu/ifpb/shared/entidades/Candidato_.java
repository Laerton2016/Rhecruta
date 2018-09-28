package br.edu.ifpb.shared.entidades;

import br.edu.ifpb.shared.entidades.Vaga;
import java.io.File;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-27T19:08:01")
@StaticMetamodel(Candidato.class)
public class Candidato_ extends Pessoa_ {

    public static volatile ListAttribute<Candidato, Vaga> vagas;
    public static volatile SingularAttribute<Candidato, Boolean> classificado;
    public static volatile SingularAttribute<Candidato, File> Curriculo;

}