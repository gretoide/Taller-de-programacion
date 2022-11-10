{ACTIVIDAD 2
En el programa ProgramaArbol.pas realizar las siguientes tareas:
a) Implementar el módulo enOrden que imprima los valores del ABB ya
generado en orden ascendente al criterio de orden. Pensar: ¿y si se pidiera
orden descendente?
b) Implementar el módulo preOrden que imprima los valores del ABB ya
generado.
c) Implementar el módulo postOrden que imprima los valores del ABB ya
generado.
d) Invocar cada uno de los módulos anteriores y comparar los resultados
obtenidos.}

program ejercicio2;
 type
	
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
	
procedure PreOrden(a:arbol); {imprime primero el nodo, luego los hijos}
	begin
		if(a <> nil)then begin
			writeln(a^.dato);
			PreOrden(a^.hi);
			PreOrden (a^.hd);
		end;
	end;
	
procedure enOrden(a:arbol); {imprime en el orden}
	begin
		if (a <> nil) then begin
			enOrden (a^.HI);
			writeln(a^.dato);
			enOrden (a^.HD);
		end;
	end;
	
procedure postOrden(a:arbol); {primero hijos, luego padre}
	begin
		if (a <> nil) then begin
			postOrden(a^.HI);
			postOrden(a^.HD);
			writeln(a^.dato);
		end;
	end;
	
{PROGRAMA PRINCIPAL}
VAR
	a:arbol;
BEGIN
	cargarDatos(a);
	writeln('---------- PRE ORDEN ----------');
	preOrden(a);
	writeln;
	writeln('---------- EN ORDEN ----------');
	enOrden(a);
	writeln;
	writeln('---------- POST ORDEN ----------');
	postOrden(a);
END.

