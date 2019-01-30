import java.lang.String;

public class ScoreCard {

    /*--------------Variables de clase ---------------*/


    private String specialRatings = "X/";
    private String numericalRatings = "-123456789";
    private int STRIKE = 10;
    private int SPARE = 10;
    private int ZERO = 0;


    /*----------------Constructor---------------------*/

    ScoreCard(){}


    /*----------------Getters-------------------------*/

    public String getSpecialRatings(){
        return specialRatings; }


    public String getNumericalRatings(){
        return  numericalRatings; }


    public int getSTRIKE(){
        return this.STRIKE;}


    public int getSPARE(){
        return this.SPARE;}

    /*------------------Metodoos-------------------------*/


    public int calculateStrikeValue(String partida,int position){

        int score;

        score = getSTRIKE();

        try{

            for(int i = 1;i < 3;i++){
                if (getSpecialRatings().indexOf(partida.charAt(position + i)) == -1){
                    score += this.calculatePinsValue(partida,position+i);
                }else{
                    if(partida.charAt(position + i)== 'X'){
                        score  += this.getSTRIKE();
                    }else{
                        score += this.getSPARE() -  getNumericalRatings().indexOf(partida.charAt(position+i-1));
                    }
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            return this.ZERO;}

        finally {
            return score; }
    }


    public int calculateSpareValue(String partida,int position){
        int score;

        score = getSPARE() - getNumericalRatings().indexOf(partida.charAt(position-1));
        try{
            if (getSpecialRatings().indexOf(partida.charAt(position + 1)) == -1){
                score += this.calculatePinsValue(partida,position+1);;
            }else{
                score  += this.getSTRIKE();}
        }catch (StringIndexOutOfBoundsException e){
        ;}
        finally {
            return score; }
        }

    public  int calculatePinsValue(String partida,int posicion){
        return  getNumericalRatings().indexOf(partida.charAt(posicion));
    }


    public int calculateScore(String partida){
        int finalScore = 0;
        int ball=0;


        for (int i = 0;i<partida.length();i++) {
            if (ball < 18) {

                if (getSpecialRatings().indexOf(partida.charAt(i)) == -1) {
                        finalScore += calculatePinsValue(partida, i);
                        ball++;

                } else {
                    if (partida.charAt(i) == 'X') {
                            finalScore += calculateStrikeValue(partida, i);
                            ball += 2;

                    } else {
                            finalScore += calculateSpareValue(partida, i);
                            ball ++;
                    }
                }
            }else{
                finalScore += calculateLastThreeBalls(partida,i);
            }
           }

        return finalScore;}


        public int calculateLastThreeBalls(String partida,int position){
            int score;

                if (getSpecialRatings().indexOf(partida.charAt(position)) == -1) {
                    score = calculatePinsValue(partida, position);

                } else if (partida.charAt(position) == '/'){
                    score = getSPARE() - getNumericalRatings().indexOf(partida.charAt(position-1));
                }else{
                    score = getSTRIKE();
                }


        return score;}
}