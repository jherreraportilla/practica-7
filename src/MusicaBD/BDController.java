package MusicaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {
	private Connection conexion;

	public BDController() {
		super();
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el constructor vacio del BDController");
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Artista> listadoArtistas() {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from artista");
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return artistas;
	}

	public ArrayList<Artista> listadoArtistasPorLetra(String letra) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Select * from artista where nombre like '" + letra + "%';";
			//IMPORTANTE ESTA LINEA DE CODIGO PARA VER ERRORRES
			System.out.println("CadenaSQL: " + cadena);
			//
			ResultSet rs = miStatement.executeQuery(cadena);
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistasPorLetra");
			e.printStackTrace();
		}
		return artistas;
	}
	//ALTAS Y BAJAS ARTISTAS
	public void dardeAltaArtista(Artista artista) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Insert artista (dni, nombre) values ('" + artista.getDni() + "', '" + artista.getNombre()
					+ "');";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaArtista");
			e.printStackTrace();
		}
	}

	public void dardeBajaArtista(Artista artista) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "delete from artista where dni='" + artista.getDni() + "';";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaOpositor");
			e.printStackTrace();
		}
	}
	
	//ALTAS Y BAJAS CANCIONES
	public void dardeAltaCancion(Cancion cancion) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Insert cancion (cod, titulo, duracion) values ('" + cancion.getCod() + "', '" + cancion.getTitulo() + "' , '" + cancion.getDuracion()
					+ "');";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaCancion");
			e.printStackTrace();
		}
	}
	
	public void dardeBajaCancion(Cancion cancion) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "delete from cancion where cod='" + cancion.getCod() + "';";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeBajaCancion");
			e.printStackTrace();
		}
	}
	
	//ALTAS Y BAJAS GRUPOS
	public void dardeAltaGrupo(Grupo grupo) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "Insert grupo (cod, nombre, fecha, pais) values ('" + grupo.getCod() + "', '" + grupo.getNombre() + "' , '" + grupo.getFecha()
					+ "', '" + grupo.getPais() + "');";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaGrupo");
			e.printStackTrace();
		}
	}
	
	public void dardeBajaGrupo(Grupo grupo) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "delete from grupo where cod='" + grupo.getCod() + "';";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeBajaGrupo");
			e.printStackTrace();
		}
	}
	
	//ALTAS Y BAJAS DISCOS
	public void dardeAltaDisco(Disco disco) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "Insert disco (cod, nombre, fecha, cod_comp, cod_gru) values ('" + disco.getCod() + "', '" + disco.getNombre() + "' , '" + disco.getFecha()
					+ "', '" + disco.getCod_comp() + "', '" + disco.getCod_gru() + "');";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaDisco");
			e.printStackTrace();
		}
	}
	
	public void dardeBajaDisco(Disco disco) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "delete from disco where cod='" + disco.getCod() + "';";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeBajaDisco");
			e.printStackTrace();
		}
	}
	
	//ALTAS Y BAJAS COMPAÑIAS
	public void dardeAltaCompania(Compania compania) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "Insert disco (cod, nombre, fecha, cod_comp, cod_gru) values ('" + compania.getCod() + "', '" + compania.getNombre() + "' , '" + compania.getDir()
					+ "', '" + compania.getFax() + "', '" + compania.getTfno() + "');";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaDisco");
			e.printStackTrace();
		}
	}
	
	public void dardeBajaCompania(Compania compania) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String sql = "delete from compania where cod='" + compania.getCod() + "';";
			miStatement.executeUpdate(sql);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeBajaCompania");
			e.printStackTrace();
		}
	}
	
	//ALTAS Y BAJAS CLUBES
		public void dardeAltaClub(Club club) {
			try {
				// Creo el objeto tipo statement para poder hacer la consulta
				Statement miStatement = this.conexion.createStatement();
				String sql = "Insert disco (cod, nombre, sede, num, cod_gru) values ('" + club.getCod() + "', '" + club.getNombre() + "' , '" + club.getSede()
						+ "', '" + club.getNum() + "', '" + club.getCod_gru() + "');";
				miStatement.executeUpdate(sql);
				miStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en dardeAltaClub");
				e.printStackTrace();
			}
		}
		
		public void dardeBajaClub(Club club) {
			try {
				// Creo el objeto tipo statement para poder hacer la consulta
				Statement miStatement = this.conexion.createStatement();
				String sql = "delete from compania where cod='" + club.getCod() + "';";
				miStatement.executeUpdate(sql);
				miStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en dardeBajaClub");
				e.printStackTrace();
			}
		}
	
	public ArrayList<Artista> listadoArtistasPorNumero(String numero) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from artista where dni like '%" + numero + "';");
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistasPorNumero");
			e.printStackTrace();
		}
		return artistas;
	}

	public ArrayList<Cancion> listadoCanciones() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion");
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones;
	}
	
	public Cancion cancionmasLarga() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion order by duracion desc limit 0,1");
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones.get(0);
	}
	
	public ArrayList<Cancion> cancionesMenorLongitud(double duracion){
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion where duracion<" + duracion);
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones;
	}
	
	public ArrayList<Cancion> cancionesDisco(String cod) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Select * from esta where cod like '" + cod + "';";
			System.out.println("CadenaSQL: " + cadena);
			ResultSet rs = miStatement.executeQuery(cadena);
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en cancionesDisco");
			e.printStackTrace();
		}
		return canciones;
	}
	
	
	
	public ArrayList<Grupo> listadoGrupos() {
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from grupo");
			while (rs.next()) {
				grupos.add(new Grupo(rs.getString("cod"), rs.getString("nombre"), rs.getString("fecha"), rs.getString("pais")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return grupos;
	}
	
	public ArrayList<Disco> listadoDiscos() {
		ArrayList<Disco> discos = new ArrayList<Disco>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from disco");
			while (rs.next()) {
				discos.add(new Disco(rs.getString("cod"), rs.getString("nombre"), rs.getString("fecha"), rs.getString("cod_comp"), rs.getString("cod_gru")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return discos;
	}
	
	public ArrayList<Compania> listadoCompanias() {
		ArrayList<Compania> companias = new ArrayList<Compania>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from companyia");
			while (rs.next()) {
				companias.add(new Compania(rs.getString("cod"), rs.getString("nombre"), rs.getString("dir"), rs.getString("fax"), rs.getString("tfno")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoCompanias");
			e.printStackTrace();
		}
		return companias;
	}
	
	public ArrayList<Club> listadoClubes() {
		ArrayList<Club> clubes = new ArrayList<Club>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from club");
			while (rs.next()) {
				clubes.add(new Club(rs.getString("cod"), rs.getString("nombre"), rs.getString("sede"), rs.getString("num"), rs.getString("cod_gru")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoClubes");
			e.printStackTrace();
		}
		return clubes;
	}
	
	public boolean existeArtista (String dni) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from artista where dni like '" + dni +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeArtista");
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean existeCancion (String codCancion) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from cancion where cod like '" + codCancion +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeCancion");
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean existeDisco (String codDisco) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from disco where cod like '" + codDisco +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeDisco");
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean existeGrupo (String codGrupo) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from grupo where cod like '" + codGrupo +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			} else {
				System.out.println("No existe el grupo");
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeGrupo");
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean existeClub (String codClub) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from club where cod like '" + codClub +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeClub");
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean existeCompania (String codCompania) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "Select * from companyia where cod like '" + codCompania +"'";
			ResultSet rs = miStatement.executeQuery(sql);
			if(rs.next() == true) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en existeCompania");
			e.printStackTrace();
		}
		return existe;
	}
}