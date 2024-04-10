import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bienvenido al juego de Esparco, la hormiga que come trigo");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Ingrese el ancho de la chacra en hormigómetros (hgmn): ");
        juego.setCols(sc.nextInt());
        sc.nextLine();
        System.out.printf("Ingrese el largo de la chacra en hormigómetros (hgmn): ");
        juego.setRows(sc.nextInt());
        sc.nextLine();
        System.out.printf("Ingrese la posición (x,y) de la hormiga: ");
        String posicion = sc.nextLine();
        String[] posiciones = posicion.split(" ");
        juego.setPosx(Integer.parseInt(posiciones[0]));
        juego.setPosy(Integer.parseInt(posiciones[1]));


        System.out.printf("Ingrese la dirección hacia la que apunta la cabeza de la hormiga (U,R,D,L): ");
        String[] direcciones = {"U", "R", "D", "L"};
        String direccion = sc.nextLine();
        for (int i = 0; i <3 ; i++) {
            if(direccion.equals(direcciones[i])){
                juego.setDirInicio(direccion);
                System.out.printf("Ingrese el número de fotos que capturará el poblador observador: ");
                juego.setNumfotos(sc.nextInt());
                sc.nextLine();
                System.out.printf("Ingrese el número de amplificación de filas y columnas en las que se ampliará la matriz: ");
                juego.setAmpliacion(sc.nextInt());
                sc.nextLine();

                juego.Juego();
            }
        }

public class Juego {
    private int rows;
    private int cols;
    private int posx;
    private int posy;
    private int numfotos;
    private String dirInicio;
    private int ampliacion;
    private String[][] chacra;

    public String[][] getChacra() {
        return chacra;
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getNumfotos() {
        return numfotos;
    }

    public void setNumfotos(int numfotos) {
        this.numfotos = numfotos;
    }

    public String getDirInicio() {
        return dirInicio;
    }

    public void setDirInicio(String dirInicio) {
        this.dirInicio = dirInicio;
    }

    public int getAmpliacion() {
        return ampliacion;
    }

    public void setAmpliacion(int ampliacion) {
        this.ampliacion = ampliacion;
    }

    public void setChacra(){
        String[][] chacra = new String[getRows()][getCols()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j <getCols() ; j++) {
                chacra[i][j] = ".";
            }
        }
        this.chacra = chacra;
    }
    public void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j <getCols() ; j++) {
                System.out.printf(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void Juego(){
        setChacra();
        String cuadrado = "■";
        String direccion = getDirInicio();
        String[][] chacrita = getChacra();
        //Ubicando la posicion inicial de la hormiga
        int posX = getPosx();
        int posY = getPosy();
        chacrita[posY][posX] = "H"; //Prevpos
        int prevPosX = posX;
        int prevPosY = posY;
        String prevVal = cuadrado; /*1 PUTA HORA PARA PENSAR TODO LO RELACIONADO A ESTA VARIABLE CSM*/
        System.out.println("----------------------------------------------------------");
        System.out.println("Foto 1: Momento previo a la recoleccion de la hormiga");
        System.out.println("----------------------------------------------------------");
        imprimirMatriz(chacrita);
        for (int i = 0; i < getNumfotos() - 1; i++) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Foto numero " + (i+2) + " de la hormiga en la chacra:");
            System.out.println("----------------------------------------------------------");
            switch (direccion) {
                case "U": //Arriba [-1][]
                    posX = prevPosX;
                    posY = prevPosY - 1;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    //Actualizar direccion
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "R";
                    }

                    else{
                        prevVal = ".";
                        direccion = "L";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "R": //Derecha [][+1]
                    posX = prevPosX + 1;
                    posY = prevPosY;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "D";
                    }
                    else{
                        prevVal = ".";
                        direccion = "U";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "D": //Abajo [+1][]
                    posX = prevPosX;
                    posY = prevPosY + 1;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "L";
                    }
                    else{
                        prevVal = ".";
                        direccion = "R";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "L": //Izquierda [][-1]
                    posX = prevPosX - 1;
                    posY = prevPosY;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "U";
                    }
                    else{
                        prevVal = ".";
                        direccion = "D";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
            }
            imprimirMatriz(chacrita);
        }
    }
}


    }
