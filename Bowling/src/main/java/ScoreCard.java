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

        for(int i = 1;i < 3;i++){
            if (getSpecialRatings().indexOf(partida.charAt(position + i)) == -1){
                score += getNumericalRatings().indexOf(partida.charAt(position+i));
            }else{
                if(partida.charAt(i)== 'X'){
                    score  += this.getSTRIKE();
                }else{
                    score += this.getSPARE() -  getNumericalRatings().indexOf(partida.charAt(position+i-1));
                }
            }
        }
        return score;}


    public int calculateSpareValue(String partida,int position){
        int score = 0;

        score = getSPARE() - getNumericalRatings().indexOf(partida.charAt(position-1));

        if (getSpecialRatings().indexOf(partida.charAt(position + 1)) == -1){
            score += getNumericalRatings().indexOf(partida.charAt(position+1));
        }else{
            score  += this.getSTRIKE();}
        return score;
    }


    public int calculateScore(String partida){

        int score = 0;

        for (int i = 0;i<partida.length();i++) {


            if (getSpecialRatings().indexOf(partida.charAt(i)) == -1) {
                score += getNumericalRatings().indexOf(partida.charAt(i));
            }else{
                if(partida.charAt(i)== 'X'){
                    score  += calculateStrikeValue(partida,i);
                }else{
                    score += calculateSpareValue(partida,i);
                }
            }
        }
        return score;}
}