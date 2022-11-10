/*
6- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga informar:
- La cantidad de partidos que ganó River.
- El total de goles que realizó Boca jugando de local.
- El porcentaje de partidos finalizados con empate.
 */
package CLASE2.EJERCICIO6;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Greta Piacentini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cantPartidos = 5;
        int i = 0;
        String visitante,local;
        int golVis,golLoc;
        Partido partidillo;
        Partido campeonato[] = new Partido[cantPartidos];
        int cantEmpate = 0;    
        int partidosBoca = 0;
        int partidosRiver = 0;
        double porcentajeEmpates = 0;
        
        //CARGA LOS DATOS DEL CAMPEONATO
        System.out.println("-------------CARGA DE PARTIDOS----------");
        System.out.println("Equipo visitante: "); visitante = Lector.leerString();
        while((i<cantPartidos)&&(!(visitante.equals("ZZZ")))){
            System.out.println("Equipo local: "); local = Lector.leerString();
            System.out.println("Goles Visitante y goles Local: ");
            golVis = GeneradorAleatorio.generarInt(10);
            golLoc = GeneradorAleatorio.generarInt(10);
            partidillo = new Partido(local,visitante,golLoc,golVis);
            campeonato[i] = partidillo;
            i++;
            System.out.println("Equipo visitante: "); visitante = Lector.leerString();         
        }
        
        //IMPRIME LOS DATOS DEL CAMPEONATO
        System.out.println("-------------DATOS DEL CAMPEONATO----------");
        i=0;
        while((i<cantPartidos) && (campeonato[i] != null)){
            System.out.println("Local: " + campeonato[i].getLocal() + " / Goles Local:  " + campeonato[i].getGolesLocal());
            System.out.println("Visitante: " + campeonato[i].getVisitante() + "/ Goles Visitante:  " + campeonato[i].getGolesVisitante());
            System.out.println("___________________________________________");
            i++;
        }
        
        i=0;
        while((i<cantPartidos) && (campeonato[i] != null)){
            if(campeonato[i].getGanador().equals("river")){
                partidosRiver++;
            }
            if(campeonato[i].getLocal().equals("boca")){
                partidosBoca++;
            }
            if(campeonato[i].hayEmpate()==true){
                cantEmpate++;
            }
            i++;
        }
        
        
        System.out.println("-------------RESULTADOS-------------");
        System.out.println("PARTIDOS RIVER: " + partidosRiver);
        System.out.println("PARTIDOS con BOCA de LOCAL: " + partidosBoca);
        porcentajeEmpates = (cantPartidos/cantEmpate)*10;
        System.out.println("PORCENTAJE DE EMPATES: " + porcentajeEmpates);
    }
    
}
