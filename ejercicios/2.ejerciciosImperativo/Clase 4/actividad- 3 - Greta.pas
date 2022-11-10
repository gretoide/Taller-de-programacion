{ACTIVIDAD 3
En el programa ProgramaArbol.pas realizar las siguientes tareas:
a) Copiar el módulo Buscar que recibe un ABB y un valor y devuelve un
puntero al nodo donde se encuentra dicho valor. En caso de no encontrarlo,
retorna nil.
b) En el programa principal, invocar al módulo Buscar con un valor que se
ingresa de teclado. Informar si el valor buscado se encontró en el árbol o no.}
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
		write('INGRESE DATO: ');readln(n);
		while(n <> 0)do begin
			crearArbol(a,n);
			write('INGRESE DATO: ');readln(n);
		end;
	end;
	

function Buscar (a:arbol; dato: integer):arbol;
	begin
		if (a=nil) then
			Buscar:=nil
		else
		if (dato= a^.dato) then Buscar:=a
		else
			if (dato < a^.dato) then
				Buscar:=Buscar(a^.HI ,dato)
		else
			Buscar:=Buscar(a^.HD ,dato);
	end;



{PROGRAMA PRINCIPAL}
var
	dato:integer;
	a:arbol;
begin
 Randomize;
	cargarDatos(a);
	writeln('-------- MODULO DE BUSCA ---------');
	write('Ingrese dato: ');readln(dato);
	if(Buscar(a,dato) <> nil)then
		writeln('Se encontro el dato')
	else
		writeln('no se encontro el dato');

 readln;
end.

