// usuario.java 
import java.sql.SQLData;
import java.util.HashSet;

public class Usuario {
    private String nombre;
    private int codigoPUCP;
    private HashSet<Libro> registroLibros=new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(int codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public HashSet<Libro> getRegistroLibros() {
        return registroLibros;
    }

    public void setRegistroLibros(HashSet<Libro> registroLibros) {
        this.registroLibros = registroLibros;
    }
}
// manager.java
public class Manager {
}

// libro.java
public class Libro {
    private String titulo;
    private String autor;
    private int ISBN;
    private boolean disponibilidad;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
// libro.java
import java.lang.reflect.Array;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Biblioteca {
    Scanner scanner=new Scanner(System.in);
    Libro[][]estanteLibros;
    ArrayList<Usuario>listaUsuarios;

    public Biblioteca(Libro[][] estanteLibros, ArrayList<Usuario> listaUsuarios) {
        this.estanteLibros = estanteLibros;
        this.listaUsuarios = listaUsuarios;
    }

    public void agregarUsuario(Usuario usuario){
        for(Usuario user:listaUsuarios){
            if(user.getCodigoPUCP()==usuario.getCodigoPUCP()){
                System.out.println("El ID de usuario ya está en uso. Intente con otro.");
                return;
            }
        }listaUsuarios.add(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    public void agregarLibroEstante(Libro libro,int fila,int columna){
        if(estanteLibros[fila][columna]==null){
            libro.setDisponibilidad(true);
            estanteLibros[fila][columna]=libro;
            System.out.println("Libro agregado al estante con éxito.");
        }else{
            System.out.println("La posición ingresada está ocupada por un libro.");
        }
    }

    public void prestarLibro(Libro libro,Usuario usuario){
        if(usuario.getRegistroLibros().isEmpty()){
            if(libro.isDisponibilidad()){
                libro.setDisponibilidad(false);
                usuario.getRegistroLibros().add(libro);
            }else {
                System.out.println("El libro ya ha sido prestado, por lo que no se puede prestar a " + usuario.getNombre());
            }
        }else{
            System.out.println("El usuario ya tiene un libro prestado y no puede tomar otro.");
        }
    }

    public void devolverLibro(Libro libro,Usuario usuario){
        if (!libro.isDisponibilidad()){
            if(!usuario.getRegistroLibros().isEmpty()){
                for(Libro book: usuario.getRegistroLibros()){
                    if(libro==book){
                        libro.setDisponibilidad(true);
                        usuario.getRegistroLibros().remove(libro);
                        System.out.println("El libro '"+ libro.getTitulo()+"' ha sido devuelto por "+usuario.getNombre());
                        return;
                    }
                }
                System.out.println("No se puede devolver el libro, ya que no está prestado a este usuario.");
            }
        }else{
            System.out.println("El libro está disponible en el estante.");
        }
    }

    public void mostrarUsuarios(){
        System.out.println("Usuarios y libros prestados:");
        for(Usuario usuario:listaUsuarios){
            System.out.println(usuario.getNombre()+" (ID: "+usuario.getCodigoPUCP()+")");
            if(usuario.getRegistroLibros().isEmpty()){
                System.out.println("- Ningún libro prestado.");
            }else{
                for(Libro libro:usuario.getRegistroLibros()){
                    System.out.println("- "+libro.getTitulo());
                }
            }
        }
    }

    public void librosDisponiblesPrestados(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(estanteLibros[i][j]==null){
                    System.out.print("| Vacío ");
                }else{
                    if(estanteLibros[i][j].isDisponibilidad()){
                        System.out.print("| "+estanteLibros[i][j].getTitulo()+" (Disponible) ");
                    }else{
                        System.out.print("| "+estanteLibros[i][j].getTitulo()+" (No disponible) ");
                    }
                }

            }
            System.out.print("|\n");
        }
    }

    public void mostrarLibros(){
        System.out.println("Libros disponibles: ");
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(!(estanteLibros[i][j]==null)){
                    if(estanteLibros[i][j].isDisponibilidad()){
                        System.out.println("Título: "+estanteLibros[i][j].getTitulo()+" | Autor: "+estanteLibros[i][j].getAutor()+" | ISBN: "+estanteLibros[i][j].getISBN());
                    }
                }
            }
        }
    }
}

// main.java

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libro[][]estanteLibros=new Libro[7][7];
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        Biblioteca biblioteca=new Biblioteca(estanteLibros,listaUsuarios);
        main:while(true){
            System.out.print("--- Menú de la Biblioteca ---\n1. Agregar usuario\n2. Agregar libro\n3. Prestar libro\n4. Devolver libro\n5. Mostrar libros disponibles\n6. Mostrar usuarios y libros prestados\n7. Estante\nSeleccione una opción: ");
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    Usuario newUser=new Usuario();
                    System.out.print("Nombre del usuario: ");
                    newUser.setNombre(scanner.nextLine());
                    System.out.print("Código PUCP: ");
                    newUser.setCodigoPUCP(Integer.parseInt(scanner.nextLine()));
                    biblioteca.agregarUsuario(newUser);
                    break;
                case 2:
                    Libro newBook=new Libro();
                    System.out.print("Título del libro: ");
                    newBook.setTitulo(scanner.nextLine());
                    System.out.print("Autor del libro: ");
                    newBook.setAutor(scanner.nextLine());
                    System.out.print("ISBN del libro: ");
                    newBook.setISBN(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Fila en el estante (0-7): ");
                    int fila=Integer.parseInt(scanner.nextLine());
                    System.out.print("Columna en el estante (0-7): ");
                    int columna=Integer.parseInt(scanner.nextLine());
                    biblioteca.agregarLibroEstante(newBook,fila,columna);
                    break;
                case 3:
                    System.out.print("ID del usuario: ");
                    int ID=Integer.parseInt(scanner.nextLine());
                    Usuario userFound=new Usuario();
                    userFound.setNombre("");
                    for(Usuario usuario: biblioteca.listaUsuarios){
                        if(usuario.getCodigoPUCP()==ID){
                            userFound.setNombre(usuario.getNombre());
                            userFound.setCodigoPUCP(usuario.getCodigoPUCP());
                            userFound.setRegistroLibros(usuario.getRegistroLibros());
                            break;
                        }
                    }
                    if(userFound.getNombre().equals("")){
                        System.out.println("El usuario indicado no está registrado.");
                    }else{
                        System.out.println("ISBN del libro a prestar: ");
                        int ISBN=Integer.parseInt(scanner.nextLine());
                        aux:for(int i=0;i<7;i++){
                            for(int j=0;j<7;j++){
                                if(biblioteca.estanteLibros[i][j]!=null){
                                    if(biblioteca.estanteLibros[i][j].getISBN()==ISBN) {
                                        biblioteca.prestarLibro(biblioteca.estanteLibros[i][j], userFound);
                                        break aux;
                                    }
                                }
                            }
                        }
                    }break;
                case 4:
                    System.out.print("ID del usuario: ");
                    int ID2=Integer.parseInt(scanner.nextLine());
                    Usuario userFound2=new Usuario();
                    userFound2.setNombre("");
                    for(Usuario usuario: biblioteca.listaUsuarios){
                        if(usuario.getCodigoPUCP()==ID2){
                            userFound2.setNombre(usuario.getNombre());
                            userFound2.setCodigoPUCP(usuario.getCodigoPUCP());
                            userFound2.setRegistroLibros(usuario.getRegistroLibros());
                            break;
                        }
                    }
                    if(userFound2.getNombre()==""){
                        System.out.println("El usuario indicado no está registrado.");
                    }else{
                        System.out.println("ISBN del libro a prestar: ");
                        int ISBN2=Integer.parseInt(scanner.nextLine());
                        for(int i=0;i<7;i++){
                            for(int j=0;j<7;j++){
                                if(biblioteca.estanteLibros[i][j]!=null){
                                    if(biblioteca.estanteLibros[i][j].getISBN()==ISBN2){
                                        biblioteca.devolverLibro(biblioteca.estanteLibros[i][j],userFound2);
                                        continue main;
                                    }
                                }
                            }
                        }
                        System.out.println("El ISBN no corresponde a ningún libro registrado.");
                    }break;
                case 5:
                    biblioteca.mostrarLibros();
                    break;
                case 6:
                    biblioteca.mostrarUsuarios();
                    break;
                case 7:
                    biblioteca.librosDisponiblesPrestados();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta.");
                    break;
            }
        }

    }
}
