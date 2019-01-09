import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdivinaPelicula {

    public void adivinarPelicula() throws Exception {

        List peliculas = CrearArrayPeliculas();
        String pelicula = ElegirPelicula(peliculas);
        String resolver = ConvertirStringEnGuiones(pelicula);
        BucleAdivinarPeli(pelicula,resolver);
    }

    private List CrearArrayPeliculas()throws Exception{

        File texto = new File("movies.txt");
        Scanner scanner = new Scanner(texto);
        ArrayList peliculas = new ArrayList();




        while (scanner.hasNextLine()){
            String linia = scanner.nextLine();
            peliculas.add(linia); }


        return peliculas;}


    private String ElegirPelicula(List peliculas){

        int NumeroAleatorio = (int) (Math.random() * peliculas.size());
        return (String) peliculas.get(NumeroAleatorio); }


    private String ConvertirStringEnGuiones(String convertir){

        String convertido = "";

        for(int i = 0; i < convertir.length();i++){
            convertido += "_"; }

        return convertido;}


    private void BucleAdivinarPeli(String pelicula,String resolver) {

        String letrasFalladas = "";
        int intentos = 10;
        Boolean hasGanado = false;
        System.out.println(resolver);

        for (int i = 0; i < intentos; i++) {

            String letra = LeerTeclado(intentos, i);
            int posicion = pelicula.indexOf(letra);

            if (letra.length() > 1) {
                if (letra.equalsIgnoreCase(pelicula) ) {
                    hasGanado = true;
                    break;

                } else {
                    letrasFalladas = AñadirLetrasFalladas(letrasFalladas,letra);
                    System.out.println("Has fallado!!");
                    HasFallado(resolver,letrasFalladas);}

            } else {

                if (posicion != -1) {
                    i--; // resto uno a i para que cuando acierte este intento no se pierda puesto que si tiene 11 letras ya no lo podrias adivinar
                    System.out.println("Has acertado esta letra!");
                    resolver = BuscarLetrasRepetidas(posicion,resolver,letra,pelicula);

                } else {
                    System.out.println("Has fallado!!");
                    letrasFalladas = AñadirLetrasFalladas(letrasFalladas,letra); }

                if (resolver.contains("_")) {
                    //mientras haya un guion quiere decir que aun falta una letra por resolver
                    HasFallado(resolver,letrasFalladas);

                } else {
                    hasGanado = true;
                    break; }
            }
        }
        if (hasGanado) {
            HasGanado();
        }else{
            HasPerdido(pelicula); }
    }

    private String LeerTeclado(int intentos,int i){

        Scanner entrada = new Scanner(System.in);

        System.out.printf("Tienes que adivinar la pelicula dispones de %d intentos\n",intentos-i);
        System.out.println("Elige una letra!!");
        String letra = entrada.nextLine();

        letra = letra.toLowerCase();
        return letra;}


    private String BuscarLetrasRepetidas(int posicion,String resolver,String letra,String pelicula){
        //En este metodo busco todas las veces que se repite la letra para que no solo se destape la primera letra del string de guiones


        while (posicion != -1) {
            String firstPart = resolver.substring(0, posicion);
            String lastPart = resolver.substring(posicion + 1, resolver.length());
            resolver = firstPart + letra + lastPart;
            posicion = pelicula.indexOf(letra, posicion + 1); }

        return resolver;}

    private void HasGanado(){

        System.out.println(" ");
        System.out.println("Muy bien has ganado!!"); }


    private void HasPerdido(String pelicula){

        System.out.println(" ");
        System.out.println("Has perdido!! :(");
        System.out.printf("la pelicula era %s",pelicula);}


    private void HasFallado(String resolver, String letrasFalladas){

        System.out.println(resolver);
        System.out.printf("Estas son las letras que has fallado!: %s\n", letrasFalladas);
    }

    private String AñadirLetrasFalladas(String letrasFalladas,String letra){

        letrasFalladas += letra + "," + " ";

    return letrasFalladas;}

}