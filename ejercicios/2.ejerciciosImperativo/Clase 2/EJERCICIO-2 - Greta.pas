{ Implementar un programa que procese la información de los jugadores de un torneo de básquet. De cada jugador se lee: dni, nombre y altura.
  El ingreso de los jugadores finaliza cuando se lee el dni 0 (que no debe procesarse).
  Se pide:
     a.Cargar la información en una lista. Los jugadores deben quedar en el mismo orden que fueron leídos.
     b.Mostrar la información almacenada en la lista.
     c.Generar un vector con aquellos jugadores que superan el promedio de altura. Se sabe de antemano que como máximo son 20.
     d.Mostrar la información almacenada en el vector.
     e.Ordenar el vector de jugadores por dni (ascendente)
     f.Mostrar el vector ordenado.
     g.Buscar en el vector al jugador cuyo dni coincide con uno ingresado e imprimir su altura.
  NOTA: Reutilice los módulos implementados con anterioridad.}
program equipoDeBasquet;

const
  dimf = 20;
type
  lista = ^nodo;
  
	jugador = record
		dni:integer;
		nombre:string;
		altura:real;
	end;
  
	nodo  = record
		dato:jugador;
        sig :lista;
    end;
  
	vector = array[1..dimf]of jugador;

procedure LeerDatos(var reg: jugador);
    begin
      write('DNI:');readln(reg.dni);
      if(reg.dni <> 0)then begin
			write('NOMBRE: ');readln(reg.nombre);
			write('ALTURA: ');readln(reg.altura);
       end;
    end;

procedure crearLista(var l, ult:lista; reg:jugador);
	var
		nuevo:lista;
    begin
		new(nuevo);
        nuevo^.dato := reg;
        nuevo^.sig:= nil;
        if(l <> nil)then
			ult^.sig:= nuevo
        else
			l:= nuevo;
		ult:= nuevo;
    end;

procedure cargarDatos(var l: lista; var alturaPromedio:real);
  var
    reg:jugador;
    ult:lista;
    cantJugadores:integer;
    alturaTotal:real;
    begin
		l:= nil;
        ult:= nil;
		alturaTotal:=0;
		cantJugadores := 0;
		LeerDatos(reg);
		while(reg.dni <>  0)do begin
			alturaTotal:= alturaTotal + reg.altura; {va contando los jugadores y sumando sus alturas para el promedio}
			cantJugadores:= cantJugadores + 1;
			crearLista(l,ult,reg);
			LeerDatos(reg);
        end;
        alturaPromedio:= alturaTotal/cantJugadores; {saca el promedio cuando ya no carga más}
    end;

procedure imprimir(l: lista);
	begin
		while(l <> nil)do begin
			writeln('NOMBRE: ', l^.dato.nombre, ' | DNI: ', l^.dato.dni, ' | ALTURA: ', l^.dato.altura:0:1);
			l:= l^.sig;
		end;
    end;

procedure imprimirVector(v:vector; diml: integer);
	var
		i:integer;
    begin
       for i := 1 to diml do
		writeln('NOMBRE: ', v[i].nombre, ' | DNI: ', v[i].dni, ' | ALTURA: ', v[i].altura:0:1);
    end;

procedure cargarVector(var v: vector; l:lista; promedio:real; var diml:integer); 
	var
		indice:integer;                                                                      
    begin
		indice:= 1;
		diml  := 0;
		while(l<>nil)and(indice <= dimF)do begin
			if(l^.dato.altura > promedio)then begin
				v[indice]:= l^.dato;
				diml := indice;
            end;
         l := l^.sig;
         indice:= indice + 1;
        end;
    end;
 
procedure ordenarVector(var v:vector; diml: integer);
	var
		i,j: integer;                                              
		dato: jugador;
    begin
		for i:= 2 to diml do begin
			dato:= v[i];
            j := i-1;
            while(j>0)and(v[j].dni > dato.dni )do begin
				v[j+1]:= v[j];
                j := j-1;
            end;
            v[j+1]:= dato;
        end;
    end;

procedure buscador(v: vector; diml, dni: integer );
	var
		i: integer;
		encontro: boolean;
    begin
		encontro:= false;
		i:= 1;
		while(i<= diml)and(not encontro)do begin
			if(v[i].dni = dni)then begin
				writeln('La altura del jugador buscado es : ' , v[i].altura);
                encontro := true;
            end
            else
              i:= i+1;
        end;
    end;

{programa principal}
var
  l: lista;
  diml, dni : integer;
  promedio : real;
  v: vector;
begin
  CargarDatos(l,promedio);
  imprimir(l);                                 
  writeln('--------------- ALTURA PROMEDIO --------------- ');
  writeln('La altura promedio es: ' , promedio:0:1);
  writeln('--------------- VECTOR ---------------');
  cargarVector(v,l,promedio,diml);
  imprimirVector(v,diml);                      { Parte D... Mostrar la información almacenada en el vector.}
  writeln('--------------- VECTOR ORDENADO ---------------');
  ordenarVector(v,diml);
  imprimirVector(v,diml);                      { Parte F... Mostrar el vector ordenado}
  writeln('--------------- BUSQUEDA DNI ---------------');
  readln(dni);
  buscador(v,diml,dni);                             {Parte G... Buscar en el vector al jugador cuyo dni coincide con uno ingresado e imprimir su altura}
  readln;
end.

