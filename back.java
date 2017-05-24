package mineSweeper_Project;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class back {
	
	static void afficheTabInt(int t[][]) {
		int i,j;
		for (i=1;i<=5;i++) {
			for (j=1;j<=5;j++){
				System.out.print(t[i][j] + " ");
				System.out.println();
			}
		}
		System.out.println();
	}
		
	static void afficheTabChar(char t[][]) {
		int i,j;
		for (i=1;i<=5;i++) {
			for (j=1;j<=5;j++){
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
		
	static int voisins(int tab[][],int l,int c) {
		int i, j, v;
		v=0;
		if (tab[l][c]==1){
			v=9;
		}
		else {
			for (i=l-1;i<=l+1;i++){
					for (j=c-1;j<=c+1;j++){
						if (tab[i][j]==1){
							v++;
						}
					}
			}
		}
		return v;
	}
		
	public static void main(String[] args) {
		int i;
		int j;
		int l;
		int c;
		int m = 0;
		int cd = 0; //variable of cases_deminees from the algorithm
		boolean perdu = false;
		int mines[][] = new int[7][7];
		char demine[][] = new char[7][7];
		for (i=0;i<=6;i++){
			for(j=0;j<=6;j++) {
				mines[i][j]=0;
				demine[i][j]='-';
			}
			
		}
		Random rd = new Random();
		do {
			i = rd.nextInt(5)+1;
			j = rd.nextInt(5)+1;
			if (mines[i][j]==0) {
					mines[i][j] = 1;
					m++;
			}
		}
		while (m<6);
		//print TabInt(mines);
		do {
			System.out.print("Saisir les coordonnées d'une case : ");
			Scanner sc = new Scanner(System.in);
			l = sc.nextInt();
			c = sc.nextInt();
			if (voisins(mines,l,c)==9){
					perdu=true;
			}
			else {
				demine[l][c] = (char) (48+voisins(mines,l,c));
				afficheTabChar(demine);
				cd++;
			}
		}
		while ((perdu==false) && (cd<19)); 
		if (perdu==true) {
				System.out.println("Case minée : PERDU !");
		}
		else {
				System.out.println("BRAVO : le plateau est déminé !");
		}
	}
	
}
