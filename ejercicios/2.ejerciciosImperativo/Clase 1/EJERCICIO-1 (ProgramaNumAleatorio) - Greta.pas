program NumAleatorio; {nombre del programa}

var
	num: integer;	{variable local al programa}

begin {programa principal}
	Randomize; {habilita el randomize}
	num := random (100); {a la variable num se le asigna un valor random en el intervalo 0 a 99}
	writeln ('El numero aleatorio generado es: ', num); {luego imprime el contenido de la variable}
	readln;
end.

{
*que hace el programa?
* rta: crea una variable local, le asigna un valor random y luego lo imprime en pantalla}
