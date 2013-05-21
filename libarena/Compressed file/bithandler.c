/* bithandler.c */

// #include "bithandler.h"
#include <stdio.h>


void set_bit(unsigned short* shorty, int pos)
{
	unsigned short naughty;

	//aktuelles short aus allocated_map wird durch neues bit ergaenzt (in place)
	//1 wird an richtige position geshiftet und mit bisherigem short verodert
	naughty = ( (*shorty) | (1 << pos)  );			
	
	// war das bit schon gesetzt? oh oh oh! besser eine warnung ausgeben!												
	if (*shorty == naughty)
	{
		fprintf(stderr, "Warning: Bit was already set!\n");
	}	


	*shorty = naughty;
}

void unset_bit(unsigned short* shorty, int pos)
{
	unsigned short naughty;

	//aktuelles short aus allocated_map wird durch neues bit ergaenzt
	//1 an richtige position, short invertiert, und mit bisherigem short verundet
	naughty = ( (*shorty) & ( ~(1 << pos))  );		
													
	if (*shorty == naughty)
	{
		fprintf(stderr, "Warning: Bit was already unset!\n");
	}

	*shorty = naughty;

}



unsigned char check_bit(unsigned short* shorty, int pos)
{
	//bitweiser Vergleich mit entsprechen (pos) linksgeshifteter (bit-1)
	// irgendwas ausser 0 (zB 64) ist im boolschen kontext wahr
	if (   (*shorty) & (1 <<(pos)) )		
	{
		return 1;							//Rueckgabe: Bit war 1
	}
	else 
	{
		return 0;							//Rueckgabe: Bit war 0
	}

}



void print_bitmap(unsigned short* handay)
{
	char i;

	for (i = 15; i >=0; --i)
	{
		printf("%d", check_bit(handay,i));
	}
	printf("\n");
}



