public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private String genero;
    private double peso;
    private String tamaño;
    private String nombreDueño;
    private String correo;


    public Mascota(String nombre, String raza, int edad, String genero, double peso, String tamaño, String nombreDueño, String correo) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.tamaño = tamaño;
        this.nombreDueño = nombreDueño;
        this.correo = correo;
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}

public class Servicio {
    private String tipo;
    private int tiempoEstimado;
    private double costoBase;

    public Servicio(String tipo, int tiempoEstimado, double costoBase) {
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
        this.costoBase = costoBase;
    }

    // Getters and setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
}

// ControlMascota.java

import java.util.ArrayList;
import java.util.List;

public class ControlMascota {
    private List<Mascota> listaMascotas;

    public ControlMascota() {
        listaMascotas = new ArrayList<>();
    }

    public void registraMascota(Mascota mascota) {
        listaMascotas.add(mascota);
    }

    public int getCantidadMascotasRegistradas() {
        return listaMascotas.size();
    }

    public void registrarServicioMascota(String nombreMascota, String tipoServicio, double costoBase) {
        Mascota mascota = buscarMascotaPorNombre(nombreMascota);
        if (mascota != null) {
            double costoFinal = calcularCostoFinalServicio(mascota, tipoServicio, costoBase);
            System.out.println("El servicio de " + tipoServicio + " para " + nombreMascota + " tendrá un costo de " + costoFinal + " soles.");
        } else {
            System.out.println("Error: No se encontró la mascota con ese nombre.");
        }
    }

    private Mascota buscarMascotaPorNombre(String nombreMascota) {
        for (Mascota mascota : listaMascotas) {
            if (mascota.getNombre().equalsIgnoreCase(nombreMascota)) {
                return mascota;
            }
        }
        return null; // Si no se encuentra la mascota
    }

    private double calcularCostoFinalServicio(Mascota mascota, String tipoServicio, double costoBase) {
        double tam;
        switch (mascota.getTamaño().toLowerCase()) {
            case "pequeño":
                tam = 1;
                break;
            case "mediano":
                tam = 2;
                break;
            case "grande":
                tam = 3;
                break;
            default:
                tam = 0; // En caso de tamaño no válido
        }
        return costoBase + (costoBase * tam / mascota.getPeso());
    }
}

// ControlServicio.java

import java.util.ArrayList;
import java.util.List;

public class ControlServicio {
    private List<Servicio> listaServicios;

    public ControlServicio() {
        listaServicios = new ArrayList<>();
    }
    public void registraServicio(Servicio servicio) {
        listaServicios.add(servicio);

    }
}


// main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControlMascota controlMascota = new ControlMascota();
        ControlServicio controlServicio = new ControlServicio();
        int opcion;

        do {
            System.out.println("********************************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("(1) Registrar Mascota");
            System.out.println("(2) Registrar Servicios Generales");
            System.out.println("(3) Registrar Servicio de Mascota");
            System.out.println("(4) Total de mascotas en la veterinaria");
            System.out.println("(5) Salir");
            System.out.println("******************************");
            System.out.print("Ingrese la opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarMascota(controlMascota, scanner);
                    break;
                case 2:
                    registrarServicioGeneral(controlServicio, scanner);
                    break;
                case 3:
                    registrarServicioMascota(scanner, controlMascota);
                    break;
                case 4:
                    mostrarCantidadMascotas(controlMascota);
                    break;
                case 5:
                    System.out.println("----Cerrando el programa----");
                    break;
                default:
                    System.out.println("La opción NO es válida, ingrese nuevamente:");
                    break;
            }
        } while (opcion != 5);
    }

    public static void registrarMascota(ControlMascota controlMascota, Scanner scanner) {
        System.out.println("Registrar Mascota");
        System.out.println("-----------------------------------------------");
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese raza: ");
        String raza = scanner.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese género: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese peso (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese tamaño: ");
        String tamaño = scanner.nextLine();
        System.out.print("Ingrese nombre del dueño: ");
        String nombreDueño = scanner.nextLine();
        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        Mascota nuevaMascota = new Mascota(nombre, raza, edad, genero, peso, tamaño, nombreDueño, correo);
        controlMascota.registraMascota(nuevaMascota);
        System.out.println("Mascota registrada correctamente.");
    }

    public static void registrarServicioGeneral(ControlServicio controlServicio , Scanner scanner) {
        System.out.println("Registrar Servicio General");
        System.out.println("-----------------------------------------------");
        System.out.print("Ingrese tipo de servicio: ");
        String tipoServicio = scanner.nextLine();
        System.out.print("Ingrese tiempo estimado (horas): ");
        int tiempoEstimado = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el Costo Base (PEN): ");
        double costoBase = Double.parseDouble(scanner.nextLine());
        // Aquí puedes realizar lo que desees con los datos del servicio general

        Servicio servicio = new Servicio(tipoServicio, tiempoEstimado, costoBase);
        controlServicio.registraServicio(servicio);

        System.out.println("Servicio registrado correctamente.");
    }

    public static void registrarServicioMascota(Scanner scanner, ControlMascota controlMascota) {
        System.out.println("Registrar Servicio de Mascota");
        System.out.println("-----------------------------------------------");
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota = scanner.nextLine();
        System.out.print("Ingrese el tipo de servicio: ");
        String tipoServicio = scanner.nextLine();
        System.out.print("Ingrese el costo base del servicio (PEN): ");
        double costoBase = Double.parseDouble(scanner.nextLine());

        controlMascota.registrarServicioMascota(nombreMascota, tipoServicio, costoBase);
    }

    public static void mostrarCantidadMascotas(ControlMascota controlMascota) {
        System.out.println("Total de mascotas registradas en la veterinaria: " + controlMascota.getCantidadMascotasRegistradas());
    }
}
