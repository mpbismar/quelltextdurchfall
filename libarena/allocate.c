/* allocate.c */
#include "allocate.h"
#include "arena.h"
#include "bithandler.h"
#include <stdio.h>


void* allocate() 
{ 

	unsigned short shortfull = 65535; // (2^16)

	// ersten nicht vollen short finden
	int i;
	int current_short = -1;
	int current_bit;
	
	for (i=0; i < (NUM_BLOCKS/16); i++)
	{
		if (allocated_map[i] < shortfull)
		{
			current_short = i;
			break; // for schleife verlassen
		}

	}

	// kein freies short gefunden --> Nullpointer returnen
	if (current_short == -1)
	{
		fprintf(stderr, "Warning: Arena full!\n");
		return (void*) 0; 
	}

	// sonst weiter mit freiem short!
	// freies bit finden & 1 setzen
	for (i=0; i<16; i++)
	{
		if(!check_bit(&allocated_map[current_short],i)) // erste 0 finden
		{
			current_bit = i;
			set_bit(&allocated_map[current_short],current_bit);
			break;
		}
	}

	// entsprechenden pointer in arena finden
	int offset = 16*current_short + current_bit;

	// pointer returnen
	printf("[info] allocated block: %d/%d [%ld]\n", current_short, current_bit, (long)(&arena[offset*BLOCKSIZE]));
	return &arena[offset*BLOCKSIZE];

}




void deallocate(void *data) 
{

	int offset, current_bit, current_short;

	// aus pointer offset berechnen
	offset = (((long)data - (long)(&arena[0]))/BLOCKSIZE);
	// printf("[debug] offset: %d - %d / size =  %d\n", (int)data, (int)(&arena[0]), offset);

	// short und bit bestimmen


	current_bit = offset % 16;
	current_short = (offset - current_bit) / 16;

	// bit unsetten
	unset_bit(&allocated_map[current_short], current_bit);
	printf("[info] deallocated block: %d/%d [%ld]\n", current_short, current_bit, (long)(&arena[offset*BLOCKSIZE]));
}


void print_all_map()
{
	int i;
	printf("========== MAP ==========\n");
	for (i=0; i<(NUM_BLOCKS/16); i++)
	{
		print_bitmap(&allocated_map[i]);
	}
	printf("======== / MAP ==========\n\n");
}
