package gau.models;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.*;

/**
 * @author mateusgm
 *
 */
public class PlugBoard {

   /**
    * @author mateusgm
    *
    */
   private interface EasyLab extends Library {

      /**
       * @param ndevs
       * @return
       */
      int SearchDevices(ByteByReference ndevs);

      /**
       * @param dev
       * @param ddr
       * @return
       */
      int SetPortDirections(byte dev, int ddr);

      /**
       * @param dev
       * @param data_out
       * @return
       */
      int SetOutputPorts(byte dev, long data_out);

      /**
       * @param dev
       * @param ddr_in
       * @return
       */
      int GetPortDirections(byte dev, IntByReference ddr_in);

      /**
       * @param dev
       * @param data_in
       * @return
       */
      int GetInPorts(byte dev, IntByReference data_in);

      /**
       * @param dev
       * @param data_out
       * @return
       */
      int GetOutPorts(byte dev, IntByReference data_out);
   }

   /**
    * EasyLab board.
    */
   private EasyLab board;

   /**
    * Device number.
    */
   private byte dev;

   /**
    * @throws Exception - exception
    */
   public PlugBoard() throws Exception {
      init(0);
      config();
   }

   /**
    * @param devp
    * @throws Exception
    */
   public final void init(final int devp) throws Exception {
      board = (EasyLab) Native.loadLibrary("Easy_lab", EasyLab.class);
      ByteByReference ndevs = new ByteByReference();
      int tmp = board.SearchDevices(ndevs);
      if (tmp != 0 || ndevs.getValue() == 0) {
         throw new Exception("Placa nao encontrada");
      }
      dev = (byte) devp;
   }

   /**
    * @throws Exception
    */
   public final void config() throws Exception {
      int tmp = board.SetPortDirections(dev, 0); // all ports as inputs
      if (tmp != 0) {
         throw new Exception("Falha em configurar portas como entradas");
      }
      tmp = board.SetOutputPorts(dev, 511); // all ports in low activation
      if (tmp != 0) {
         throw new Exception(
               "Falha em configurar portas para ativacao em baixo");
      }
   }

   /**
    * @return
    * @throws Exception
    */
   public final boolean[] read() throws Exception {
      IntByReference dataIn = new IntByReference();
      int tmp = board.GetInPorts(dev, dataIn);
      if (tmp != 0) {
         throw new Exception("Falha na leitura das portas");
      }
      int data = dataIn.getValue();
      boolean[] botoes = new boolean[9];
      int i = 0, aux = 1;
      while (i < 9) {
         if ((aux & data) == 0) {
            botoes[i] = true;
         } else {
            botoes[i] = false;
         }
         i++; aux = aux << 1;
      }
      return botoes;
   }

}
