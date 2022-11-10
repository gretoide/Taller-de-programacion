{
ACTIVIDAD 7
En el programa Recursion.pas
a) Implementar el procedimiento recursivo ImprimirDigitos1 que imprime los
dígitos de un número dado, empezando por la unidad.
b) Implementar el procedimiento recursivo ImprimirDigitos2 que imprime los
dígitos de un número dado, finalizando con la unidad.}

program actividad7;

procedure digitoMaximoRec(n:integer; var max:integer); {proceso que imprime el dígito maximo}
	var
		dig: integer;
	begin
		if (n <> 0) then begin
			dig:= n mod 10;
		if (dig > max) then
			max:= dig;
		n:= n div 10;
		writeln ('max: ', max);
		digitoMaximoRec(n, max);
	end;
end;


procedure imprimirDigitos1(n:integer);
	var
		dig:integer;
	begin
		if(n <> 0)then begin
			dig:= n mod 10;
			writeln('DIGITO: ', dig);
			n:= n div 10;
			imprimirDigitos1(n);
		end;
	end;
	
procedure imprimirDigitos2(n:integer);
	var
		dig:integer;
	begin
		if(n <> 0)then begin
			dig:= n mod 10;
			n:= n div 10;
			imprimirDigitos2(n);
			writeln('DIGITO: ', dig); {imprime los valores que quedaron en espera}
		end;
	end;
	
	
{programa principal}
VAR
	n,max:integer;
BEGIN
	max:=-1;
	write('INGRESE UN NRO: ');readln(n);
	digitoMaximoRec(n,max);
	writeln('---------- MAYOR DIGITO DE ',n,' ----------');
	writeln(max);
	
	writeln('---------- DIGITOS DESDE LA UNIDAD DEL NUM ',n,' ----------');
	imprimirDigitos1(n);
	writeln('---------- DIGITOS DESDE EL + SIGNIFICATIVO DEL NUM ',n,' ----------');
	imprimirDigitos2(n);
END.
