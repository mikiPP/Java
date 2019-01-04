import java.io.File;
import java.util.Scanner;

public class AdivinaPelicula {

    public void adivinarPelicula() throws Exception {
        String[] Array = CrearArrayPeliculas();
        String pelicula = ElegirPelicula(Array);
        String resolver = ConvertirStringEnGuiones(pelicula);
        BucleAdivinarPeli(pelicula,resolver);
    }

    private String[] CrearArrayPeliculas()throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        String[] films ;
        films = new String[26];
        int index = 0;


        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            films[index] = line;
            index++;

        }
    return films;}

    public void ImprimirArray(String [] array){
        for (int i =0; i < array.length ; i++){
            System.out.println(array[i]);
        }
    }

    private String ElegirPelicula(String [] array){
        int randomNumber = (int) (Math.random() * array.length) +1;
        return array[randomNumber]; }


    private String ConvertirStringEnGuiones(String convertir){
        String convertido = "";

        for(int i = 0; i < convertir.length();i++){
            convertido += "_";
        }

    return convertido;}

    private void BucleAdivinarPeli(String pelicula,String resolver){
        String letrasFalladas = "";
        char [] array;
        int intentos = 10;
        Scanner entrada = new Scanner(System.in);
        System.out.println(resolver);


        for (int i = 0;i < intentos;i++){

            System.out.printf("Tienes que adivinar la pelicula dispones de %d intentos\n",intentos-i);

            System.out.println("Elige una letra!!");
            String letra = entrada.nextLine();
            int posicion = pelicula.indexOf(letra);


            if (posicion != -1){
                i--;
                System.out.println("Has acertado esta letra!");
                while (posicion !=  -1){
                    String firstPart = resolver.substring(0, posicion);
                    String lastPart = resolver.substring(posicion+1,resolver.length());
                    resolver = firstPart + letra + lastPart;
                    posicion = pelicula.indexOf(letra,posicion+1);
                }


            }else{
                letrasFalladas += letra + "," + " ";

            }

            if (resolver.contains("_")){
                System.out.println(resolver);
                System.out.printf("Estas son las letras que has fallado!: %s\n",letrasFalladas);
            }else {
                intentos = 0;
                System.out.println(" ");
                System.out.println("Muy bien has ganado!!");
                System.out.printf("la pelicula es %s y has tardado %d intentos",pelicula,i+1);
                break;

            }
        }
        if (intentos == 10) {
            System.out.println(" ");
            System.out.println("Has perdido!! :(");
            System.out.printf("la pelicula era %s",pelicula);}

    }
}

