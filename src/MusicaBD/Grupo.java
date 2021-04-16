package MusicaBD;

public class Grupo {
	private String cod;
	private String nombre;
	private String fecha;
	private String pais;
	
	public Grupo() {
	}
	
	public Grupo(String cod, String nombre, String fecha, String pais) {
		this.cod = cod;
		this.nombre = nombre;
		this.fecha = fecha;
		this.pais = pais;
	}
	
	public String getCod() {
		return cod;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public String getPais() {
		return pais;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Grupo [cod=" + cod + ", nombre=" + nombre + ", fecha=" + fecha + ", pais=" + pais + "]";
	}
	
	
}