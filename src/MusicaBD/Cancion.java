package MusicaBD;

public class Cancion {
	private String cod;
	private String titulo;
	private double duracion;
	
	public Cancion() {
	}
	
	public Cancion(String cod, String titulo, double duracion) {
		this.cod = cod;
		this.titulo = titulo;
		this.duracion = duracion;
	}
	
	public String getCod() {
		return cod;
	}
	public String getTitulo() {
		return titulo;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Cancion [codigo=" + cod + ", titulo=" + titulo + ", duracion=" + duracion + "]";
	}
	
}
