import java.util.Scanner;

public class AdivinaElNumero {
    private Boolean juegoActivo = true;
    private Scanner entrada = new Scanner (System.in);

    public void jugar(){
        System.out.println("Hola,¿cúal es tu nombre?");
        String nombreJugador = entrada.nextLine();
        System.out.printf("Bienvenido %s, vamos a empezar!\n",nombreJugador);
        int min = 0;
        int max = 100;
        int intentos = 0;
        int numeroJuego = NumeroAleatorio(min,max);
        System.out.printf("%s,he escogido un número entre %d y %d,adivínalo!!\n",nombreJugador,min,max);

        while (juegoActivo){

            int numeroJugador;
            numeroJugador = entrada.nextInt();

            if (numeroJuego == numeroJugador){
                juegoActivo = false;
            System.out.printf("Muy bien %s, has acertado!!, el nuemero correcto era: %d ",nombreJugador,numeroJuego);
            System.out.printf("Has tardado %d intentos, inténtalo hacer en menos intentos la próxima vez!",intentos);

            }else if (numeroJugador > numeroJuego){
                System.out.println("Has fallado!! Tu numero es superior al numero que he escogido");

            }else{
                System.out.println("Has fallado!! Tu numero es inferior al numero que he escogido");
            }
        intentos++;}


    }

    public int NumeroAleatorio(int min,int max){
        int range = max - min;
        int numeroJuego = (int) (Math.random() * range +1);
    return numeroJuego;}
}
