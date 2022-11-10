program programaVector;
const
	dimf= 10; {constante}
type
	vector = array [ 1..dimf] of integer; {unvector de enteros de 1..10}
	
procedure crearVector (var v:vector; var dimL:integer); {el vector y su dimensión lógica}
	var
		num:integer;
	begin
		num:=Random(16);
		while(diml<dimf)and(num<>0) do begin
			v[diml]:=num;
			diml:=diml+1;
			num:=Random(16);	
		end;
	end;

procedure imprimirVector(v:vector; diml:integer);
	var
		i:integer;
	begin
		for i:=1 to diml do begin
			write(v[i], '', '|', '');
		end;
	end;
	
{PROGRAMA PRINCIPAL}
VAR
	v:vector;
	diml:integer;
BEGIN
	diml:=0;
	crearVector(v,diml);
	writeln('Nros almacenados:');
	writeln;
	writeln('-------------------------');
	imprimirVector(v,diml);
	writeln;
	writeln('-------------------------');
END.
