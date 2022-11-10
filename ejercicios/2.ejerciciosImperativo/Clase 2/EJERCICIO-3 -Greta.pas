{Se cuenta con información de los empleados de una empresa. De cada empleado se
conoce su número de empleado, apellido_y_nombre, antigüedad en años y categoría (1..4).
El programa debe:
a. Leer los datos de empleados hasta que se ingresa el nro. de empleado 0 y guardarlos
ordenados alfabéticamente por apellido_y_nombre y agrupados por categoría.
b. Una vez guardados (implemente un módulo para cada inciso)
i. Para cada categoría, mostrar la información de todos sus empleados.
ii. Generar un vector que contenga, para cada categoría, el empleado más antiguo.
iii. Ordenar el vector por antigüedad (descendente) e informar su contenido.}

program vectorDeListas;

const
	dimf = 4;
type
	subrango = 1..4;
	cadena = string[10];
	
	empleado = record
		nro:integer;
		nombreCompleto:cadena;
		antiguedad:integer;
		categoria:subrango;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato:empleado;
		sig:lista;
	end;
	
	vector = array[subrango] of lista;
	
	vector2 = array[subrango] of empleado;
	
procedure leerRegistro(var r:empleado);
	begin
		write('NRO EMPLEADO: ');readln(r.nro);
		if(r.nro <> 0)then begin
			write('NOMBRE COMPLETO: ');readln(r.nombreCompleto);
			write('ANTIGUEDAD: ');readln(r.antiguedad);
			write('CATEGORAIA (1..4): ');readln(r.categoria);
		end;
		writeln;
	end;
	
procedure agregarOrd (var l:lista; emp:empleado);
	var
		ant,act,nuevo:lista;
	begin
		act:= l;
		ant:= l;
		new (nuevo); 
		nuevo^.dato:= emp; 
		nuevo^.sig:= nil;
		while (act <> nil) and (act^.dato.nombreCompleto < nuevo^.dato.nombreCompleto) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if (l = act) then
			l:= nuevo
		else
			ant^.sig:= nuevo;
		nuevo^.sig:= act;
	end;
	
procedure cargarVector (var v:vector);
	var
		r:empleado;
	begin
		leerRegistro(r);
		while (r.nro <> 0) do begin
			agregarOrd(v[r.categoria],r);
			leerRegistro(r);
		end;
	end;
	

procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to dimf do
			v[i]:= nil;
	end;

procedure recorrerLista (l:lista);
begin
	while (l <> nil) do begin
		writeln ('NRO EMPLEADO: ',l^.dato.nro,'| NOMBRE: ',l^.dato.nombreCompleto,'| ANTIGUEDAD: ',l^.dato.antiguedad, '| CATEGORIA: ', l^.dato.categoria);
		l:= l^.sig;
	end;
end;

procedure recorrerImprimiendo (v:vector);
	var
		i:subrango;
	begin
		for i:= 1 to dimf do begin
			writeln('------------ CATEGORIA ', i , ' ------------');
			recorrerLista (v[i]);
		end;
	end;

{modulo (b)}

procedure imprimirV2 (v:vector2);
	var
		i:subrango;
	begin
		for i:= 1 to dimf do begin
			writeln('NRO EMPLEADO: ',v[i].nro,'| NOMBRE: ',v[i].nombreCompleto,'| ANTIGUEDAD: ',v[i].antiguedad, '| CATEGORIA: ', v[i].categoria);
		end;
	end;

procedure recorrerLista2 (l:lista; var empMaximo:empleado);
var
	max:integer;
begin
	max:=-1;
	while (l <> nil) do begin
		if(l^.dato.antiguedad > max)then begin
			max:=l^.dato.antiguedad;
			empMaximo:=l^.dato;
		end;
		l:= l^.sig;
	end;
end;

procedure recorrerBuscando (v:vector; var v2:vector2);
	var
		emp:empleado;
		i:subrango;
	begin
		for i:= 1 to dimf do begin
			recorrerLista2(v[i],emp);
			v2[i]:=emp;
		end;
	end;
	
procedure ordenarInsercion (var v:vector2); //MAYOR A MENOR
var
i,j:integer;
actual:empleado;
begin
	for i:= 2 to dimf do begin
		actual:= v[i];
		j:= i-1;
		while (j > 0) and (v[j].antiguedad < actual.antiguedad) do begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= actual;
	end;
end;

{programa principal}
VAR
	v:vector;
	v2:vector2;
BEGIN
	inicializar(v);
	cargarVector(v);
	recorrerImprimiendo(v);
	writeln('----------- VECTOR DE MAXIMOS -----------');
	recorrerBuscando(v,v2);
	imprimirV2(v2);
	writeln('----------- VECTOR ORDENADO ------------');
	ordenarInsercion(v2);
	imprimirV2(v2);
	readln;
END.
