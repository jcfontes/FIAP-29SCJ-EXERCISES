package fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia-atividade4-jpa");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}