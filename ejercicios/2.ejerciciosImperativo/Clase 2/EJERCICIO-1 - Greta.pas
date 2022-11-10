program actividad5;

const
  dimF = 10;

type
	egresado = record
		numAlu:integer;
		apellido:string[10];
		promedio:real;
	end;
  
  vector = array[1..dimF] of egresado;

procedure leerEgresado(var eg:egresado);
	begin
		write('NRO ALUMNO: ');readln(eg.numAlu);
		if(eg.numAlu <> 0)then begin
			{write('APELLIDO: ');readln(eg.apellido);}
			write('PROMEDIO: ');readln(eg.promedio);
		end;
	end;

procedure intercambio(var v:vector; dimL, pos:integer; eg:egresado); {este proceso cambia los lugares}
	var
		i:integer;
		aux:egresado;
	begin
		for i:= dimL downto pos do begin {desde la diml, hasta la posicion que recibe por parametro}
			aux:= v[i]; {guarda el valor para no perderlo
			y va haciendo corrimientos hacia atrás}
			v[i]:= eg; 
			v[i+1]:= aux;
		end; 
	end;

procedure ordenarPorPromedio(var v:vector; var dimL:integer; eg:egresado);
	var
		i:integer;
	begin
		i:= 1;
		while(i < dimF) and (v[i].promedio >= eg.promedio)do {mientras el promedio del vector sea mayor al del registro nuevo}
			i:= i+1; {avanza}
		if(dimL < dimF)then {una vez que sale del while, evalua si aun tenemos espacio en el vector}
			dimL:= dimL + 1; {si es así, aumenta la diml}
		if(i <= dimF)then {si donde estamos parados, aun hay lugar}
			intercambio(v,dimL,i,eg); {llama al modulo de intercambiar, mandandole el i como posicion a insertar}
	end;

procedure cargarVector(var v:vector; var dimL:integer);
	var
		eg:egresado;
	begin
		leerEgresado(eg);
		while(eg.numAlu <> 0)do begin
			ordenarPorPromedio(v,dimL,eg); {llama al proceso para agregar los datos de manera ordenada al vector}
			leerEgresado(eg);
		end;
	end;

procedure inicializarVector(var vec: vector); {carga todos los promedios en 0}
	var
		i: integer;
	begin
		for i := 1 to dimF do
			vec[i].promedio := 0;
	end;

procedure imprimirVector(v:vector); {imprime vector}
var
 i:integer;
begin
  for i:= 1 to dimF do begin
    writeln('| NRO ALUMNO: ',v[i].numAlu, ' | PROMEDIO: ',v[i].promedio:0:1);
    writeln;
  end;
end;

{ENUNCIADOS CLASE 2}

procedure ordenarInsercion (var v:vector; diml:integer); //MAYOR A MENOR
	var
		i,j:integer;
		actual:egresado;
	begin
		for i:= 2 to diml do begin
			actual:= v[i];
			j:= i-1;
			while (j > 0) and (v[j].promedio > actual.promedio) do begin
				v[j+1]:= v[j];
				j:= j-1;
			end;
			v[j+1]:= actual;
		end;
	end;

procedure busquedaDicotomica(v:vector; var ini,fin: integer; dato:real; var pos:integer);
	var
		medio:integer;
	begin
		if (ini <= fin) then begin
			medio:= (ini + fin) div 2;
			if (v[medio].promedio = dato) then 
				pos:= medio
			else begin
				if (v[medio].promedio < dato) then begin
					medio:=medio+1;
					busquedaDicotomica(v,medio,fin,dato,pos);
				end
				else begin
					if (v[medio].promedio > dato) then begin
						medio:=medio-1;
						busquedaDicotomica (v,ini,medio,dato,pos);
					end;
				end;
			end;
		end
		else 
			pos:= 0; {valor que retorna al no encontrar el elemento}
	end;


var
	v:vector;
	dimL:integer;
	promedioBuscado:real;
	pos,ini:integer;
begin
	dimL:= 0;
	writeln('---------------------- CARGA DE DATOS ---------------------- ');
	cargarVector(v,dimL);
	writeln('---------------------- DATOS INGRESADOS ---------------------- ');
	imprimirVector(v);
	writeln('---------------------- ORDENADO POR INSERCCION ---------------------- ');
	ordenarInsercion(v,dimL);
	imprimirVector(v);
	writeln('---------------------- BUSQUEDA DICOTOMICA ---------------------- ');
	writeln;
	write('Ingrese el promedio que desea encontrar:  ');readln(promedioBuscado);
	ini:=1;
	busquedaDicotomica(v,ini,dimL,promedioBuscado,pos);
	writeln('La POS del promedio es: ',pos);
	readln;
end.
