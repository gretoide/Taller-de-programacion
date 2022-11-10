/*Declaracion*/
        int fila = 10; //dimF
        int columna = 10; //dimC
        int[][] matriz = new  int[fila][columna]; //creamos la matriz con sus dimensiones

/*Asignación de datos*/
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                matriz[i][j] = GeneradorAleatorio.generarInt(200);
            }
        }

/*Imprimir Matriz*/
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                System.out.println("ELEMENTO [" + i + "][" + j + "] : " + matriz[i][j]);
            }
        }


/*VECTOR CON LA SUMA DE CADA COLUMNA*/
        for(i=0; i<fila; i++){ 
            for(j=0; j<columna; j++){ //suma toda una columna y lo agrega a un vector
                vector[i] = vector[i] + matriz[j][i];
            }
        }

/*Busqueda en matriz */
        i=0;j=0;
        while((i<fila)&&(!ok)){
            j=0;
            while((j<columna)&&(!ok)){
                if(matriz[i][j] == num){
                    System.out.println("EL NUMERO SE ENCUENTRA EN [" + i + "][" + j + "]");
                    ok = true;
                }
                j++;
            }
            i++;   
        }
        if(ok == false){
            System.out.println("NO ENCONRTO EL DATO.");
        }

/*Recorrer por columna */
for(int i=0; i<fila; i++){
            for(int j=0; j<columna; j++){
                total = total + matriz [j][i]; //cambia los indices para buscar por columna                                      
            }
            promedio = total/5; /*sacamos el promedio dentro del for, en la siguiente iteracion  va a ser
            otro especto*/
            System.out.println("El prodedio por el aspecto " + i +  "  " + "  es: " + promedio);
            total =0; //reiniciamos la variable para el                                     
        }