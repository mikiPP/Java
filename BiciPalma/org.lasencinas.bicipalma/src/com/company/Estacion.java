package com.company;


public class Estacion {

    private int id = 0;
    private String direccion = null;
    private int numeroAnclajes = 0;
    private Bicicleta[] anclajes 	 = null;

    Estacion(int id,String direccion,int numeroAnclajes){
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = numeroAnclajes;
        this.anclajes = new Bicicleta[numeroAnclajes];

    }

    public int getId() {
        return id;
    }


    public void consultarEstacion(){
        System.out.print(this.id+ " ");
        System.out.print(this.direccion+" ");
        System.out.print(this.numeroAnclajes);

    }

    public int anclajesLibres(){
        int anclajesLibres = 0;

        for(int i=0;i< this.anclajes.length;i++){
            if (this.anclajes[i] == null){
                anclajesLibres++;
            }
        }
    return  anclajesLibres;}


    public  void  consultarAnclajes(){
        for(int i=0;i< this.anclajes.length;i++){
            if (this.anclajes[i] == null){
                System.out.println("Esta libre");
            }else{
                System.out.println(this.anclajes[i].getId());
            }
        }
    }



    public void anclarBicicleta(Bicicleta bicicleta){

        for(int i=0;i< this.anclajes.length;i++){
            if (this.anclajes[i] == null){
                mostrarAnclaje(bicicleta,this.numeroAnclajes);
                this.anclajes[i] =  bicicleta;
                numeroAnclajes = i+1;
                break;
            }
        }
   }


    public void mostrarBicicleta(Bicicleta bicicleta, int numeroAnclaje){
        System.out.println("bicicleta retirada: " + bicicleta.getId() + " del anclaje: " + numeroAnclaje);
    }


    public void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){
        System.out.println("bicicleta: " + bicicleta.getId() + " anclada en el anclaje: " + numeroAnclaje);
    }




    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario){
        return tarjetaUsuario.getActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario){

        if (leerTarjetaUsuario(tarjetaUsuario)){
            boolean anclajeLibre = false;
            while(!anclajeLibre){
                int posicion = generarAnclaje();
                int numeroAnclaje = posicion + 1;
                if (this.anclajes[posicion]!= null){
                    mostrarBicicleta( this.anclajes[posicion], numeroAnclaje );
                    this.anclajes[posicion] = null;
                    anclajeLibre = true;
                }
            }
        }else{
            System.out.print("La tarjeta no esta activada");
        }
    }


    public int generarAnclaje(){
        int pos = (int) (Math.random() * this.anclajes.length);
    return pos;}
}
