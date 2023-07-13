package ups.edu.ec.pww.negocio;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.pww.datos.LibroDAO;
import ups.edu.ec.pww.modelo.Libro;

@Singleton
@Startup
public class DatosLibros {

	
	
	
	@Inject
	private LibroDAO daoLibro;
	
	@PostConstruct
	public void init(){
		
		
		System.out.println("Hola");
		
		Libro l = new Libro();
		l.setCodigo(1);
		l.setNombre("Principito");
		l.setPrecio(12);
		l.setStock(20);
		
		Libro l1 = new Libro();
		l1.setCodigo(2);
		l1.setNombre("El señor de los anillos");
		l1.setPrecio(25);
		l1.setStock(10);
		
		Libro l2 = new Libro();
		l2.setCodigo(3);
		l2.setNombre("El diario de Ana Frank");
		l2.setPrecio(30);
		l2.setStock(12);
		
		daoLibro.insert(l);
		daoLibro.insert(l1);
		daoLibro.insert(l2);
		
		
		List<Libro> libros = daoLibro.getAll();
		
		for (Libro libro : libros) {
		    System.out.println("ID: " + libro.getCodigo());
		    System.out.println("Nomre: " + libro.getNombre());
		    System.out.println("Precio: " + libro.getPrecio());
		    System.out.println("Stock: " + libro.getStock());
		    System.out.println("-------------------------------------");
		}
	}
}
