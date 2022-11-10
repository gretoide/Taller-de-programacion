{ACTIVIDAD 1
Descargar de Ideas ProgramaArbol.pas y realizar las siguientes tareas:
a) Analizar las declaraciones de tipos y módulos.
b) Copiar el módulo Insertar y modificarlo para que no almacene valores
repetidos.
c) Implementar el módulo CrearABB que lea valores enteros que se ingresan por
teclado (finaliza con 0) y los inserte en un árbol binario de búsqueda.
d) En el programa principal, invocar al módulo CrearABB para generar un árbol y
al módulo ImprimirPorNivel con el árbol resultante.
e) Ejecutar el programa con los valores:
f) Comprobar que los datos que muestra el programa se corresponden con la
estructura esperada.}
program actividad1;

type
	
	arbol = ^nodo;
	
	nodo = record
		dato:integer;
		hi:arbol;
		hd:arbol;
	end;
	
	// Lista de Arboles PARA IMPRIMIRPORNIVEL
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
	
	
{-------------------MODULOS PARA IMPRIMIRPORNIVEL------------------------------}

// CONTARELEMENTOS - Devuelve la cantidad de elementos de una lista l

function ContarElementos (l: listaNivel): integer;
  var c: integer;
begin
 c:= 0;
 While (l <> nil) do begin
   c:= c+1;
   l:= l^.sig;
 End;
 contarElementos := c;
end;

//  AGREGARATRAS - Agrega un elemento atr�s en l

Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
 var nue:listaNivel;

 begin
 new (nue);
 nue^.info := a;
 nue^.sig := nil;
 if l= nil then l:= nue
           else ult^.sig:= nue;
 ult:= nue;
 end;


// IMPRIMIRPORNIVEL - Muestra los datos del �rbol a por niveles

Procedure imprimirPorNivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= 0;
                 agregarAtras (l,ult,a);
                 while (l<> nil) do begin
                    nivel := nivel + 1;
                    cant:= contarElementos(l);
                    write ('Nivel ', nivel, ': ');
                    for i:= 1 to cant do begin
                      write (l^.info^.dato, ' - ');
                      if (l^.info^.HI <> nil) then agregarAtras (l,ult,l^.info^.HI);
                      if (l^.info^.HD <> nil) then agregarAtras (l,ult,l^.info^.HD);
                      aux:= l;
                      l:= l^.sig;
                      dispose (aux);
                     end;
                     writeln;
                 end;
               end;
end;
{-------------------FIN MODULOS PARA IMPRIMIRPORNIVEL-------------------------}
	
{PROGRAMA PRINCIPAL}
VAR
	a:arbol;
BEGIN
	cargarDatos(a);
	imprimirPorNivel(a);
END.
