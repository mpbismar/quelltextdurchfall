# include "allocate.h"
# include <stdio.h>

# define check( VAR ) \
do { if (! VAR ) fprintf(stderr, "Problem: " #VAR " is NULL\n" ); } while (0)

int main() {
	void *f, *g, *h;

	unsigned short testomat = 126;
	// printf("Bit ist: %d\n", check_bit((&testomat), 0));
	// printf("Bit ist: %d\n", check_bit((&testomat), 6));

	// print_all_map();

	
	f = allocate(); check( f );

	// print_all_map();

	// printf("arena= %d\n", (short)arena[0]);
	// printf("f= %d\n", (int)f);


	g = allocate(); check( g );
	// printf("g= %d\n", (int)g);
	h = allocate(); check( h );
	deallocate(g);
	deallocate(h);
	deallocate(f);

	int excision = 0;
	for (excision =0; excision <= 1025; excision++)
	{
		allocate();
	}
}
