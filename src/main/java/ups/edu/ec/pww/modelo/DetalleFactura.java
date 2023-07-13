package ups.edu.ec.pww.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue
	@Column(name="det_codigo")
	private int codigo;
	
	@Column(name="det_cantidad")
	private int cantidad;
	
	@Column(name="det_precio")
	private double precio;
	
	@OneToOne
	@JoinColumn(name="pro_codigo")
	private Libro libro;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setProducto(Libro libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "DetalleFactura [codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio + ", libro="
				+ libro + "]";
	}
	
	
}