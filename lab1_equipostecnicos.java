public class Equipo {
    private String marca;
    private String tipo;
    private int cantidadPuertos;
    private String numeroSerie;
    private float costo;

    public Equipo(String marca, String tipo, int cantidadPuertos, String numeroSerie, float costo) {
        this.marca = marca;
        this.tipo = tipo;
        this.cantidadPuertos = cantidadPuertos;
        this.numeroSerie = numeroSerie;
        this.costo = costo;
    }

    // Getters and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadPuertos() {
        return cantidadPuertos;
    }

    public void setCantidadPuertos(int cantidadPuertos) {
        this.cantidadPuertos = cantidadPuertos;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}

public class Tecnico {
    private String nombre;
    private String apellido;
    private String dni;
    private String edad;
    private int telefono;
    private float salario;
    private String cargo;

    public Tecnico(String nombre, String apellido, String dni, String edad, int telefono, float salario, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.salario = salario;
        this.cargo = cargo;
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

// AppController.java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class AppController {
    private List<Equipo> listaEquipos;
    private List<Tecnico> listaTecnicos;
    // variable listaEquipos , Equipo tipo de valor
    public AppController() {
        listaEquipos = new ArrayList<>();
        listaTecnicos = new ArrayList<>();
    }

    // Método para registrar un nuevo equipo
    public void registrarNuevoEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar Nuevo Equipo");
        System.out.println("Marca:");
        String marca = scanner.nextLine();
        System.out.println("Tipo:");
        String tipo = scanner.nextLine();
        System.out.println("Cantidad de puertos:");
        int cantidadPuertos = Integer.parseInt(scanner.nextLine());
        System.out.println("Costo:");
        float costo = Float.parseFloat(scanner.nextLine());
        System.out.println("Número de serie:");
        String numeroSerie = scanner.nextLine();

        // Verificar si el número de serie ya existe
        for (Equipo equipo : listaEquipos) {
            if (equipo.getNumeroSerie().equals(numeroSerie)) {
                System.out.println("Error, ya existe el número de serie");
                return;
            }
        }

        // Crear y agregar el nuevo equipo a la lista !existeNumeroSerie(numeroSerie)
        Equipo nuevoEquipo = new Equipo(marca, tipo, cantidadPuertos, numeroSerie, costo);
        listaEquipos.add(nuevoEquipo);
    }

    // Método para registrar un nuevo técnico
    public void registrarNuevoTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar Nuevo Técnico");
        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Apellido:");
        String apellido = scanner.nextLine();
        System.out.println("DNI:");
        String dni = scanner.nextLine();
        System.out.println("Edad:");
        String edad = scanner.nextLine();
        System.out.println("Teléfono:");
        int telefono = Integer.parseInt(scanner.nextLine());
        System.out.println("Salario:");
        float salario = Float.parseFloat(scanner.nextLine());
        System.out.println("Cargo:");
        String cargo = scanner.nextLine();

        // Verificar si el DNI ya existe
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getDni().equals(dni)) {
                System.out.println("Error, ya existe el DNI");
                return;
            }
        }

        // Crear y agregar el nuevo técnico a la lista
        Tecnico nuevoTecnico = new Tecnico(nombre, apellido, dni, edad, telefono, salario, cargo);
        listaTecnicos.add(nuevoTecnico);
    }

    // Método para listar equipos
    public void listarEquipos() {
        System.out.println("Listado de Equipos:");
        for (Equipo equipo : listaEquipos) {
            System.out.println("Marca: " + equipo.getMarca() + ", Tipo: " + equipo.getTipo() + ", Cantidad de puertos: " + equipo.getCantidadPuertos() + ", Número de serie: " + equipo.getNumeroSerie() + ", Costo: " + equipo.getCosto());
        }
    }

    // Método para listar técnicos por salario
    public void listarTecnicosXSalario(float salarioMinimo) {
        System.out.println("Listado de Técnicos con Salario mayor a " + salarioMinimo + ":");
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getSalario() > salarioMinimo) {
                System.out.println("Nombre: " + tecnico.getNombre() + " " + tecnico.getApellido() + ", DNI: " + tecnico.getDni() + ", Salario: " + tecnico.getSalario() + ", Cargo: " + tecnico.getCargo());
            }
        }
    }
}

// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppController appController = new AppController();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("| Menú |");
            System.out.println("| 1 <- Registrar Nuevo Equipo |");
            System.out.println("| 2 <- Registrar Nuevo Técnico |");
            System.out.println("| 3 <- Listar Equipos |");
            System.out.println("| 4 <- Listar técnicos x salario |");
            System.out.println("| 5 <- Buscar técnico x DNI |");
            System.out.println("| 9 <- Salir |");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            System.out.print("Ingrese opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    appController.registrarNuevoEquipo();
                    break;
                case 2:
                    appController.registrarNuevoTecnico();
                    break;
                case 3:
                    appController.listarEquipos();
                    break;
                case 4:
                    System.out.println("Ingrese salario mínimo:");
                    float salarioMinimo = Float.parseFloat(scanner.nextLine());
                    appController.listarTecnicosXSalario(salarioMinimo);
                    break;
                case 5:
                    // Implementar búsqueda de técnico por DNI
                    break;
                case 9:
                    System.out.println("--- Cerrando Programa ---");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 9);
    }
}
