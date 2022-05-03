import java.util.Scanner;

public class GoL_Proto {
    
    public static void main(String[]Args){

        //int rundenzahler = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Feldgröße angeben");
        int skalier = scan.nextInt();
        System.out.println('\n');
        int[][] Feldsxs = new int[skalier][skalier];

        Feldsxs = fullenleer(skalier);
        System.out.println("Runde 0");
        druck2d(Feldsxs, skalier);
        System.out.println('\n');
        ctrlcntr(Feldsxs, skalier, 1);

        System.out.println("Program has ended");
        scan.close();
    }

    public static void ctrlcntr(int[][] original_cc, int gros_cc, int runde) {
        Scanner skant = new Scanner(System.in);

        System.out.println('\n');
        System.out.println("Awaiting input -- help -- for a list of commands");
        String user = skant.nextLine();
        System.out.println('\n');

        switch(user){

            default:
                System.out.println("No input");
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "random": //random
                original_cc = fullen(gros_cc);
                druck2d(original_cc, gros_cc);
                ctrlcntr(original_cc, gros_cc, 0);
            break;

            case "end": //end
                System.out.println("Program closing...");
            break;

            case "c": //cycle
                original_cc = life(original_cc, gros_cc);
                System.out.println("Runde "+ Integer.toString(runde++));
                druck2d(original_cc, gros_cc);
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "add": //add
                original_cc = add(original_cc, gros_cc);
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "print": //print
                druck2d(original_cc, gros_cc);
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "cycles":
                System.out.println("Number of cycles");
                int o = skant.nextInt();
                System.out.print('\n');


                for(int u= 1; u<=o;u++){
                    original_cc = life(original_cc, gros_cc);
                    System.out.println("Runde "+ Integer.toString(runde++));
                    druck2d(original_cc, gros_cc);
                    System.out.print('\n');
                }
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "quickcycles":
                System.out.println("Number of cycles");
                int q = skant.nextInt();
                System.out.print('\n');


                for(int u= 1; u<=q;u++){
                    original_cc = life(original_cc, gros_cc);
                    runde++;
                }
                System.out.println("Runde "+ Integer.toString(runde));
                druck2d(original_cc, gros_cc);
                System.out.print('\n');
                ctrlcntr(original_cc, gros_cc, runde);
            break;

            case "help":
                System.out.println(" end    -- ends the program");
                System.out.println(" random -- fills the board with random cells");
                System.out.println(" add    -- type in coordinates to change the state of a cell");
                System.out.println(" print  -- outputs the current board");
                System.out.println(" c      -- runs one lifecycle under the Rules of Conways Game of Life");
                System.out.println(" cycles -- runs multiple lifecycles under the Rules of Conways Game of Life");
                System.out.println(" quickcycles -- runs multiple lifecycles but only prints last state");


                ctrlcntr(original_cc, gros_cc, runde);
            break;
        }
        skant.close();
    }

    public static int[][] add(int[][] original_a1, int gros_a1) {
        Scanner abfrage = new Scanner(System.in);
        System.out.println("Koordinaten eingeben:");
        System.out.println("x:  ");
        int xwert = abfrage.nextInt();
        System.out.println("y:  ");
        int ywert = abfrage.nextInt();
        
        if(original_a1[ywert-1][xwert-1] == 1){
            original_a1[ywert-1][xwert-1] = 0;
        }else{
            original_a1[ywert-1][xwert-1] = 1;
        }

        druck2d(original_a1, gros_a1);
        return original_a1;

    }

    public static int[][] fullen(int gros_fullen){
        int[][] feld_placeholder = new int[gros_fullen][gros_fullen];
        
        for(int row = 0; row <=  (gros_fullen-1); row++){

            for(int column = 0; column <=  (gros_fullen-1); column++){
                
                if(Math.random() >= 0.6){
                    feld_placeholder[row][column] = 1; 
                }else{
                    feld_placeholder[row][column] = 0;
                }
            }
        }
        return feld_placeholder;
    }

    public static int[][] fullenleer(int gros_fulllenleer){
        int[][] feld_placeholder = new int[gros_fulllenleer][gros_fulllenleer];
        
        for(int row = 0; row <= (gros_fulllenleer-1); row++){

            for(int column = 0; column <= (gros_fulllenleer-1); column++){
                feld_placeholder[row][column] = 0;
            }
        }
        return feld_placeholder;
    }

    public static void druck2d(int[][] ausgabe, int groesse){
        System.out.print("0  ");
        for(int p = 1; p <= groesse; p++){
            if(p >= 10){
                if( p>= 100){
                    System.out.print(Integer.toString(p));
                }else{
                    System.out.print( "" + Integer.toString(p));
                }
            }else{
                System.out.print( "" + Integer.toString(p) + " ");
            }
        }
        System.out.print('\n');
        for(int i = 0; i <= (groesse-1); i++){

            if(i >= 9){
                if( i>= 99){
                    System.out.print(Integer.toString(i+1));
                }else{
                    System.out.print(Integer.toString(i+1) + " ");
                }
            }else{
                System.out.print(Integer.toString(i+1) + "  ");
            }
            
            for(int j = 0; j <= (groesse-1); j++){
                
                if(ausgabe[i][j] == 1){
                    System.out.print("██");
                }else{
                    System.out.print("░░");
                }
                 
                
                if(j != (groesse-1)){
                    System.out.print("");
                }else{
                    System.out.print('\n');
                }
            }

        }
    }

    public static int[][] life(int[][] original, int gros_life){
        int[][] kopie = fullenleer(gros_life);
        
        for (int i = 0; i <= (gros_life-1); i++) {
            for (int j = 0; j <= (gros_life-1); j++) {

                int nachbarn = prufen_1(original, i, j, (gros_life-1));
                if(original[i][j] == 0 && nachbarn == 3){
                    kopie[i][j] = 1;
                }
                if(original[i][j] == 1 && (nachbarn == 3 || nachbarn == 2)){
                    kopie[i][j] = 1;
                }

            }
        }
        return kopie;
    }

    public static int prufen_1(int[][] original_p1, int reihe, int spalte, int gros_p1) {
        int count = 0;

        if(reihe > 0 && spalte > 0){
            if(original_p1[reihe-1][spalte-1] == 1){
                count++;
            }
        }

        if(reihe > 0){
            if(original_p1[reihe-1][spalte] == 1){
                count++;
            }
        }

        if(reihe > 0 && spalte < gros_p1){
            if(original_p1[reihe-1][spalte+1] == 1){
                count++;
            }
        }

        if(spalte > 0){
            if(original_p1[reihe][spalte-1] == 1){
                count++;
            }
        }

        if(spalte < gros_p1){
            if(original_p1[reihe][spalte+1] == 1){
                count++;
            }
        }

        if(reihe < gros_p1 && spalte > 0){
            if(original_p1[reihe+1][spalte-1] == 1){
                count++;
            }
        }

        if(reihe < gros_p1){
            if(original_p1[reihe+1][spalte] == 1){
                count++;
            }
        }

        if(reihe < gros_p1 && spalte < gros_p1){
            if(original_p1[reihe+1][spalte+1] == 1){
                count++;
            }
        }

        return count;
    }

}
