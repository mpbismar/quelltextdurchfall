# include "allocate.h"
# include <stdio.h>

# define check( VAR ) \
do { if (! VAR ) fprintf(stderr, "Problem: " #VAR " is NULL\n" ); } while (0)

int main() {
	void *f, *g, *h;

	unsigned short testomat = 126;
	printf("Bit ist: %d\n", check_bit((&testomat), 0));
	printf("Bit ist: %d\n", check_bit((&testomat), 6));
	print_bitmap(&testomat);
	set_bit(&testomat,15);
	print_bitmap(&testomat);
	unset_bit(&testomat,0);
	print_bitmap(&testomat);



	
	// f = allocate(); check( f );
	// g = allocate(); check( g );
	// deallocate(g);
	// h = allocate(); check( h );
	// deallocate(f);
	// deallocate(h);
}
