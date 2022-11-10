/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greta Piacentini
 */
public class MainProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proyecto proyectito = new Proyecto("Ekoa","AS45TW");
   
        Investigador investi1 = new Investigador("Pepe","Mono",2,"Quimica");
        Subsidio subsidio1 = new Subsidio(1500,"Agua");
        investi1.agregarSubsidio(subsidio1);
        Investigador investi2 = new Investigador("Jose","Aguila",1,"Matematicas");
        Subsidio subsidio2 = new Subsidio(1300,"Luz");
        investi2.agregarSubsidio(subsidio2);
        investi1.otorgarSubsidio(0);
    
        proyectito.agregarInvestigador(investi1);         
        proyectito.agregarInvestigador(investi2);
    
        System.out.println(proyectito.toString());
    }
    
}
