package gau.models;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.*;

public class PlugBoard {

   public interface EasyLab extends Library {
      public int SearchDevices (ByteByReference ndevs);
      public int SetPortDirections (byte dev, int ddr);
      public int SetOutputPorts (byte dev, long data_out);
      public int GetPortDirections (byte dev, IntByReference ddr_in);
      public int GetInPorts (byte dev, IntByReference data_in);
      public int GetOutPorts (byte dev, IntByReference data_out);
   }
   
   private EasyLab _board;
   private byte _dev;
   
   public PlugBoard () throws Exception {
      init(0);
      config();
   }

   public void init (int dev) throws Exception {
      _board = (EasyLab) Native.loadLibrary("Easy_lab", EasyLab.class);
      ByteByReference ndevs = new ByteByReference();      
      int tmp = _board.SearchDevices(ndevs);
      if (tmp != 0 || ndevs.getValue() == 0)
         throw new Exception ("Placa não encontrada"); 
      _dev = (byte) dev;
   }

   public void config () throws Exception {
      int tmp = _board.SetPortDirections(_dev,0); // all ports as inputs
      if (tmp != 0)
         throw new Exception ("Falha em configurar portas como entradas");
      tmp = _board.SetOutputPorts(_dev,511); // all ports in low activation
      if (tmp != 0)
         throw new Exception ("Falha em configurar portas para ativação em baixo");
   }

   public boolean[] read () throws Exception {
      IntByReference data_in = new IntByReference(); 
      int tmp = _board.GetInPorts(_dev,data_in);
      if (tmp != 0)
         throw new Exception ("Falha na leitura das portas");
      int data = data_in.getValue();
      boolean[] botoes = new boolean[9];
      int i = 0, aux = 1;
      while (i < 9) {
         if ((aux & data) == 0) botoes[i] = true;
         else botoes[i] = false;
         i++; aux = aux << 1;
      }
      return botoes;
   }

}
