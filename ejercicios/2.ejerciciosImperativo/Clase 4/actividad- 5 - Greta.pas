{Actividades en Máquina
ACTIVIDAD 5
Implementar un programa que procese la información de los participantes de un
concurso. De cada participante se lee: código de participante, código de ciudad de
origen y edad. La lectura finaliza con el código de ciudad -1.
Implementar un programa que:
a) Genere una estructura a partir de la información leída. La estructura debe ser
eficiente para la búsqueda por código de participante.
A partir de la estructura generada:
a) Genere una lista con los participantes de la ciudad cuyo código se recibe. Luego,
muestre el contenido de la lista.
b) Calcule e informe la edad promedio de los participantes del concurso.
c) Calcule e informe el participante de menor edad.
d) Dado un código, informe si el mismo corresponde al de un participante inscripto.
e) Calcule e informe la cantidad de participantes cuyos códigos están comprendidos
entre dos valores determinados que se reciben.}


program actividad5;

type
  arbol = ^nodo;
  nodo = record
    dato: participante;
    HI: arbol;
    HD: arbol;
  end;
  
  participante = record
    codParticipante:integer;
    codCurso:integer;
    codCiudad:integer;
    origen:integer;
    edad:integer;
  end;
  
procedure leerDatos(var p:participante);
	begin
		write('CODIGO DE CIUDAD: ')p.codCiudad:=Random(15);
		if(p.codCiudad <> 0)then begin
			write('CODIGO PARTICIPANTE: ')p.codParticipante:=Random(15);
			write('EDAD: ')p.edad:=Random(15);
		end;
	end;
  
procedure crearArbol(var a:arbol; p:participante); {modulo b}
	begin
		if(a = nil)then begin
			new(a);
			a^.dato:=n;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		if(a^.dato.codigoP > p.codigoP)then
			crearArbol(a^.hi,p)
		else
			crearArbol(a^.hd,p);
	end;	
	
procedure cargarDatos(var a:arbol);
	var
		p:participante;
	begin
		a:=nil;
		leerDatos(p);
		while(p.ciudad <> 0)do begin
			crearArbol(a,p);
			leerDatos(p);
		end;
	end;
	
