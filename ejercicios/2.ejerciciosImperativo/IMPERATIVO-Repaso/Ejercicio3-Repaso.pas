program ejercicio3;

type
  venta = record
    codP:integer;
    tipoP:integer;
    {fecha:integer;}
    cantU:integer;
    monto:real;
  end;
  
  arbol = ^nodo;
  
  nodo = record
    dato:venta;
    hi:arbol;
    hd:arbol;
  end;
  
  lista = ^nodoL;
  
  nodoL = record
    dato:integer;
    sig:lista;
  end;
  
procedure leer(var v:venta);
  begin
    writeln('------------');
    write('Ingrese cantVentas');v.cantU := Random(40);
    if(v.cantU <> 0)then begin
      write('Ingrese tipoP');v.tipoP := Random(3000);
      write('Ingrese CodP');v.codP := Random(2201);
      write('Ingrese Monto');v.monto := Random(50001);
    end;
  end;
  
procedure crearArbol(var a:arbol; n:venta); {modulo b}
	begin
		if(a = nil)then begin
			new(a);
			a^.dato:=n;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if not(a^.dato.codP = n.codP)then begin {else para descartar repeticiones en al abb}
			if(a^.dato.codP > n.codP)then
				crearArbol(a^.hi,n)
			else
				crearArbol(a^.hd,n);
		end
		else begin
		  a^.dato.cantU:= a^.dato.cantU + n.cantU; {para q no repita codigo pero si aumente las unidades}
		  a^.dato.monto:= a^.dato.monto + n.monto;
		end;
	end;

procedure cargarArbol(var a:arbol); {crear arbol, modulo recursivo}
	var
		n:venta;
	begin
		leer(n);
		while(n.cantU <> 0) do begin
			crearArbol(a,n);
			leer(n);
		end;
	end;

procedure ImprimirArbol(a:arbol); {como imprimir un arbol}
	begin
		if(a <> nil)then begin
			ImprimirArbol(a^.hd);
			ImprimirArbol(a^.hi);
			writeln('CodP: ',a^.dato.codP,' | cantU: ', a^.dato.cantU, ' | Monto: ', a^.dato.monto:2:1, ' | tipoP: ', a^.dato.tipoP);
		end;
	end;

{modulos}
procedure calcularProductos(a:arbol);
  begin
    if(a <> nil)then begin
      if(a^.dato.tipoP < 1500)then
	calcularProductos(a^.hd);
      if (a^.dato.tipoP > 2200)then
	calcularProductos(a^.hi)
      else begin
	writeln('tipo: ', a^.dato.tipoP);
	calcularProductos(a^.hi);
	calcularProductos(a^.hd);
        end;
    end;
  end;
  
//busca cierto rango de montos en el arbol (ordenado por cod) e informa cant
procedure buscar2(a: arbol; inf, sup: real; var cant: integer);
begin
    if a <> nil then 
    begin
        if (a^.dato.monto > inf) and (a^.dato.monto < sup) then
            cant:= cant + 1;
        buscar2(a^.hi, inf, sup, cant);
        buscar2(a^.hd, inf, sup, cant);
    end;
end;
  
{-----programa principal-----}
var
  a:arbol;
  inf,sup,cant:integer;
begin
  inf:=10000;
  sup:=32000;
  cant:=0;
  cargarArbol(a);
  imprimirArbol(a);
  writeln('------LISTA TIPOP-----');
  calcularProductos(a);
  buscar2(a,inf,sup,cant);
  writeln('Cant: ', cant);
end.
