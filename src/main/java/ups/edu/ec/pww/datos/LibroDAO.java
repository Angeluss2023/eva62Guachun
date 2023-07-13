package ups.edu.ec.pww.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.pww.modelo.Libro;

@Stateless
public class LibroDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read(int codigo) {
		Libro l = em.find(Libro.class, codigo);
		return l;
	}
	
	public void delete(int codigo) {
		Libro l = em.find(Libro.class, codigo);
		em.remove(l);
	}
	
	public List<Libro> getAll(){
		String jpql = "SELECT l FROM Libro l";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}
