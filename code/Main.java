 
public class Main {
 
   public static void main(String[] args) throws Exception{
	Board botoes = new Board();
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
