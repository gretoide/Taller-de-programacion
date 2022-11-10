{Una perfumería tiene 4 sucursales. Cada sucursal dispone en papel de la información de sus ventas
(código de venta, código de producto, cantidad vendida). Implementar un programa que :
a. Genere el vector de 4 listas de ventas, ordenadas por código de producto (ascendente). Para ello,
para cada sucursal lea la información de las ventas, hasta ingresar código de venta 0.
b. Imprima en pantalla el contenido de cada lista del vector.
c. Genere una nueva lista con las ventas de las 4 sucursales, ordenadas por código de producto
(ascendente). Mostrar la lista resultante.
NOTA: Reusar y adaptar los módulos implementados anteriormente}

program ejercicio1;

const
	dimf = 4;

type
	
	venta = record
		cod:integer;
		codProducto:integer;
		cantVendido:integer
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato:venta;
		sig:lista;
	end;
	
	vector = array[1..dimf] of lista;
	
procedure leerRegistro(var v:venta);
	begin
		write('CODIGO VENTA: ');v.cod:=Random(16);
		if(v.cod <> 0) then
			write('CODIGO DE PRODUCTO: ');v.codProducto:=Random(5000);
			write('CANTIDAD DE VENDIDOS: ');v.cantVendido:=Random(10);
			
	end;
	
procedure agregarOrd (var l:lista; v:venta);
	var
		ant,act,nuevo:lista;
	begin
		act:= l;
		ant:= l;
		new (nuevo); 
		nuevo^.dato:= v; 
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
	
procedure agregarAtras(var L:lista; var ult:lista; v:venta); //SE ALMACENAN EN ORDEN
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dato:=v;
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
		ven:venta;
		i:integer;
	begin
		for i:=1 to dimf do begin
			leerRegistro(ven);
			while(ven.cod<>0)do begin
				agregarOrd(v[i],ven);
				leerRegistro(ven);
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
		writeln ('|CODIGO: ',l^.dato.cod,'|CODIDO PRODUCTO: ',l^.dato.codProducto,'|CANT VENTAS: ',l^.dato.cantVendido);
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
	
procedure buscarMin(var v:vector; var min:venta);
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
		min:venta;
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
	Randomize;
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
