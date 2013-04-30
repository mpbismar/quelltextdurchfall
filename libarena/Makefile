
OBJ=arena.o allocate.o bithandler.o

libarena.a: $(OBJ)
	ar rcs $@ $(OBJ)

testapp: $OBJ
	$CC -o testapp.o testapp.c

arena.o:	arena.h 
allocate.o:	allocate.h
bithandler.o: bithandler.h

clean:
	rm -f arena.o allocate.o libarena.a bithandler.o testapp.o

