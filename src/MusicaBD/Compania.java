package MusicaBD;

public class Compania {
	private String cod;
	private String nombre;
	private String dir;
	private String fax;
	private String tfno;
	public Compania() {
	}
	public Compania(String cod, String nombre, String dir, String fax, String tfno) {
		this.cod = cod;
		this.nombre = nombre;
		this.dir = dir;
		this.fax = fax;
		this.tfno = tfno;
	}
	public String getCod() {
		return cod;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDir() {
		return dir;
	}
	public String getFax() {
		return fax;
	}
	public String getTfno() {
		return tfno;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}
	@Override
	public String toString() {
		return "Compania [cod=" + cod + ", nombre=" + nombre + ", dir=" + dir + ", fax=" + fax + ", tfno=" + tfno + "]";
	}
}
