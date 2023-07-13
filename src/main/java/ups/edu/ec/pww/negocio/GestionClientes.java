package ups.edu.ec.pww.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import ups.edu.ec.pww.datos.PersonaDAO;
import ups.edu.ec.pww.modelo.Persona;

@Stateless
public class GestionClientes {
	
	@Inject
	private PersonaDAO daoPersona;

	public void guardarClientes(Persona persona) throws Exception {
		
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getId_Persona())==null) {
			try {
				
				daoPersona.insert(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());	
			}
		}else {
			
			try {
				
				daoPersona.update(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());	
			}
		}
	}
	
	public void guardarPersonas(Persona persona) throws Exception {
		
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getId_Persona())==null) {
			try {
				
				daoPersona.insert(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());	
			}
		}else {
			
			try {
				
				daoPersona.update(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());	
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		
		return cedula.length()==10;
	}
	
    public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}
    
    public void guardarPersonas(String cedula, String nombre, String direccion) {
		
   	}
}
