package gau.tests;

import gau.models.*;
 
public class PlugBoardT {
 
   public static void main(String[] args) throws Exception{
	   PlugBoard botoes = new PlugBoard();
	   boolean[] status;
	   while (true) {
		   status = botoes.read();
		   int i = 0;
		   while (i < status.length) {
			   if (status[i]) System.out.println(i);
			   i++;
		   }
	   }
   }

}
