package MusicaBD;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc = 0, opc2 = 0, opc3 = 0, opc4 = 4, opc5= 0, opc6= 0;
		BDController controladorBD = new BDController();
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		ArrayList<Artista> artis = new ArrayList<Artista>();
		ArrayList<Cancion> cancis = new ArrayList<Cancion>();
		ArrayList<Grupo> grupitos = new ArrayList<Grupo>();
		ArrayList<Disco> disquitos = new ArrayList<Disco>();
		ArrayList<Compania> companiitas = new ArrayList<Compania>();
		ArrayList<Club> clubesitos = new ArrayList<Club>();
		
		do {
			Main.mostrarMenu();
			opc = sn.nextInt();
			switch(opc) {
				case 1:
					do {
						Main.mostrarMenuListadosSimples();
						opc2 = sn.nextInt();
						switch(opc2) {
							case 1:
								artis = controladorBD.listadoArtistas();
								for (int i = 0; i < artis.size(); i++) {
									System.out.print("Nombre: ");
									System.out.print(artis.get(i).getNombre());
									System.out.print(" DNI: ");
									System.out.println(artis.get(i).getDni());
								}
								System.out.println("--------------");
								break;
							case 2:
								cancis = controladorBD.listadoCanciones();
								for (int i = 0; i < cancis.size(); i++) {
									System.out.print("T�tulo: ");
									System.out.print(cancis.get(i).getTitulo());
									System.out.print(" C�digo: ");
									System.out.print(cancis.get(i).getCod());
									System.out.print(" Duraci�n: ");
									System.out.println(cancis.get(i).getDuracion());
								}
								System.out.println("--------------");
								break;
							case 3:
								grupitos = controladorBD.listadoGrupos();
								for (int i = 0; i < grupitos.size(); i++) {
									System.out.print("Nombre: ");
									System.out.print(grupitos.get(i).getNombre());
									System.out.print("C�digo: ");
									System.out.print(grupitos.get(i).getCod());
									System.out.print("Fecha: ");
									System.out.print(grupitos.get(i).getFecha());
									System.out.print("Pa�s: ");
									System.out.println(grupitos.get(i).getPais());
								}
								System.out.println("--------------");
								break;
							case 4:
								disquitos = controladorBD.listadoDiscos();
								for (int i = 0; i < disquitos.size(); i++) {
									System.out.print("Nombre: ");
									System.out.print(grupitos.get(i).getNombre());
									System.out.print("C�digo: ");
									System.out.print(grupitos.get(i).getCod());
									System.out.print("Fecha: ");
									System.out.print(grupitos.get(i).getFecha());
									System.out.print("Pa�s: ");
									System.out.println(grupitos.get(i).getPais());
								}
								System.out.println("--------------");
								break;
							case 5:
								companiitas = controladorBD.listadoCompanias();
								for (int i = 0; i < companiitas.size(); i++) {
									System.out.print("C�digo: ");
									System.out.print(companiitas.get(i).getCod());
									System.out.print("Nombre: ");
									System.out.print(companiitas.get(i).getNombre());
									System.out.print("Direcci�n: ");
									System.out.print(companiitas.get(i).getDir());
									System.out.print("Fax: ");
									System.out.print(companiitas.get(i).getFax());
									System.out.print("Tel�fono: ");
									System.out.println(companiitas.get(i).getTfno());
								}
								System.out.println("--------------");
								break;
							case 6:
								clubesitos = controladorBD.listadoClubes();
								for (int i = 0; i < clubesitos.size(); i++) {
									System.out.print("C�digo: ");
									System.out.print(clubesitos.get(i).getCod());
									System.out.print("Nombre: ");
									System.out.print(clubesitos.get(i).getNombre());
									System.out.print("Sede: ");
									System.out.print(clubesitos.get(i).getSede());
									System.out.print("N�mero: ");
									System.out.print(clubesitos.get(i).getNum());
									System.out.print("C�digo Grupo: ");
									System.out.println(clubesitos.get(i).getCod_gru());
								}
								System.out.println("--------------");
								break;
							case 7:
								System.out.println("Saliendo");
								break;
							default:
								System.out.println("Error elige bien la opci�n elegida.");
								break;
						}
					}while(opc2!=7);
					break;
				case 2:
					do {
						Main.mostrarMenuAltas();
						opc3 = sn.nextInt();
						switch(opc3) {
							case 1:
								System.out.println("Dime el DNI del artista para comprobar si ya existe registro de �l");
								String dni = sc.nextLine();
								if (controladorBD.existeArtista(dni) == false) {
									System.out.println("Bien no existe dicho artista en la base de datos.");
									System.out.println("Dime el DNI del artista:");
									String dniArtista = sc.nextLine();
									System.out.println("Dime el nombre del artista:");
									String nombreArtista = sc.nextLine();
									controladorBD.dardeAltaArtista(new Artista(dniArtista, nombreArtista));
								} else {
									System.out.println("Existe el artista, introduce un artista que no est� en la base de datos");
								}
								break;
							case 2:
								System.out.println("Dime el c�dido de la canci�n para comprobar si ya existe registro de ella");
								String codCancion = sc.nextLine();
								if (controladorBD.existeCancion(codCancion) == false) {
									System.out.println("Bien no existe dicha canci�n en la base de datos.");
									System.out.println("Dime el c�digo de la canci�n:");
									String codigoCancion = sc.nextLine();
									System.out.println("Dime el t�tulo de la canci�n:");
									String tituloCancion = sc.nextLine();
									System.out.println("Dime la duraci�n de la canci�n:");
									double duracionCancion = sn.nextDouble();
									controladorBD.dardeAltaCancion(new Cancion(codigoCancion, tituloCancion, duracionCancion));
								} else {
									System.out.println("Existe la canci�n, introduce un artista que no est� en la base de datos");
								}
								break;
							case 3:
								System.out.println("Dime el c�dido del grupo para comprobar si ya existe registro de ella");
								String codGrupo = sc.nextLine();
								if (controladorBD.existeGrupo(codGrupo) == false) {
									System.out.println("Bien no existe dicho grupo en la base de datos.");
									System.out.println("Dime el c�digo del grupo:");
									String codigoGrupo = sc.nextLine();
									System.out.println("Dime el nombre del grupo:");
									String nombreGrupo = sc.nextLine();
									System.out.println("Dime la fecha de creaci�n del grupo:");
									String fechaGrupo = sc.nextLine();
									System.out.println("Dime el pa�s del grupo:");
									String paisGrupo = sc.nextLine();
									controladorBD.dardeAltaGrupo(new Grupo(codigoGrupo, nombreGrupo, fechaGrupo, paisGrupo));
								} else {
									System.out.println("Existe el grupo, introduce un grupo que no est� en la base de datos");
								}
								break;
							case 4:
								System.out.println("Dime el c�dido del disco para comprobar si ya existe registro de ella");
								String codDisco = sc.nextLine();
								if (controladorBD.existeDisco(codDisco) == false) {
									System.out.println("Bien no existe dicho disco en la base de datos.");
									System.out.println("Dime el c�digo del disco:");
									String codigoDisco = sc.nextLine();
									System.out.println("Dime el nombre del disco:");
									String nombreDisco = sc.nextLine();
									System.out.println("Dime la fecha de publicacion del disco:");
									String fechaDisco = sc.nextLine();
									System.out.println("Dime el c�digo de la compa�ia asociada al disco:");
									String codComp = sc.nextLine();
									System.out.println("Dime el c�digo del grupo autor del disco:");
									String codGru = sc.nextLine();
									controladorBD.dardeAltaDisco(new Disco(codigoDisco, nombreDisco, fechaDisco, codComp, codGru));
								} else {
									System.out.println("Existe el disco, introduce un disco que no est� en la base de datos");
								}
								break;
							case 5:
								System.out.println("Dime el c�dido de la compania para comprobar si ya existe registro de ella");
								String codCompania = sc.nextLine();
								if (controladorBD.existeCompania(codCompania) == false) {
									System.out.println("Bien no existe dicha compa�ia en la base de datos.");
									System.out.println("Dime el c�digo de la compan�a:");
									String codigoCompania = sc.nextLine();
									System.out.println("Dime el nombre de la compa�ia:");
									String nombreCompania = sc.nextLine();
									System.out.println("Dime la direcci�n de la compa��a:");
									String dirCompania = sc.nextLine();
									System.out.println("Dime el fax de la compa�ia:");
									String faxCompania = sc.nextLine();
									System.out.println("Dime el c�digo del grupo autor del disco:");
									String tfnoCompania = sc.nextLine();
									controladorBD.dardeAltaCompania(new Compania(codigoCompania, nombreCompania, dirCompania, faxCompania, tfnoCompania));
								} else {
									System.out.println("Existe la compa�ia, introduce una compa�ia que no est� en la base de datos");
								}
								break;
							case 6:
								System.out.println("Dime el c�dido del disco para comprobar si ya existe registro de ella");
								String codClub = sc.nextLine();
								if (controladorBD.existeClub(codClub) == false) {
									System.out.println("Bien no existe dicho club en la base de datos.");
									System.out.println("Dime el c�digo del club:");
									String codigoClub = sc.nextLine();
									System.out.println("Dime el nombre del club:");
									String nombreClub = sc.nextLine();
									System.out.println("Dime la direcci�n de la sede del club:");
									String dirClub = sc.nextLine();
									System.out.println("Dime el n�mero del club:");
									String numClub = sc.nextLine();
									System.out.println("Dime el c�digo del grupo asociado al club:");
									String codClubGru = sc.nextLine();
									controladorBD.dardeAltaClub(new Club(codigoClub, nombreClub, dirClub, numClub, codClubGru));
								} else {
									System.out.println("Existe el club, introduce un club que no est� en la base de datos");
								}
								break;
							case 7:
								System.out.println("Saliendo");
								break;
							default:
								System.out.println("Error elige bien la opci�n elegida.");
								break;
							
						}
					}while(opc!=7);
					
					break;
				case 3:
					do {
						Main.mostrarMenuBajas();
						opc4 = sn.nextInt();
						switch(opc4) {
							case 1:
								System.out.println("Introduce el dni de un artista:");
								String DNIArtista = sc.nextLine();
								if (!controladorBD.existeArtista(DNIArtista)) {
									for (int i = 0; i < artis.size(); i++) {
										if(artis.get(i).getDni().equalsIgnoreCase(DNIArtista)) {
											controladorBD.dardeBajaArtista(artis.get(i));
										}
									}
								} else {
									System.out.println("No hay ning�n artista con ese dni");
								}
								break;
							case 2:
								System.out.println("Dime el c�digo de una cancion para comprobar si ya existe registro de �l");
								System.out.println("Introduce el c�digo de una canci�n");
								String codigoCancion = sc.nextLine();
								if (controladorBD.existeCancion(codigoCancion) == false) {
									for (int i = 0; i < cancis.size(); i++) {
										if(cancis.get(i).getCod().equalsIgnoreCase(codigoCancion)) {
											controladorBD.dardeBajaCancion(cancis.get(i));
										}
									}
								} else {
									System.out.println("No hay ninguna canci�n con ese c�digo");
								}
								break;
							case 3:
								System.out.println("Dime el c�digo de un grupo para comprobar si ya existe registro de �l");
								System.out.println("Introduce el c�digo de un grupo");
								String codigoGrupo = sc.nextLine();
								if (controladorBD.existeGrupo(codigoGrupo) == false) {
									for (int i = 0; i < grupitos.size(); i++) {
										if(grupitos.get(i).getCod().equalsIgnoreCase(codigoGrupo)) {
											controladorBD.dardeBajaGrupo(grupitos.get(i));
										}
									}
								} else {
									System.out.println("No hay ning�n artista con ese dni");
								}
								break;
							case 4:
								System.out.println("Dime el c�digo del disco para comprobar si ya existe registro de ella");
								String codigoDisco = sc.nextLine();
								if (controladorBD.existeDisco(codigoDisco) == false) {
									for (int i = 0; i < disquitos.size(); i++) {
										if(disquitos.get(i).getCod().equalsIgnoreCase(codigoDisco)) {
											controladorBD.dardeBajaDisco(disquitos.get(i));
										}
									}
								} else {
									System.out.println("Existe el disco, introduce un disco que no est� en la base de datos");
								}
								break;
							case 5:
								System.out.println("Dime el c�digo de la compania para comprobar si ya existe registro de ella");
								String codigoCompania = sc.nextLine();
								if (controladorBD.existeDisco(codigoCompania) == false) {
									for (int i = 0; i < companiitas.size(); i++) {
										if(companiitas.get(i).getCod().equalsIgnoreCase(codigoCompania)) {
											controladorBD.dardeBajaCompania(companiitas.get(i));
										}
									}
								} else {
									System.out.println("Existe el disco, introduce un disco que no est� en la base de datos");
								}
								break;
							case 6:
								System.out.println("Dime el c�digo de la compania para comprobar si ya existe registro de ella");
								String codigoClub = sc.nextLine();
								if (controladorBD.existeDisco(codigoClub) == false) {
									for (int i = 0; i < clubesitos.size(); i++) {
										if(clubesitos.get(i).getCod().equalsIgnoreCase(codigoClub)) {
											controladorBD.dardeBajaClub(clubesitos.get(i));
										}
									}
								} else {
									System.out.println("Existe el disco, introduce un disco que no est� en la base de datos");
								}
								break;
							case 7:
								System.out.println("Saliendo");
								break;
							default:
								System.out.println("Error elige bien la opci�n elegida.");
								break;	
						}
					}while(opc!=7);
					break;
				case 4:
					break;
				case 5:
					do {
						Main.mostrarMenuListadosPersonalizados();
						opc5 = sn.nextInt();
						switch(opc5) {
							case 1:
								System.out.println("Introduce una letra");
								String letra = sc.nextLine();
								artis = controladorBD.listadoArtistasPorLetra(letra);
								for (int i = 0; i < artis.size(); i++) {
									System.out.print("Nombre: ");
									System.out.print(artis.get(i).getNombre());
									System.out.print(" DNI: ");
									System.out.println(artis.get(i).getDni());
								}
								break;
							case 2:
								Cancion can = controladorBD.cancionmasLarga();
								System.out.print("T�tulo: ");
								System.out.print(can.getTitulo());
								System.out.print(" C�digo: ");
								System.out.print(can.getCod());
								System.out.print(" Duraci�n: ");
								System.out.println(can.getDuracion());
								System.out.println("--------------");
								break;
							case 3:
								System.out.println("Introduce una duracion");
								double duracion = sn.nextDouble();
								cancis = controladorBD.cancionesMenorLongitud(duracion);
								for (int i = 0; i < cancis.size(); i++) {
									System.out.print("T�tulo: ");
									System.out.print(cancis.get(i).getTitulo());
									System.out.print(" C�digo: ");
									System.out.print(cancis.get(i).getCod());
									System.out.print(" Duraci�n: ");
									System.out.println(cancis.get(i).getDuracion());
								}
								System.out.println("--------------");
								break;
							case 4:
								System.out.println("Saliendo");
								break;
							default:
								System.out.println("Error elige bien la opci�n elegida.");
								break;	
						}
					}while(opc!=4);
					break;
				case 6:
					break;
				case 7:
					System.out.println("Saliendo");
					break;
				default:
					System.out.println("Error elige bien la opci�n elegida.");
					break;
			}
		}while(opc!=7);
		
	}
	
	public static void mostrarMenu() {
		System.out.println("Selecciona una opci�n");
		System.out.println("1. Listados simples.");
		System.out.println("2. Altas.");
		System.out.println("3. Bajas.");
		System.out.println("4. Modificaciones.");
		System.out.println("5. Listados personalizados.");
		System.out.println("6. Operaciones complejas.");
		System.out.println("7. Salir.");
	}
	
	public static void mostrarMenu2() {
		System.out.println("Selecciona otra opci�n");
		System.out.println("1. Listados simples.");
		System.out.println("2. Altas.");
		System.out.println("3. Bajas.");
		System.out.println("4. Modificaciones.");
		System.out.println("5. Listados personalizados.");
		System.out.println("6. Operaciones complejas.");
		System.out.println("7. Salir.");
	}
	
	public static void mostrarMenuListadosSimples() {
		System.out.println("Selecciona una opci�n");
		System.out.println("1. Listado de artistas.");
		System.out.println("2. Listado de canciones.");
		System.out.println("3. Listado de grupos.");
		System.out.println("4. Listado de discos.");
		System.out.println("5. Listado de compa�ias.");
		System.out.println("6. Listado de clubes.");
		System.out.println("7. Salir.");
	}
	
	public static void mostrarMenuAltas() {
		System.out.println("Selecciona una opci�n");
		System.out.println("1. Alta de artistas.");
		System.out.println("2. Alta de canciones.");
		System.out.println("3. Alta de grupos.");
		System.out.println("4. Alta de discos.");
		System.out.println("5. Alta de compa�ias.");
		System.out.println("6. Alta de clubes.");
		System.out.println("7. Salir.");
	}
	
	public static void mostrarMenuBajas() {
		System.out.println("Selecciona una opci�n");
		System.out.println("1. Baja de artistas.");
		System.out.println("2. Baja de canciones.");
		System.out.println("3. Baja de grupos.");
		System.out.println("4. Baja de discos.");
		System.out.println("5. Baja de compa�ias.");
		System.out.println("6. Baja de clubes.");
		System.out.println("7. Salir.");
	}
	
	public static void mostrarMenuListadosPersonalizados() {
		System.out.println("Selecciona una opci�n");
		System.out.println("1. Listado de artistas con DNI que acabe en una letra pedida al usuario.");
		System.out.println("2. Mostrar  datos de la canci�n m�s larga y la m�s corta.");
		System.out.println("3. Listado de canciones con duraci�n menor a una duraci�n pedida al usuario.");
	}
	
}
