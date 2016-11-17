
package marsrover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 *
 * @author lucas
 */
public class MarsRover {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException {
        
        boolean test = true;//Testa se o movimento é válido
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;//Receberá a string de entrada
        String x;//Posição X onde o rover irá iniciar
        String y;//Posição Y onde o rover irá iniciar
        String orientacao;//Orientação inicial do rover
        String mat = br.readLine();//Variável com o valor dos limites da matriz
        String[] linhaDoArquivo = mat.split(" ");
        //Posição Superior Direita do tablo
        String xMax = linhaDoArquivo[0];
        String yMax = linhaDoArquivo[1];
        //Criação do rover inicial sem posição
        Rover r = new Rover(0, 0, 'N', parseInt(xMax), parseInt(yMax));
        int tamanho = 0;//Variável que controlará se a entrada é um rover ou um comando para o rover
        //Aqui iniciamos o loop de entradas para o teste dos rovers
        while ((linha = br.readLine()) != null) {
            test = true;
            //Se a variável tamanho for par a entrada será um rover, caso não seja a entrada será um comando
            if (tamanho % 2 == 0) {
                String[] arq = linha.split(" ");
                x = arq[0];
                y = arq[1];
                orientacao = arq[2];
                Rover r1 = new Rover(parseInt(x), parseInt(y), orientacao.charAt(0), parseInt(xMax), parseInt(yMax));
                r = r1;
            }else {
                for (int j = 0; j < linha.length(); j++) {
                    switch (linha.charAt(j)) {
                        case 'L':
                            r.L();
                            break;
                        case 'R':
                            r.R();
                            break;
                        case 'M':
                            //Testa se o movimento é válido
                            if (!(r.M())) {
                                test = false;
                                System.out.printf("Posição inválida\n");
                                break;
                            }
                            break;
                    }
                }
                if (test) {
                    System.out.printf("%d %d %c\n", r.x, r.y, r.orientacao);
                }
            }
            tamanho++;
        }
    }
    
}
