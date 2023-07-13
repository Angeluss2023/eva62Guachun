package ups.edu.ec.pww.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.pww.datos.LibroDAO;
import ups.edu.ec.pww.modelo.Libro;


@Stateless
public class GestionLibros {

	
	@Inject
	private LibroDAO daoLibro;
	
	public void guardarLibro(Libro libro) throws Exception {
	    if (libro == null) {
	        throw new IllegalArgumentException("El libro no puede ser nulo");
	    }

	    if (!isCodigoValido(libro.getCodigo())) {
	        throw new Exception("Código de libro incorrecto");
	    }

	    try {
	        if (daoLibro.read(libro.getCodigo()) == null) {
	            daoLibro.insert(libro);
	        } else {
	            daoLibro.update(libro);
	        }
	    } catch (Exception e) {
	        throw new Exception("Error al guardar el libro: " + e.getMessage());
	    }
	}

	private boolean isCodigoValido(int codigo) {
	    // Lógica para validar el código de libro
	    // Retorna true si el código es válido, de lo contrario, retorna false
	    return codigo > 0;
	}

	
}
