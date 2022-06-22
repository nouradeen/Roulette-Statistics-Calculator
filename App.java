import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    static ArrayList<Integer> times_spins = new ArrayList<Integer>();
    static int result = 0;
    static int antal_i_timme = 0;
    static int min_bet, max_bet, number_of_bets = 0;
    static int bet, key, win = 0, lose = 0;
    
    
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Välj en av alternativen, skriv en siffra: ");
        System.out.println("1- Räkna för en spelomgång för att se hur mycket kan du vinna.");
        System.out.println("2- Räkna (Statistik) för hur många gånger kan du förlora och hur länge borde du spela");
        key = input.nextInt();
        

        switch (key) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Hur många spel kan man spela i timmen?\nOBS: Ungefär 180 gånger om spelet tar 20 sek\nAntal: ");
                antal_i_timme = input.nextInt();
                System.out.print("Skriv minsta spel summa: ");
                min_bet = input.nextInt();
                System.out.print("Skriv största spel summa: ");
                max_bet = input.nextInt();
                
                bet = min_bet;
                for(int i = 0;;i++){// Calculate the doubling numbers from min_bet to max_bet
                    if((bet*2) < max_bet){
                        bet *= 2;
                        number_of_bets++;
                    }else if((bet*2) >= max_bet){
                        break;
                    }
                }
                System.out.println("\nDu kan spela upp till " + (number_of_bets + 1) +" gånger innan du förlorar ett spelomgång\n");

            
                for(int i = 0; i < 1; i++){
                    Spin spin = new Spin(antal_i_timme,1);
                    times_spins.add(spin.times_lost);
                }
                for(int i = 0; i <times_spins.size(); i++){
                    result += times_spins.get(i);
                }
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Hur många spel kan man spela i timmen?\nOBS: Ungefär 180 gånger om spelet tar 20 sek\nAntal: ");
                antal_i_timme = input.nextInt();
                System.out.print("Skriv minsta spel summa: ");
                min_bet = input.nextInt();
                System.out.print("Skriv största spel summa: ");
                max_bet = input.nextInt();
                bet = min_bet;
                for(int i = 0;;i++){
                    if((bet*2) <= max_bet){
                        bet *= 2;
                        number_of_bets++;
                    }else if((bet*2) > max_bet){
                        break;
                    }
                }
                System.out.println("\nDu kan spela upp till " + (number_of_bets + 1) +" gånger innan du förlorar ett spelomgång\n");

            
                for(int i = 0; i < 50000; i++){
                    Spin spin = new Spin(antal_i_timme,2);
                    times_spins.add(spin.times_lost);
                    win += spin.win_times;
                    lose += spin.lose_times;
                }
                for(int i = 0; i <times_spins.size(); i++){
                    result += times_spins.get(i);
                }
                System.out.println("Resultatet efter beräkningen av 180 spel i timmen 50,000 gånger blir, \nmedelvärdet för hur många gånger man kan förlora i timmen är: " + result/(float)times_spins.size() + "\n");
                System.out.println("Antal de (totala) vinster och förluster under 50,000 gånger blev det: \nVinster: " + win + " gånger" + "\nFörloster: " + lose + " gånger\n");
                System.out.println("Vinst: " + (((float)win/(float)(win + lose))*100) + " %\n");
                System.out.println("\nSpela fram tills du förlorar " + (int)(result/(float)times_spins.size()) + " gånger, detta är ungefär " + (int)((3600/(result/(float)times_spins.size()/2)/60)) + " minuter" + "\nEller " + (int)((3600/(result/(float)times_spins.size()/2))/(3600/antal_i_timme)) + " antal spelomgångar");
                break;
            default:
                break;
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
        

}