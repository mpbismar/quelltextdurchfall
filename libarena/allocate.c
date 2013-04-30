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
	int current_short;
	int current_bit;
	
	for (i=0; i < (NUM_BLOCKS/16); i++)
	{
		if (allocated_map[i] < shortfull)
		{
			current_short = i;
			break; // for schleife verlassen
		}

	}


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
	return &arena[offset*BLOCKSIZE];


	// wenn alles voll: nullpointer zurueckgeben
	// return (void*) 0; 
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



void deallocate(void *data) 
{





}
