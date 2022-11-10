{ACTIVIDAD 4
En el programa ProgramaArbol.pas realizar las siguientes tareas:
a) Implementar el módulo VerMin que reciba un árbol y devuelva el valor
mínimo. En caso de recibir un árbol vacío, retornar -1.
Pensar: dónde se encuentra el mínimo según el criterio de orden
b) Implementar el módulo VerMax que reciba un árbol y devuelva el valor
máximo. En caso de recibir un árbol vacío, retornar -1.
Pensar: dónde se encuentra el máximo según el criterio de orden
c) En el programa principal, invocar a los módulos generados en a) y b).
Informar los resultados obtenidos.
* }
Program arboles;
Type

 	arbol = ^nodo;
	
	nodo = record
		dato:integer;
		hi:arbol;
		hd:arbol;
	end;

  listaNivel = ^nodoN;
  
  nodoN = record
    info: arbol;
    sig: listaNivel;
  end;
	
procedure crearArbol(var a:arbol; n:integer); {modulo b}
	begin
		if(a = nil)then begin
			new(a);
			a^.dato:=n;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if not(a^.dato = n)then begin {else para descartar repeticiones en al abb}
			if(a^.dato > n)then
				crearArbol(a^.hi,n)
			else
				crearArbol(a^.hd,n);
		end;
	end;	
	
procedure cargarDatos(var a:arbol);
	var
		n:integer;
	begin
		a:=nil;
		write('INGRESE DATO: ');n:=Random(10);
		while(n <> 0)do begin
			crearArbol(a,n);
			write('INGRESE DATO: ');n:=Random(10);
		end;
	end;
	
procedure PreOrden(a:arbol); {imprime primero el nodo, luego los hijos}
	begin
		if(a <> nil)then begin
			writeln(a^.dato);
			PreOrden(a^.hi);
			PreOrden (a^.hd);
		end;
	end;
	
function maximoArbol(a:arbol):integer;
	begin
		if(a<>nil)then begin
			if(a^.hd = nil)then
				maximoArbol:=a^.dato
			else
				maximoArbol:=maximoArbol(a^.hd)
		end
		else
			maximoArbol:=-1;
	end;
	
function minimoArbol(a:arbol):integer;
	begin
		if(a<>nil)then begin
			if(a^.hi = nil)then
				minimoArbol:=a^.dato
			else
				minimoArbol:=minimoArbol(a^.hi)
		end
		else
			minimoArbol:=-1;
	end;
{PROGRAMA PRINCIPAL}
var
	a:arbol;
begin
	Randomize;
	cargarDatos(a);
	preOrden(a);
	writeln('MAX ARBOL: ',maximoArbol(a));
	writeln('MIN ARBOL: ',minimoArbol(a));
 readln;
end.

