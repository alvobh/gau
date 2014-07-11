
#include <stdio.h>
#include <conio.h>
#include <dos.h>

#define BIT0 0x01
#define BIT1 0x02
#define BIT2 0x04
#define BIT3 0x08
#define BIT4 0x10
#define BIT5 0x20
#define BIT6 0x40
#define BIT7 0x80
#define LPT1 0x378
#define LPT2 0x379
#define REGCONTROLE LPT1+2

int main(void){

	unsigned char Byte, Byte1;
	int vet[10], ordem[10], i=0, c, l=0;

	for (c=0; c<10; c++){
		vet[c]=0;
		ordem[c]=0;
	}

	outportb(LPT1,0);
	outportb(REGCONTROLE,BIT5);
	clrscr();

	while ( !kbhit() ){

		for (c=0; c<10; c++){
			printf("%d ",ordem[c]);
		}

		i++;

		Byte = inportb(LPT1);
		printf("          %u  ", Byte);

	        Byte1 = inportb(LPT2);
		printf("%u       \n", Byte1);

		if (((Byte1 & BIT3) != 0) & (vet[0] == 0)){
			vet[0] = i;
			ordem[l] = 1;
		        l++;
		}

		if (((Byte1 & BIT4) != 0) & (vet[1] == 0)){
			vet[1] = i;
			ordem[l]=2;
			l++;
		}

		if (((Byte1 & BIT5) != 0) & (vet[2] == 0)){
			vet[2]=i;
			ordem[l]=3;
			l++;
		}

		if (((Byte1 & BIT6) != 0) & (vet[3] == 0)){
			vet[3]=i;
			ordem[l]=4;
			l++;
		}

		if (((Byte & BIT0) != 0) & (vet[4] == 0)){
		        vet[4]=i;
		        ordem[l]=5;
			l++;
		}
		
		if (((Byte & BIT1) != 0) & (vet[5] == 0)){
		        vet[5]=i;
		        ordem[l]=6;
			l++;
		}

		if (((Byte & BIT2) != 0) & (vet[6] == 0)){
		        vet[6]=i;
		        ordem[l]=7;
			l++;
		}

		if (((Byte & BIT3) != 0) & (vet[7] == 0)){
		        vet[7]=i;
		        ordem[l]=8;
			l++;
		}
	
		if (((Byte & BIT4) != 0) & (vet[8] == 0)){
		        vet[8]=i;
		        ordem[l]=9;
			l++;
		}
		
		if (((Byte & BIT5) != 0) & (vet[9] == 0)){
		        vet[9]=i;
		        ordem[l]=10;
			l++;
		}

	}

	for (c=0; c<10; c++){
		printf("%d ",vet[c]);
	}

	printf("\n");
	for (c=0; c<10; c++){
		if (ordem[c]==1){
			printf("SURUCUCU \n");
        	}
		if (ordem[c]==2){
			printf("GAMBALHOTA \n");
        	}
		if (ordem[c]==3){
			printf("MONSTRO VERDE \n");
       		}
		if (ordem[c]==4){
			printf("CAIXA PRETA \n");
		}

		if (ordem[c]==5){
			printf("05 \n");
        	}
		if (ordem[c]==6){
			printf("PIG MEU \n");
        	}
		if (ordem[c]==7){
			printf("APERTA UZ E \n");
		}
		if (ordem[c]==8){
			printf("08 \n");
       		}
		if (ordem[c]==9){
			printf("09 \n");
        	}
		if (ordem[c]==10){
			printf("CORRI DA MALUCA \n");
        	}
	}
	
	for (c=0; c<10; c++){
		printf("%d ",ordem[c]);
	}
	getch();
	system("pause");
}
