/*
 Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.*/
package CLASE2.EJERCICIO2_PERSONA;

import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Greta Piacentini
 */
public class Persona2Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int dimf = 15;
       int diml = 0;
       Persona vector[] = new Persona[dimf];
       Persona personita;
       String menorDni = null;
       int personasMayores = 0;
       int dniMin = 99999;
       int dni, edad;
       String nombre;
       int i=0;
       GeneradorAleatorio.iniciar();
       
       
       //cargamos el vector
  
       System.out.print("INGRESE EDAD, DNI Y NOMBRE - "); edad = GeneradorAleatorio.generarInt(100);       
       while((i<dimf)&&(edad != 0)){
           dni = GeneradorAleatorio.generarInt(40);
           nombre = GeneradorAleatorio.generarString(10); 
           personita = new Persona(nombre,dni,edad);
           vector[i] = personita;
           diml++;
           i++;
           System.out.print("INGRESE EDAD - "); edad = GeneradorAleatorio.generarInt(70); 
       }
       
       //imprimir vector
       for(i=0;i<diml;i++){
           System.out.println(vector[i].toString());
       }
       
       for(i=0;i<diml;i++){
           if(65 > vector[i].getEdad()){ //me cuenta uno más(?
               personasMayores++;
           }
           if(vector[i].getDNI()<dniMin){
               dniMin=vector[i].getDNI();
               menorDni=vector[i].toString();
           }
       }

        System.out.println("PERSONAS MAYORES A 65 AÑOS: " + personasMayores);
        System.out.println("PERSONA CON MENOR DNI");
        System.out.println(menorDni);
       
    }
    
}
