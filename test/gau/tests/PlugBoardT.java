package gau.tests;

import gau.models.PlugBoard;

public final class PlugBoardT {

   private PlugBoardT() {
   }

   public static void main(final String[] args) throws Exception {
      PlugBoard botoes = new PlugBoard();
      boolean[] status;
      while (true) {
         status = botoes.read();
         int i = 0;
         while (i < status.length) {
            if (status[i]) {
               System.out.println(i);
            }
            i++;
         }
      }
   }

}
