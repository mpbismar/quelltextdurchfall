
OBJ=arena.o allocate.o bithandler.o
LIBARENA=.


libarena.a: $(OBJ)
	ar rcs $@ $(OBJ)

testapp: libarena.a
	$(CC) testapp.c $(LIBARENA)/libarena.a -o testapp.o

all: libarena.a testapp

arena.o: arena.h 
allocate.o: allocate.h
bithandler.o: bithandler.h
testapp.o: testapp.c

clean:
	rm -f arena.o allocate.o libarena.a bithandler.o testapp.o
