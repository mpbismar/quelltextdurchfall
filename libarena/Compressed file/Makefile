
OBJ=arena.o allocate.o bithandler.o testapp.c
# LIBARENA=.


# libarena.a: $(OBJ)
# 	ar rcs $@ $(OBJ)

testapp: $(OBJ)

all: testapp.o

arena.o: arena.h 
allocate.o: allocate.h
bithandler.o: bithandler.h
testapp.o: testapp.c

clean:
	rm -f arena.o allocate.o libarena.a bithandler.o testapp.o