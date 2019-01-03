import java.util.Scanner;
public class AdivinaElDado {

    public void logicaJuego(){
        int saldo = 100;

        boolean juegoActivo = JuegoActivo(saldo);

        while (juegoActivo) {

            int apuesta = DineroApostado(saldo);
            int numeroElegido = ElegirDado();
            int numeroDado = (int) TirarDado();
            saldo = ActualizarSaldo(apuesta,numeroElegido,saldo,numeroDado);
            juegoActivo = JuegoActivo(saldo);
        }

    }

    public Boolean JuegoActivo(int saldo){
        Boolean JuegoActivo = true;
        System.out.printf("tu saldo es de: %d\n",saldo);
        if (saldo <= 0){
            JuegoActivo = false;
            System.out.println("Has perdido!!");
        }

    return JuegoActivo;}

    public int DineroApostado(int saldo){
        System.out.printf("Tienes %d para apostar,cuanto quieres apostar? \n",saldo);
        System.out.println("Si aciertas ganaras el doble si fallas perderas lo apostado");

        Scanner lector = new Scanner(System.in);
        int apuesta = lector.nextInt();
        System.out.printf("tu apuesta es de: %d\n",apuesta);
        return apuesta;
    }
    public double TirarDado(){
        int lados = 6;
        double randomNumber = Math.random() * 6;
        randomNumber ++;

        return randomNumber;
    }
    public int ElegirDado(){
        System.out.printf("Elige el numero del dado que crees que va a salir\n");
        Scanner lector = new Scanner(System.in);
        int numeroDado = lector.nextInt();
        System.out.printf("tu numero es:  %d\n",numeroDado);


    return numeroDado;}


    public int ActualizarSaldo(int apuesta,int numeroElegido,int saldo,int numeroDado){

        if (numeroDado == numeroElegido){
            saldo = saldo*2;
            System.out.println("Muy Bien Has acertado!!");
        }else{
            saldo = saldo-apuesta;
            System.out.println("Oh! Que Pena! Has fallado!");
        }
        System.out.printf("El numero que ha salido es: %d\n",numeroDado);
    return saldo;}

}
