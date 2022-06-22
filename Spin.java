import java.util.ArrayList;
import java.util.Random;


public class Spin {
    public Random random;
    public int random_number = 0;
    public int black_counter = 0;
    public int times_lost = 0;
    public int multiplier = 0;
    public ArrayList<Integer>  numbers, red_numbers, black_numbers;
    public int pengar = (int)((Math.pow(2, App.number_of_bets)) * App.min_bet), win_times = 0, lose_times = 0;
    

    Spin(int loops, int option){
            numbers = new ArrayList<Integer>();
            red_numbers = new ArrayList<Integer>();
            black_numbers = new ArrayList<Integer>();
            random = new Random();
            for (int i = 0; i < 37; i++){
                numbers.add(i);
                if(i % 2 != 0){
                    black_numbers.add(i);
                }
            }
            for(int i = 0 ; i<loops ; i++){
                random_number = random.nextInt(38);
                if(black_numbers.contains(random_number)){
                    black_counter++;
                    if(black_counter == App.number_of_bets){
                        times_lost++;
                        black_counter = 0;
                        
                        //------------------------Pengar räkning-----------------------//
                        for(int j = 0; j < App.number_of_bets + 1; j++){ // 2 to the power of j
                            multiplier += (int)Math.pow(2, j); //Add all the numbers    
                        }
                        pengar -= multiplier * App.min_bet;// And multiply the number to the min_bet
                        //------------------------Pengar räkning-----------------------//
                        

                    }
                }else{
                    //------------------------Pengar räkning-----------------------//
                    pengar += App.min_bet;
                    //------------------------Pengar räkning-----------------------//
                    black_counter = 0;
                }
                if(pengar <=0){
                    break;
                }
            }
            
            if(pengar > App.max_bet){
                win_times++;
                if(option == 1){
                System.out.println("Du vann totalt av 180 gånger: " + (pengar - (int)((Math.pow(2, App.number_of_bets)) * App.min_bet)) + ".\nDen slutliga summan blir: " + pengar);}
            }else{
                lose_times++;
                if(option == 1){
                System.out.println("Youuuuuuuuuuuuuu LOOOOOOOOOOOOOOOOOOSE");}
            }
            
    }
}