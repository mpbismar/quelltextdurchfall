/* bithandler.c */

// #include "bithandler.h"



void set_bit(unsigned short* shorty, int pos)
{



}

void unset_bit(unsigned short* shorty, int pos)
{



}



unsigned char check_bit(unsigned short* shorty, int pos)
{
	if (   (*shorty) & (1 <<(pos))      )	//bitweiser Vergleich mit entsprechen (pos) linksgeshifteter (bit-1)
	{
		return 1;							//Rueckgabe: Bit war 1
	}
	else 
	{
		return 0;							//trivial
	}

}



// #define CHECK_BIT(var,pos) ((var) & (1<<(pos)))