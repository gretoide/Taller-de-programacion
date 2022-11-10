program programaLista;

type {donde declaramos listas, vectores, subrangos}
	lista = ^nodo; {lista que apunta a un registro nodo}
	
	nodo = record {nodo de la lista}
		dato:integer;
		sig:lista; {sig de tipo lista}
	end;
	
	lista2 = ^nodo2; {segunda lista con metodo agregar atrás}
	
	nodo2 = record
		dato:integer;
		sig:lista2;
	end;
	
	lista3 = ^nodo3; {tercera lista ORDENADA con insercción}
	
	nodo3 = record
		dato:integer;
		sig:lista3;
	end;

procedure agregarAdelante(var l:lista; num:integer); {proceso que crea los nodos}
	var
		nuevo:lista; {nuevo elemento del tipo lista}
	begin
		new(nuevo); {reserva espacio en memoria}
		nuevo^.dato:=num; {nuevo, apuntando a dato es = a el num}
		nuevo^.sig:=l; {el nuevo elemento, a punta al primero de la lista}
		l:=nuevo; {el primer elemento ahora es este nuevo}
	end;

procedure crearListaAgregarAdelante(var l:lista); {proceso que agrega los nodos a la lista}
	var
		num:integer;
	begin
		Randomize;
		num:=Random(16); {otorga valor de 0 a 15}
		while(num<>0)do begin
			agregarAdelante(l,num);
			num:=Random(16);
		end;
	end;
	
procedure agregarAtras(var l,ult:lista2; num:integer); //SE ALMACENAN EN ORDEN
	var
		nuevo:lista2;
	begin
		new(nuevo); {reserva espacio en memoria}
		nuevo^.dato:=num; {asigna el dato}
		nuevo^.sig:=nil; {el siguiente es nil}
		
		if (l=nil) then begin {en caso de que sea el primero, ambos son nuevo}
			l:=nuevo;
			ult:=nuevo;
			end
			else
				ult^.sig:=nuevo; {enlaza el ultimo con el nuevo, para que quede atrás}
				ult:=nuevo; {el ultimo pasa a ser el nuevo}
		
	end;
	
procedure crearListaAgregarAtras(var l,ult:lista2); {proceso que agrega los nodos a la lista}
	var
		num:integer;
	begin
		Randomize;
		num:=Random(16); {otorga valor de 0 a 15}
		while(num<>0)do begin
			agregarAtras(l,ult,num);
			num:=Random(16);
		end;
	end;
	
procedure insertarEnLista (var l:lista3; elem:integer);
	var ant, nuevo, act: lista3;
	begin
		new (nuevo); {reserva espacio}
		nuevo^.dato:= elem; {datos = elemento}
		act := l; {ubicamos puntero auxilar al principio de la lista}
		while (act<>NIL) and (act^.dato<elem) do begin {mientras no llegue a nil ni el dato supere al buscado}
		{busca recorriendo con punteros auxiliares}
			ant := act; 
			act := act^.sig; {actual siempre apunta al siguietne}
		end;
		{una vez salidos del while, evaluamos condiciones}
		if (act = l) then {si la lista está vacía}
			l:= nuevo
		else 
			ant^.sig := nuevo; {el siguiente del anterior, es el nuevo}
		nuevo^.sig := act ; {el siguiente del nuevo, es el actual}
		{queda insertado anterior --> nuevo ---> actual 
		* (que pasa a ser siguiente del nuevo)}
		end;
		
procedure crearListaOrdenada(var l:lista3); {proceso que agrega los nodos a la lista}
	var
		num:integer;
	begin
		Randomize;
		num:=Random(16); {otorga valor de 0 a 15}
		while(num<>0)do begin
			insertarEnLista(l,num);
			num:=Random(16);
		end;
	end;

procedure imprimirLista(l:lista); {hay alguna forma de reutilizar este modulo?}
	begin
		while(l<>nil)do begin
			writeln('Numero Random: ', l^.dato); {imprime el dato de la lista}
			l:=l^.sig; {pasa al siguiente elemento de la lista}
		end;
	end;

procedure imprimirLista2(l:lista2);
	begin
		while(l<>nil)do begin
			writeln('Numero Random: ', l^.dato); {imprime el dato de la lista}
			l:=l^.sig; {pasa al siguiente elemento de la lista}
		end;
	end;

procedure imprimirLista3(l:lista3); {hay alguna forma de reutilizar este modulo?}
	begin
		while(l<>nil)do begin
			writeln('Numero Random: ', l^.dato); {imprime el dato de la lista}
			l:=l^.sig; {pasa al siguiente elemento de la lista}
		end;
	end;
{PROGRAMA PRINCIPAL}
VAR
	l:lista;
	l2,ult:lista2;
	l3:lista3;
BEGIN
	l:=nil;
	l2:=nil;
	l3:=nil;
	
	crearListaAgregarAdelante(l);
	imprimirLista(l);
	writeln('*** FINAL DE LA LISTA 1 ***');
	crearListaAgregarAtras(l2,ult);
	imprimirLista2(l2);
	writeln('*** FINAL DE LA LISTA 2 ***');
	crearListaOrdenada(l3);
	imprimirLista(l3);
	writeln('*** FINAL DE LA LISTA 3 ***');
END.
