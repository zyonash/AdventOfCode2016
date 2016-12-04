import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by zacharyyonash on 12/3/16.
 */
public class Day1 {
    public static void main (String args[]){
        char card_direction = 'N';
        char r_or_l;
        String steps;
        int x_position = 0;
        int y_position = 0;
        int blocks = 0;
        String filename = "input/day1.txt";
        String line = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
            line = in.readLine();
        }catch(Exception e){
            System.out.println(e);
        }

        String[] split_by_comma = line.split(", ");
        for(String direction: split_by_comma){
            r_or_l = direction.charAt(0);
            steps = direction.substring(1);
            switch(card_direction){
                case 'N':
                    if(r_or_l == 'R'){
                        x_position += Integer.parseInt(steps);
                        card_direction = 'E';

                        break;
                    } else{
                        x_position -= Integer.parseInt(steps);
                        card_direction = 'W';
                        break;
                    }
                case 'S':
                    if(r_or_l == 'L'){
                        x_position += Integer.parseInt(steps);
                        card_direction = 'E';
                        break;
                    } else{
                        x_position -= Integer.parseInt(steps);
                        card_direction = 'W';
                        break;
                    }
                case 'W':
                    if(r_or_l == 'R'){
                        y_position += Integer.parseInt(steps);
                        card_direction = 'N';
                        break;
                    } else{
                        y_position -= Integer.parseInt(steps);
                        card_direction = 'S';
                        break;
                    }
                case 'E':
                    if(r_or_l == 'L'){
                        y_position += Integer.parseInt(steps);
                        card_direction = 'N';
                        break;
                    } else{
                        y_position -= Integer.parseInt(steps);
                        card_direction = 'S';
                        break;
                    }
            }
        }

        if(x_position >= 0){
            blocks = (y_position >= 0) ? (x_position + y_position):(x_position - y_position);
        } else {
            blocks = (y_position >= 0) ? (y_position - x_position) : (y_position + x_position);
        }

        System.out.println("The answer is " + blocks + " blocks.");
    }
}
