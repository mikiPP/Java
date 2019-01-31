import java.lang.String;

public class ScoreCard {

    /*-------------- Class variables ---------------*/


    private String specialRatings = "X/";
    private String numericalRatings = "-123456789";
    private int STRIKE = 10;
    private int SPARE = 10;
    private int ZERO = 0;


    /*---------------- Builder ---------------------*/

    ScoreCard(){}


    /*---------------- Getters and Setters -------------------------*/

    public String getSpecialRatings(){
        return specialRatings; }


    public String getNumericalRatings(){
        return  numericalRatings; }


    public int getSTRIKE(){
        return this.STRIKE;}


    public int getSPARE(){
        return this.SPARE;}
        
    public int setSpare(String game,int position){
        return this.getSPARE() - this.calculatePinsValue(game,position);
    }    

    /*------------------ Methods -------------------------*/

    public boolean isStrike(String game,int position ){

        if (game.charAt(position) == 'X'){
            return true;

        } else{
            return false; }
        }

    public boolean isNumericalRaiting(String game,int position){

        if (getSpecialRatings().indexOf(game.charAt(position)) == -1){
            return true;

        } else{
            return false; }
    }

    /*----------------- Calculate Methods ----------------------*/

    public int calculateStrikeValue(String game,int position){

        int score;

        score = getSTRIKE();

        try{

            for(int i = 1;i < 3;i++){

                if (this.isNumericalRaiting(game,position+i)){
                    score += this.calculatePinsValue(game,position+i);

                }else{
                    if(this.isStrike(game,position+i)){
                        score  += this.getSTRIKE();

                    }else{
                        score += this.setSpare(game,position+i-1);
                    }
                }
            }

        }catch (StringIndexOutOfBoundsException e){
            return this.ZERO;}

        finally {
            return score; }
    }


    public int calculateSpareValue(String game,int position){
        int score;

        score = this.setSpare(game,position-1);

        try{

            if (this.isNumericalRaiting(game,position+1)){
                score += this.calculatePinsValue(game,position+1);;

            }else{
                score  += this.getSTRIKE();}

        }catch (StringIndexOutOfBoundsException e){ ;}

        finally {

            return score; }
    }

    public  int calculatePinsValue(String game,int posicion){

        return  this.getNumericalRatings().indexOf(game.charAt(posicion));
    }


    public int calculateLastThreeBalls(String game,int position){
        int score;

        if (this.isNumericalRaiting(game,position)) {
            score = calculatePinsValue(game, position);

        } else if (this.isStrike(game,position)){
            score = this.getSTRIKE();

        }else{
            score = this.setSpare(game,position-1);
        }

        return score;}


    public int calculateScore(String game){

        int finalScore = 0;
        int ball=0;


        for (int i = 0;i<game.length();i++) {

            if (ball < 18) {

                if (this.isNumericalRaiting(game,i)) {
                    finalScore += this.calculatePinsValue(game, i);
                    ball++;

                } else {
                    if (this.isStrike(game,i)) {
                        finalScore += this.calculateStrikeValue(game, i);
                        ball += 2;

                    } else {
                        finalScore += this.calculateSpareValue(game, i);
                        ball ++;
                    }
                }
            }else{
                finalScore += this.calculateLastThreeBalls(game,i);
                ball++;
            }
        }

        return finalScore;}



}
