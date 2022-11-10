{Implemente ProgramaMerge4Listas.pas que:
a. Invoque al módulo CrearVectorListas que genera un vector de 4 listas de libros ordenadas
ascendente, teniendo en cuenta que: cada libro se representa con un código ISBN (entero e/ 0 y 15)
y que para cada lista se ingresan libros hasta el 0. Reusar el módulo CrearListaOrdenada del
ProgramaListas.pas (clase 1).
b. Invoque al módulo ImprimirVectorListas que imprime en pantalla el contenido de cada lista del
vector. Reusar el módulo ImprimirLista del ProgramaListas.pas (clase 1).

c. Invoque al módulo Merge que recibe el vector generado en a) y devuelve una nueva lista ordenada
ascendente con los elementos de las 4 listas originales. Luego imprima la lista resultante.
Para implementar el merge utilice el pseudocódigo analizado en la clase.
Además este módulo requiere:
c.1. Implementar el módulo DeterminarMinimo que retorne el valor mínimo de un vector de listas
ordenadas de forma creciente. Dicho valor se debe quitar de la lista original. Para esto, utilice el
pseudocódigo analizado en clase.
procedure determinar_minimo( var v: vectorListas; var min: integer);
c.2. Implementar el módulo AgregarAtras en una lista de enteros. Reusar el módulo provisto en clase 1.
procedure AgregarAtras (var pri, ult: lista; elem: integer);}

program ejercicio1;

const
	dimf = 4;

type
	
	libro = record
		cod:integer;
		titulo:integer;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato:libro;
		sig:lista;
	end;
	
	vector = array[1..dimf] of lista;
	
procedure leerRegistro(var l:libro);
	begin
		write('CODIGO LIBRO: ');l.cod:=Random(16);
		if(l.cod <> 0) then
			write('TITULO: ');l.titulo:=Random(50);
	end;
	
procedure agregarOrd (var l:lista; lib:libro);
	var
		ant,act,nuevo:lista;
	begin
		act:= l;
		ant:= l;
		new (nuevo); 
		nuevo^.dato:= lib; 
		nuevo^.sig:= nil;
		while (act <> nil) and (act^.dato.cod < nuevo^.dato.cod) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if (l = act) then
			l:= nuevo
		else
			ant^.sig:= nuevo;
		nuevo^.sig:= act;
	end;
	
procedure agregarAtras(var L:lista; var ult:lista; lib:libro); //SE ALMACENAN EN ORDEN
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dato:=lib;
		nuevo^.sig:=nil;
		
		if (L = nil) then begin
			L:=nuevo;
			ult:=nuevo;
			end
			else 
				ult^.sig:=nuevo;
			ult:=nuevo;
	end;

	
procedure cargarVector(var v:vector);
	var
		lib:libro;
		i:integer;
	begin
		for i:=1 to dimf do begin
			leerRegistro(lib);
			while(lib.cod<>0)do begin
				agregarOrd(v[i],lib);
				leerRegistro(lib);
			end;
		end;
	end;

procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do
			v[i]:= nil;
	end;

procedure recorrerLista (l:lista);
begin
	while (l <> nil) do begin
		writeln ('|CODIGO: ',l^.dato.cod,'|TITULO: ',l^.dato.titulo);
		l:= l^.sig;
	end;
end;


procedure imprimirVector(v:vector);
	var
		i:integer;
	begin
		for i:=1 to dimf do begin
			writeln('----------- LISTA N ',i,' --------------');
			recorrerLista(v[i]);
		end;
	end;
	
procedure buscarMin(var v:vector; var min:libro);
var
  i:integer;
  indiceMin:integer;
	begin
	    indiceMin:= -1;
		min.cod:= 20;
		for i:= 1 to dimf do begin
		  if(v[i]<> nil)then begin
		    if(v[i]^.dato.cod < min.cod)then begin
		      min:= v[i]^.dato;
		      indiceMin:= i;
		     end;
		   end;
		 end;
	     if(indiceMin <> -1)then 
	       v[indiceMin]:= v[indiceMin]^.sig;
	end;
	
procedure mergeDeLista(v:vector; var listaNueva:lista); //TODO POR REFERENCIAA
	var
		min:libro;
		ult:lista;
	begin 
		ult:=nil;
		buscarMin(v,min);
		while(min.cod <> 20)do begin
			agregarAtras(listaNueva,ult,min);
			buscarMin(v,min);
		end;
	end;
	
{programa principal}
var
	v:vector;
	l:lista;
begin
    l:= nil;
	inicializar(v);
	cargarVector(v);
	writeln;
	writeln('***************** DATOS DE LA LISTA *****************');
	imprimirVector(v);
	writeln('***************** DATOS DE LA LISTA NUEVA *****************');
	mergeDeLista(v,l);
	recorrerLista(l);
end.
