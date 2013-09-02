/* SRM 534 - Div II level 2 problem */

import java.io.*;

public class EllysCheckers
{
	public static String getWinner(String board)
	{
		int parity = 0;
		for (int i = 0; i < board.length(); i++)
			if (board.charAt(i) == 'o') parity += (board.length() - i - 1);
                return (parity % 2 == 0) ? "NO" : "YES";
	}

  public static void main(String[] args){
    System.out.println(getWinner(args[0]));
  }
}
