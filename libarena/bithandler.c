/* bithandler.c */

// #include "bithandler.h"
#include <stdio.h>


void set_bit(unsigned short* shorty, int pos)
{
	unsigned short naughty;
	naughty = ( (*shorty) | (1 << pos)  );			//aktuelles short aus allocated_map wird durch neues bit ergaenzt
	*shorty = naughty;
}

void unset_bit(unsigned short* shorty, int pos)
{


}



unsigned char check_bit(unsigned short* shorty, int pos)
{
	if (   (*shorty) & (1 <<(pos)) )		//bitweiser Vergleich mit entsprechen (pos) linksgeshifteter (bit-1)
	{
		return 1;							//Rueckgabe: Bit war 1
	}
	else 
	{
		return 0;							//Rueckgabe: Bit war 1
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



// #define CHECK_BIT(var,pos) ((var) & (1<<(pos)))