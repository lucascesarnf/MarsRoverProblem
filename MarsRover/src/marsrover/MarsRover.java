/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        boolean test = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        String x;
        String y;
        String orientacao;
        String mat = br.readLine();
        String[] linhaDoArquivo = mat.split(" ");
        String xMax = linhaDoArquivo[0];
        String yMax = linhaDoArquivo[1];
        Rover r = new Rover(0, 0, 'N', parseInt(xMax), parseInt(yMax));
        int tamanho = 0;
        while ((linha = br.readLine()) != null) {
            test = true;
            if (tamanho % 2 == 0) {
                String[] arq = linha.split(" ");
                x = arq[0];
                y = arq[1];
                orientacao = arq[2];
                Rover r1 = new Rover(parseInt(x), parseInt(y), orientacao.charAt(0), parseInt(xMax), parseInt(yMax));
                r = r1;
            } else {
                for (int j = 0; j < linha.length(); j++) {
                    switch (linha.charAt(j)) {
                        case 'L':
                            r.L();
                            break;
                        case 'R':
                            r.R();
                            break;
                        case 'M':
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
