package ups.edu.ec.pww.servicios;


import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.pww.datos.LibroDAO;
import ups.edu.ec.pww.modelo.Libro;
import ups.edu.ec.pww.negocio.GestionLibros;

@Path("libros")
public class GLibrosService {
	
	
	@Inject
	private GestionLibros gLibros;
	
	@Inject
    private LibroDAO daoLibro;
	
	
	@GET
	@Path("libro1")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarLibro(Libro libro) {
	    try {
	        gLibros.guardarLibro(libro);
	        List<Libro> libros = getLibros(); 
	        return Response.status(Response.Status.OK).entity(libros).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al guardar: " + e.getMessage());
	        return Response.status(Response.Status.OK).entity(error).build();
	    }
	}
	
	
	public List<Libro> getLibros(){
		return daoLibro.getAll();
	}
}
