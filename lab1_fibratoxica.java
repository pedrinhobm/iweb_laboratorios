// Usuario.java
public class Usuario {
    private String nombre;
    private String apellido;
    private Integer codigoPucp;
    private String email;
    private String condicion;
    private int edad;
    private int sueldo;
    private int anoEgreso;
    private Actividad actividad;

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

    public Integer getCodigoPucp() {
        return codigoPucp;
    }

    public void setCodigoPucp(Integer codigoPucp) {
        this.codigoPucp = codigoPucp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getAnoEgreso() {
        return anoEgreso;
    }

    public void setAnoEgreso(int anoEgreso) {
        this.anoEgreso = anoEgreso;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}


// Actividad.java

public class Actividad {
    private String nombre;
    private String cargo;
    private int horasApoyar;
    private int diezmo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasApoyar() {
        return horasApoyar;
    }

    public void setHorasApoyar(int horasApoyar) {
        this.horasApoyar = horasApoyar;
    }

    public int getDiezmo() {
        return diezmo;
    }

    public void setDiezmo(int diezmo) {
        this.diezmo = diezmo;
    }
}

// Main.java
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Usuario user = null;
        Scanner sc = new Scanner(System.in);
        regisIter:
        while(true) {
            if (user == null) {
                user = new Usuario();
                System.out.println("Usted no se ha registrado, ingrese sus datos personales");
                System.out.print("->Ingrese su nombre:");
                user.setNombre(sc.nextLine());
                System.out.print("->Ingrese su apellido:");
                user.setApellido(sc.nextLine());
                System.out.print("->Ingrese su código PUCP:");
                user.setCodigoPucp(Integer.parseInt(sc.nextLine()));
                System.out.print("->Ingrese su mail PUCP:");
                user.setEmail(sc.nextLine());
                System.out.print("->Ingrese su condición(Alumno o Egresado):");
                user.setCondicion(sc.nextLine());
                System.out.print("->Ingrese su edad:");
                user.setEdad(Integer.parseInt(sc.nextLine()));
                if (user.getCondicion().equalsIgnoreCase("egresado")) {
                    System.out.print("->Ingrese su sueldo:");
                    user.setSueldo(Integer.parseInt(sc.nextLine()));
                    System.out.print("->Ingrese su anho de egreso:");
                    user.setAnoEgreso(Integer.parseInt(sc.nextLine()));
                }
            }
            else {
                System.out.print("->Ingrese su código PUCP:");
                int codigoIn = Integer.parseInt(sc.nextLine());
                if (codigoIn == user.getCodigoPucp()){
                    inIter:
                    while(true) {
                        System.out.println("Bienvenido " + user.getNombre() + " " + user.getApellido());
                        System.out.println("Escoja una de las sigusafientes opciones:");
                        System.out.println("opción (1) .- Registrar actividad a la cual apoyaré");
                        System.out.println("opción (2) .- Diagnóstico de apoyo");
                        System.out.println("opción (3) .- Ver mi resumen");
                        System.out.println("opción (4) .- Salir del menú");
                        System.out.print("->Ingrese su opción:");
                        String opcion = sc.nextLine();
                        switch (opcion){
                            case "1" :{
                                System.out.println("Registre la actividad a la cual apoyará\n");
                                op1Iter:
                                while(true) {
                                    System.out.print("->Ingrese el nombre de la actividad a apoyar:");
                                    String actApoyar = sc.nextLine();
                                    if (actApoyar.equals("futsal") || actApoyar.equals("voley") || actApoyar.equals("4xjugo") || actApoyar.equals("glotones") || actApoyar.equals("basquet")) {
                                        user.setActividad(new Actividad());
                                        user.getActividad().setNombre(actApoyar);
                                        System.out.print("Ingrese su cargo (Barras o Jugar):");
                                        user.getActividad().setCargo(sc.nextLine());
                                        System.out.print("Ingrese sus horas de apoyo a la fibra:");
                                        user.getActividad().setHorasApoyar(Integer.parseInt(sc.nextLine()));
                                        System.out.print("Ingrese su diezmo:");
                                        user.getActividad().setDiezmo(Integer.parseInt(sc.nextLine()));
                                        break op1Iter;
                                    } else {
                                        System.out.println("***Ingresar un nombre de actividad correcto***");
                                    }
                                }
                                break;
                            }
                            case "2" :{
                                if (user.getCondicion().equalsIgnoreCase("egresado")){
                                    int resultado = 0;
                                    int numero = user.getCodigoPucp();
                                    while(numero > 0) {
                                        resultado += numero % 10;
                                        numero = numero / 10;
                                    }
                                    int factor = user.getEdad() + resultado;
                                    int year = Calendar.getInstance().get(Calendar.YEAR);
                                    int diezmoDes = user.getSueldo()/10 + (year-user.getAnoEgreso()) * factor;
                                    if (diezmoDes < user.getActividad().getDiezmo()){
                                        user.getActividad().setDiezmo(diezmoDes);
                                    }
                                    double calcular = (((double)diezmoDes - (double)user.getActividad().getDiezmo())/(double)diezmoDes);
                                    System.out.print("Usted ");
                                    if(calcular<=0.1){
                                        System.out.println("Es un hincha de nacimiento, se agradece profundamente la donación realizada a la fibra de corazón");
                                    }
                                    if (calcular<=0.3 && calcular>0.11){
                                        System.out.println("Es un Hinba, la fibra está con usted y usted con la fibra");
                                    }
                                    if(calcular<=0.5 && calcular>0.31){
                                        System.out.println("Necesita alentar más a la fibra, pero la fibra está conforme con su apoyo actual");
                                    }
                                    if(calcular<=0.7 && calcular>0.51){
                                        System.out.println("Necesita encariñarse más con la fibra, sabemos que el próximo año le pondrá más apoyo");
                                    }
                                    if(calcular<=0.99 && calcular>0.71){
                                        System.out.println("Es un pecho frío, pero se le agradece la colaboración");
                                    }
                                    if(calcular == 1){
                                        System.out.println("No tiene comentarios, puesto que no apoyó a la fibra");
                                    }

                                }
                                else {
                                    System.out.println("Usted apoyó con "+user.getActividad().getDiezmo()+" soles y la fibra le agradece");
                                }
                                break;
                            }
                            case "3" :{
                                System.out.println("Nombre completo: "+user.getNombre()+" "+user.getApellido());
                                System.out.println("Edad: "+user.getEdad());
                                System.out.println("Codigo PUCP: "+user.getCodigoPucp());
                                System.out.println("Apoyo a la actividad de: "+user.getActividad().getNombre()+" como parte de "+user.getActividad().getCargo());
                                System.out.println("Además apoyo a la fibra con "+user.getActividad().getHorasApoyar()+" horas semanales");
                                break;
                            }
                            case "4" :{
                                break regisIter;
                            }
                            default:
                                System.out.println("Ingrese una opción válida\n");

                        }
                    }
                }
                else {
                    System.out.println("Código PUCP inválido");
                }
            }
        }
    }
}
