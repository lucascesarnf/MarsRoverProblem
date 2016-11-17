/*
 *  
 */
package marsrover;

/**
 *
 * @author lucas
 */
public class Rover {

    int x;
    int y;
    char orientacao;
    //Limites da parte direira superior
    int xMax;
    int yMax;

    //Construtor
    public Rover(int x, int y, char orientacao, int xMax, int yMax) {

        this.orientacao = orientacao;
        this.x = x;
        this.y = y;
        this.xMax = xMax;
        this.yMax = yMax;
    }
//Executa o comando L(Mover 90º para esquerda)

    public void L() {

        switch (this.orientacao) {
            case 'N':
                this.orientacao = 'W';
                break;
            case 'W':
                this.orientacao = 'S';
                break;
            case 'S':
                this.orientacao = 'E';
                break;
            case 'E':
                this.orientacao = 'N';
                break;

        }
    }
//Executa o comando R(Mover 90º para direita)

    public void R() {

        switch (this.orientacao) {
            case 'N':
                this.orientacao = 'E';
                break;
            case 'E':
                this.orientacao = 'S';
                break;
            case 'S':
                this.orientacao = 'W';
                break;
            case 'W':
                this.orientacao = 'N';
                break;

        }
    }
//Executa o comando M(Mover 1 bloco na direção da orientação)

    public boolean M() {
        switch (this.orientacao) {
            case 'N':
                if (this.y == this.yMax) {
                    return false;
                } else {
                    this.y++;
                    return true;
                }
            case 'E':
                if (this.x == xMax) {
                    return false;
                } else {
                    this.x++;
                    return true;
                }
            case 'S':
                if (this.y == 0) {
                    return false;
                } else {
                    this.y--;
                    return true;
                }
            case 'W':
                if (this.x == 0) {
                    return false;
                } else {
                    this.x--;
                    return true;
                }
        }
        return false;
    }
}
