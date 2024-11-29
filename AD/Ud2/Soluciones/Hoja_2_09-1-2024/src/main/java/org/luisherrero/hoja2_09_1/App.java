package org.luisherrero.hoja2_09_1;


import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Grupo;
import model.Usuario;


/**
 * Hello world!
 *
 */
public class App 
{
	private static EntityManager em;

	public static void main( String[] args )
    {

    	
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistenceUnit");
        em=emf.createEntityManager();
        String op;
        do {
        	op=menu();
        	if(!op.equals("0")) {
        		realiza(op);
        	}
        			
        }while (!op.equals("0"));
        
        em.close();
        emf.close();
        System.exit(0);
    }
    
    public static String menu() {
    	System.out.println("""
                1.- Listado de grupos
                2.- Listado de usuarios que no han votado
                3.- Listado de usuarios nacidos a partir de 1990
                4.- Grupos sin componentes cargados
                5.- Grupos sin compañía cargada
                6.- Grupos de Barcelona con primer disco en año antes de 2010
                7.- Número de grupos de Madrid
                """);
    	return new Scanner(System.in).nextLine();
    }
    
    public static void realiza(String opcion) {
    	switch (opcion) {
		case "1"->listGrupos();
		case "2"->listUsuariosSinVotos();
		case "3"->listUsuariosPost(1990);
		case "4"->listNoGrupos();
		case "5"->listGruposSinComp();
		case "6"->listGruposLocalidadAnno("barcelona",2010);
		case "7"->numGruposLoc("madrid");
    	}
    	
    }
    
    private static void listGrupos() {
    	List<Grupo> listaGrupos=em.createQuery("select g from Grupo g",Grupo.class)
				.getResultList();
		listaGrupos.forEach(x->System.out.println(
				x.getCodgrupo()+"-"+x.getNombre()+" - localidad: "+
				x.getLocalidad()+" - estilo: "+x.getEstilo()
		));
	}

	private static void listUsuariosSinVotos() {
//		var query=em.createQuery("select u from Usuario u left join u.votos v "
//				+ "group by u having count(v)=0", Usuario.class);
//		var query=em.createQuery("select u from Usuario u left join u.votos v "
//				+ "where v is null", Usuario.class);
		var query=em.createQuery("select u from Usuario u where size(u.votos)=0",Usuario.class);
		List<Usuario> lista=query.getResultList();
		lista.forEach(x->System.out.println(
				x.getNombre()+" "+x.getApellidos()
		));
	}

	private static void listUsuariosPost(int a) {
		var query=em.createQuery("select u from Usuario u  "
				+ "where year(u.fechanac)>=:a",Usuario.class);
		query.setParameter("a", a);
//		var query=em.createQuery("SELECT u FROM Usuario u WHERE u.fechanac >= :fecha",Usuario.class);
//		query.setParameter("fecha",LocalDate.of(a,1,1));
		List<Usuario> lista=query.getResultList();
		lista.forEach(x->System.out.println(
				x.getNombre()+" "+x.getApellidos()
		));
	}

	private static void listNoGrupos() {
		var query=em.createQuery("select g from Grupo g left join g.componentes c "
				+ "group by g having count(c)=0",Grupo.class);
//		var query=em.createQuery("select g from Grupo g left join g.componentes c "
//						+ "where c is null",Grupo.class);
//		var query=em.createQuery("select g from Grupo g where size(g.componentes)=0",Grupo.class);
		List<Grupo> lista=query.getResultList();
		if(lista.isEmpty()) {
			System.out.println("No hay grupos sin componentes");
		}
		else {
			lista.forEach(x->System.out.println(x.getNombre()));
		}
	}

	private static void listGruposSinComp() {
		List<Grupo> lista=em
				.createQuery("select g from Grupo g where g.compania is null",Grupo.class)
				.getResultList();
		if(lista.isEmpty()) {
			System.out.println("No hay grupos sin compañía");
		}
		else {
			lista.forEach(x->System.out.println(x.getNombre()));
		}
	}

	private static void listGruposLocalidadAnno(String loc,int a) {
		List<Grupo> lista=em
				.createQuery("select g from Grupo g where g.localidad=:loc and annoGrab<:a",Grupo.class)
				.setParameter("loc", loc)
				.setParameter("a", a)
				.getResultList();
		if(lista.isEmpty()) {
			System.out.println("No hay grupos que cumplan la condición");
		}
		else {
			lista.forEach(x->System.out.println(x.getNombre()));
		}
	}

	private static void numGruposLoc (String localidad){
		Query query=em
				.createQuery("select count(g) from Grupo g where g.localidad=:loc",Long.class);
		query.setParameter("loc", localidad);
		Long num=(Long)query.getSingleResult();
//		Long num=em
//				.createQuery("select count(g) from Grupo g where g.localidad=:loc",Long.class)
//				.setParameter("loc", loc)
//				.getSingleResult();
		System.out.println(localidad+" tiene "+num+" grupos");
	}

	
}

	
