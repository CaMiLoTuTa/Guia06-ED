package TorresDeHanoi.Code;

import java.util.Stack;

/**
 *
 * @author tutaa
 */

public class TorresHanoi {
    public static Stack<Disco> A = new Stack<Disco>();
    public static Stack<Disco> B = new Stack<Disco>();
    public static Stack<Disco> C = new Stack<Disco>();

    public TorresHanoi(int nDiscos) {
        for (int i = nDiscos; i >= 1; i--) {
            var tam = i;
            var forma = "#".repeat(i);
            Disco nuevoDisco = new Disco(tam, forma);

            A.push(nuevoDisco);
        }
    }
}
