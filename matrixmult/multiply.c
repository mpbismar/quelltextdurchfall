#include <stdio.h>
#include <stdlib.h>

#include <time.h>

/* Dimension of the matrices */
#ifndef N
#define N 10
#endif

/* global matrices */
double A[N][N];
double B[N][N];
double C[N][N];

/* print a matrix to stdout */
void print(double m[N][N])
{
  int i,k;
  for (i=0; i<N; i++) {
    for (k=0; k<N; k++) {
      printf("%6.1f ", m[i][k]);
    }
    printf("\n");
  }
}

/* initialize matrices according to different algorithms:
   1: m[i][j] = i+j
   2: m[i][j] = i-j
   3: m[i][j] = random value between -10 and 10
*/
void init(double m[N][N], int kind)
{
  int i,k;
  for (i=0; i<N; i++) {
    for (k=0; k<N; k++) {
      switch(kind) {
      case 1: 
	m[i][k] = i+k;
	break;
      case 2: 
	m[i][k] = i-k;
	break;
      case 3: 
	/* rand returns an integer between 0 and RAND_MAX */
	m[i][k] = rand()*20.0/RAND_MAX - 10.0;
	break;
      }
    }
  }
}

/* multiply C = A*B */
void mult(double C[N][N], double A[N][N], double B[N][N])
{
  int i,k,m;
  for (i=0; i<N; i++) {
//    printf("start %d/%d\n", i, N);
    for (k=0; k<N; k++) {
      C[i][k] = 0.0;
      for (m=0; m<N; m++)
      	C[i][k] += A[i][m]*B[m][k];
    }
  }
}

int main()
{
  init(A, 1);
  init(B, 2);

// Clock Variablen
  clock_t c1;
  clock_t c2;

// Rechenzeit vor Mult
 c1 = clock();
  mult(C, A, B);

// Rechenzeit nach Mult (inkl. Overhead durch Aufruf)
 c2 = clock();

// Umrechnung in Sekunden:
 double multtime;
 multtime = (double)(c2-c1)/(double)CLOCKS_PER_SEC;

printf("Mult mit Matrix Groesse %d: %f\n", N, multtime);

// Ausgabe auskommentiert
 printf("========== A ============\n");
 print(A);
 printf("========== B ============\n");
 print(B);
 printf("========== C ============\n");
 print(C);
}
