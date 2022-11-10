program ejercicio2;

const
  dimf = 4;
type
  familia = record
    tipoGasto:integer;
    monto:real;
    integrante:integer;
  end;
  
  lista = ^nodo;
  
  nodo = record
    dato:familia;
    sig:lista;
  end;
  
  familia2 = record
    tipoGasto2:integer;
    montoTotal:real;
  end;

  vector = array[1..dimf] of lista;
  
  arbol = ^nodoA;
  
  nodoA = record
    dato:familia2;
    hi:arbol;
    hd:arbol;
  end;
  
procedure leer(var f:familia);
begin
  write('Ingrese tipo de gasto: ');f.tipoGasto:= Random(20);
  if(f.tipoGasto <> 0)then
    write('Ingrese monto:');f.monto:= Random(15000);
    write('Ingrese integrante');f.integrante:= Random(4);
end;

{------------modulos-------------}
procedure inicializar (var v:vector);
var
i:integer;
begin
	for i:= 1 to DIMF do
		v[i]:= nil;
end;

procedure agregarOrd (var l:lista; p:familia);
	var
		ant,act,nuevo:lista;
	begin
		act:= l;
		ant:= l;
		new (nuevo); 
		nuevo^.dato:= p; 
		nuevo^.sig:= nil;
		while (act <> nil) and (act^.dato.tipoGasto < nuevo^.dato.tipoGasto) do begin
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
p:familia;
begin
	leer (p);
	while (p.tipoGasto <> 0) do begin
		agregarOrd(v[p.integrante],p);
		leer (p);
	end;
end;

//RECORRER VECTOR DE LISTAS

procedure recorrerLista (l:lista);
begin
	while (l <> nil) do begin
		writeln ('|Integrante: ',l^.dato.integrante, '|Tipo de gasto: ',l^.dato.tipoGasto,'|Monto: ',l^.dato.monto);
		l:= l^.sig;
	end;
end;

procedure recorrerIMP (v:vector);
var
i:integer;
begin
	for i:= 1 to DIMF do
		recorrerLista (v[i]);
end;
{--------arbol--------}

procedure crearNodo(var a:arbol; tipoGasto:integer; montoTotal:real); {creacion nodo arbol}
	begin
		if (a = nil) then begin
			new(a);
			a^.dato.tipoGasto2:=tipoGasto;
			a^.dato.montoTotal:=montoTotal;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else
			if(montoTotal < a^.dato.montoTotal) then
				crearNodo(a^.hi,tipoGasto,montoTotal)
			else
				crearNodo(a^.hd,tipoGasto,montoTotal);
	end;
	
procedure ImprimirArbol(a:arbol); {como imprimir un arbol}
	begin
		if(a <> nil)then begin
			ImprimirArbol(a^.hd);
			ImprimirArbol(a^.hi);
			writeln('Tipo de gasto: ',a^.dato.tipoGasto2);
			writeln('Monto total: ',a^.dato.montoTotal);
			writeln('----------------');
		end;
	end;
	
{------------merge acumulador--------------}

procedure minimo(var todos:vector; var min:integer; var cant:integer);
var
minIndice:integer;
i:integer;
begin
	min:= 32000;
	minIndice:= -1;
	for i:= 1 to dimf do 
		if (todos[i] <> nil) and (todos[i]^.dato.tipoGasto <= min) then begin
			minIndice:= i;
			min:= todos[i]^.dato.tipoGasto;
		end;
	if (minIndice <> -1) then begin
		todos[minIndice]:= todos[minIndice]^.sig;
	end;
	
end;

{MERGE COMUN?}
procedure mergeTotal (todos:vector; var eNuevo:arbol);
var
cant,min,codActual:integer;
cantTotal:real;
begin
	eNuevo:= nil;
	minimo(todos,min,cant);
	while (min <> 32000) do begin
		codActual:= min;
		cantTotal:= 0;
		while ((min <> 32000) and (min = codActual)) do begin
			cantTotal:= cantTotal + cant;
			minimo (todos,min,cant);
		end;
		crearNodo(eNuevo,codActual,cantTotal);
	end;
end;


{------------programa principal------------}
var
  v:vector;
  a:arbol;
begin
  a:=nil;
  inicializar(v);
  cargarVector(v);
  recorrerIMP(v);
  {-------------}
  writeln('------------ ABB -------------');
  mergeTotal(v,a);
  ImprimirArbol(a);
end.
