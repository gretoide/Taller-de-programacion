program juegosDeTelefono;

type
	lista = ^nodo;
	
		celular = record
		android:integer;
		pantalla:integer;
		ram:integer;
	end;
	
	nodo = record
		dato:celular;
		sig:lista;
	end;

{modulos}	
procedure leerRegistro(var c:celular);
	begin
		write('Ingrese pulgadas de pantalla: ');c.pantalla:=Random(16);
		writeln;
		if(c.pantalla<>0)then begin
			write('Ingrese version de Android: ');c.android:=Random(20);
			writeln;
			write('Ingrese RAM: ');c.ram:=Random(16);
		end;
	end;
	
procedure agregarOrd (var l:lista; c:celular); {agregar ordenado}
	var
		ant,act,nuevo:lista;
	begin
		new (nuevo); 
		nuevo^.dato:= c; 
		nuevo^.sig:= nil;
		act:= l;
		ant:= l;
		while (act <> nil) and (act^.dato.android < nuevo^.dato.android) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if (l = act) then
			l:= nuevo
		else
			ant^.sig:= nuevo;
		nuevo^.sig:= act;
	end;
	
procedure crearLista(var l:lista);
	var
		c:celular;
	begin
		leerRegistro(c);
		while(c.pantalla<>0)do begin {condicion de corte de la carga}
			agregarOrd(l,c);
			leerRegistro(c);
		end;
	end;

procedure imprimirLista(l:lista);
	begin
		while(l<>nil)do begin
			writeln('| Version de Android: ', l^.dato.android, '| Ram: ', l^.dato.ram, 'GB | Pantalla: ', l^.dato.pantalla);
			l:=l^.sig;
		end;
	end;
	
{modulos pedidos}

procedure recorrerLista(l:lista; var promedio:real; var disp:integer); {no me acuerdo si el enunciado pedia estos parametros}
	var
		cantDispo, tamPantallas, cantV, versionActual:integer;
	begin
		cantDispo:=0;tamPantallas:=0;cantv:=0;versionActual:=0;
		while(l<>nil)do begin
			versionActual:=l^.dato.android;
			while(l<>nil)and(l^.dato.android = versionActual)do begin {mientras sea la misma version, recorre y evalua todas las condiciones}
				cantV:=cantV+1;
				if(l^.dato.ram>3)and(l^.dato.pantalla >= 5)then
					disp:=disp+1;
				cantDispo:=cantDispo+1;
				tamPantallas:=tamPantallas+l^.dato.pantalla;
				l:=l^.sig;
				end;
			writeln('La cantidad de dispositivos para la version ',versionActual, ' es: ',cantV);
			cantV:=0;
		end;
		promedio:=tamPantallas/cantDispo;
	end;
{PROGRAMA PRINCIPAL}
VAR
	l:lista;
	promedio:real;
	disp:integer;
BEGIN
	Randomize;
	l:=nil;
	writeln('*** CARGA DE DATOS ***');
	crearLista(l);
	writeln;
	writeln('*** LISTA ORDENADA POR VERSION DE ANDROID ***');
	writeln;
	imprimirLista(l);
	writeln;
	writeln('--------------------------------------------------');
	{enunciados}
	disp:=0;
	recorrerLista(l,promedio,disp);
	writeln;
	writeln('Dispositivos RAM > 3 y pantalla >= 5": ', disp);
	writeln;
	writeln('Promedio de pantallas: ', promedio:2:1);
END.
