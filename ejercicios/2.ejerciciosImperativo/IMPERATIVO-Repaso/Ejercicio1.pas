program ejercicio1;

const
	dimf = 7;
type
	cantDia = 1..7;
	
	entrada = record
	  dia:cantDia;
	  codObra:integer;
	  asiento:integer;
	  monto:real;
	end;
	
	entrada2 = record
		codObra:integer;
		cant:integer;
	end;
	
	lista = ^nodo;
	
	nodo = record
	  dato:entrada;
	  sig:lista;
	end;
	
	lista2 = ^nodo2;
	
	nodo2 = record
		dato:entrada2;
		sig:lista2;
	end;
		
	
	vector = array[cantDia] of lista;

procedure leer(var r:entrada);
begin
	write('Ingrese codObra: ');r.codObra := Random(20);
	writeln;
	if(r.codObra <> 0)then begin
		write('Ingrese dia: ');r.dia := Random(20);
		writeln;
		write('Ingrese N asieto: ');r.asiento := Random(20);
		writeln;
	end;
end;

procedure inicializar (var v:vector);
var
i:integer;
begin
	for i:= 1 to dimf do
		v[i]:= nil;
end;

procedure agregarOrd (var l:lista; p:entrada);
	var
		ant,act,nuevo:lista;
	begin
		act:= l;
		ant:= l;
		new (nuevo); 
		nuevo^.dato:= p; 
		nuevo^.sig:= nil;
		while (act <> nil) and (act^.dato.codObra < nuevo^.dato.codObra) do begin
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
	p:entrada;
begin
	leer (p);
	while (p.codObra <> 0) do begin
		agregarOrd(v[p.dia],p);
		leer (p);
	end;
end;
	
procedure recorrerLista (l:lista);
begin
	while (l <> nil) do begin
		writeln('|Dia: ',l^.dato.dia,'|CodObra: ',l^.dato.codObra);
		l:= l^.sig;
	end;
end;

procedure recorrerIMP(v:vector);
var
i:integer;
begin
	for i:= 1 to DIMF do
		recorrerLista (v[i]);
end;

{MERGE ACUMULADOR}
procedure minimo(var todos:vector; var min:integer);
var
minIndice:integer;
i:integer;
begin
	min:= 32000;
	minIndice:= -1;
	for i:= 1 to dimf do 
		if (todos[i] <> nil) and (todos[i]^.dato.codObra <= min) then begin
			minIndice:= i;
			min:= todos[i]^.dato.codObra;
		end;
	if (minIndice <> -1) then begin
		todos[minIndice]:= todos[minIndice]^.sig;
	end;
	
end;

procedure agregarAtras (var l,ult:lista2; cod:integer; cant:integer);
var
nuevo:lista2;
begin
	new (nuevo); 
	nuevo^.dato.codObra:= cod;
	nuevo^.dato.cant:= cant; 
	nuevo^.sig:= nil;
	if (l = nil) then
		l:= nuevo
	else
		ult^.sig:= nuevo;
	ult:= nuevo;
end;

procedure mergeTotal (todos:vector; var eNuevo:lista2);
var
cantTotal,min,codActual:integer;
ult:lista2;
begin
	eNuevo:= nil;
	minimo (todos,min);
	while (min <> 32000) do begin
		codActual:= min;
		cantTotal:= 0;
		while ((min <> 32000) and (min = codActual)) do begin
			cantTotal:= cantTotal + 1;
			minimo (todos,min);
		end;
		agregarAtras(eNuevo,ult,codActual,cantTotal);
	end;
end;

{MODULO QUE IMPRIME RECURSIVAMENTE}
procedure imprimirRecursivo(l:lista2);
	begin
		if(l <> nil)then begin
			writeln('COD Obra: ' , l^.dato.codObra , '| Cant compradas: ' , l^.dato.cant);
			imprimirRecursivo(l^.sig);
		end;
	end;

{-----------PROGRAMA PRINCIPAL------------}
VAR
v:vector;
l2:lista2;
BEGIN
	l2:=nil;
	inicializar(v);
	cargarVector(v);
	writeln('-----------------------------------------');
	recorrerIMP(v);
	writeln('------ LUEGO DEL MERGE ACUMULADOR ------');
	mergeTotal(v,l2);
	imprimirRecursivo(l2);
END.
