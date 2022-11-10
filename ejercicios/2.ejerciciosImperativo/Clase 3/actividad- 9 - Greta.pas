{
* ACTIVIDAD 9
En el programa ListaConRecursion:
a) Implementar un módulo recursivo Máximo que devuelva el máximo valor
de la lista.
b) Implementar un módulo recursivo Mínimo que devuelva el mínimo valor de
la lista.
c) Implementar un módulo recursivo Buscar que devuelva verdadero si un
valor determinado se encuentra en la lista o falso en caso contrario.}
program actividad9;

type
  lista = ^nodo;
  
  nodo = record
    dato:integer;
    sig:lista;
  
  end;
  
procedure agregarAdelante(var L:lista; elem:integer);
	var
		nue:lista;
	begin
		new(nue);
		nue^.dato:= elem;
		nue^.sig:= L;
		L:= nue;
	end;

procedure crearListaAgregarAdelante(var L:lista);
	var
		elem:integer;
	begin
		write('NUM: ');readln(elem);
		while(elem <> 0)do begin
			agregarAdelante(L,elem);
			write('NUM: ');readln(elem);
		end;
	end;

procedure imprimirLista(L:lista);
	begin
		if(L <> nil)then begin
			writeln('DATO: ',L^.dato);
			L:= L^.sig;
			imprimirLista(L);
		end;
	end;

procedure maximo(L:lista; var max:integer);
	begin
		if(L <> nil)then begin
			if(L^.dato > max)then
				max:= L^.dato;
		 L:= L^.sig;
		 maximo(L,max);
		end;
	end;

procedure minimo(L:lista; var min:integer);
	begin
		if(L <> nil)then begin
			if(L^.dato < min)then
				min:= L^.dato;
		 L:= L^.sig;
		 minimo(L,min);
		end;
	end;

procedure buscar(L:lista; elem:integer; var ok:boolean); {podria ser una funcion?}
	begin
		if(L <> nil)then begin
			if(L^.dato = elem)then
			 ok:= true;
		 L:= L^.sig;
         buscar(L,elem,ok);
		end;
	end;
	
{programa principal}
var
	L:lista;
	max:integer;
	min:integer;	
	ok:boolean;
	elem:integer;
begin
	L:= nil;
	max:= -1;
	min:= 999;
	ok:= false;
	crearListaAgregarAdelante(L);
	writeln('------------- ELEMENTOS DE LA LISTA -------------');
	imprimirLista(L);
	writeln('------------- MAXIMOS Y MINIMOS -------------');
	maximo(L,max);
	minimo(L,min);
	writeln('MAX: ',max);
	writeln('MIN: ',min);
	writeln('------------- BUSQUEDA -------------');
	write('INGRESE NUM: ');readln(elem);
	buscar(L,elem,ok);
	if(ok)then
		writeln('El numero se encuentra en la lista')
	else
		writeln('El numero no se encuentra en la lista');
end.

