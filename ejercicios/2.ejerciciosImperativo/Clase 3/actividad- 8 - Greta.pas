{ACTIVIDAD 8
Crear el programa ListaConRecursion.pas que:
a) Genere una lista de números enteros y muestre los valores guardados (utilizar los módulos del programaLista.pas ya visto)
b) Invoque a un módulo recursivo ImprimirEnOrden que imprima los valores contenidos en la lista en el orden en que se guardaron.
c) Invoque a un módulo recursivo ImprimirOrdenInverso que imprima los
valores contenidos en la lista desde el último dato al primero.}

program actividad8;

type
	
	lista = ^nodo;
	
	nodo = record
		dato:integer;
		sig:lista;
	end;
	
procedure agregarAtras(var l,ult:lista; n:integer); //SE ALMACENAN EN ORDEN
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dato:=n;
		nuevo^.sig:=nil;
		
		if (L = nil) then begin
			L:=nuevo;
			ult:=nuevo;
			end
			else
				ult^.sig:=nuevo;
				ult:=nuevo;
		
	end;
	
procedure crearLista(var l:lista); {proceso de armar listas}
	var
		n:integer;
		ult:lista;
	begin
		ult:=nil;
		n:=Random(5); {lee un numero}
		while(n <> 0)do begin  {mientras no se cumpla la condición de corte}
			agregarAtras(l,ult,n); {llama al proceso que enlaza los nodos y la variable}
			n:=Random(5); {vuelve a leer otro num}
		end;
	end;
	
{MODULOS PEDIDOS}

procedure imprimirLista(l:lista);
	begin
		if(l<>nil)then begin
			writeln(' [ ', l^.dato ,' ] ');
			imprimirLista(l^.sig);
		end;
	end;
	
procedure imprimirListaInvertida(l:lista);
	begin
		if(l<>nil)then begin
			imprimirListaInvertida(l^.sig);
			writeln(' [ ', l^.dato ,' ] ');
		end;
	end;
	
{programa principal}
VAR
	l:lista;
BEGIN
	l:=nil;
	writeln('--------- CARGA DE DATOS ---------');
	crearLista(l);
	writeln('--------- DATOS LISTA EN ORDEN ---------');
	imprimirLista(l);
	writeln('--------- DATOS LISTA EN ORDEN INVERSO ---------');
	imprimirListaInvertida(l);
END.
