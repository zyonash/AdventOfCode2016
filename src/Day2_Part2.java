import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zacharyyonash on 12/7/16.
 */
public class Day2_Part2 {
    public static void main(String args[]) throws IOException {
        String file = "input/day2.txt";
        BufferedReader in = null;
        String line;
        ArrayList<Character> code = new ArrayList();
        char keypad[][] = {
                {'n', 'n', '1', 'n', 'n'},
                {'n', '2', '3', '4', 'n'},
                {'5', '6', '7', '8', '9'},
                {'n', 'A', 'B', 'C', 'n'},
                {'n', 'n', 'D', 'n', 'n'}
        };

        int x_position = 0;
        int y_position = 2;

        try{
            in = new BufferedReader(new FileReader(file));
        } catch(Exception e){
            System.out.println(e);
        }

        while((line = in.readLine()) != null){
            for(char c : line.toCharArray()){
                switch(c){
                    case 'U':
                        if(keypad[y_position][x_position] != '1'){
                            y_position = (keypad[y_position-1][x_position] == 'n')?(y_position):(y_position-1);
                        }
                        break;
                    case 'D':
                        if(keypad[y_position][x_position] != 'D') {
                            y_position = (keypad[y_position+1][x_position] == 'n')?(y_position):(y_position+1);
                        }
                        break;
                    case 'L':
                        if(keypad[y_position][x_position] != '5'){
                            x_position = (keypad[y_position][x_position-1] == 'n')?(x_position):(x_position-1);
                        }
                        break;
                    case 'R':
                        if(keypad[y_position][x_position] != '9'){
                            x_position = (keypad[y_position][x_position+1] == 'n')?(x_position):(x_position+1);
                        }
                        break;
                }
            }
            code.add(keypad[y_position][x_position]);
        }


        for(char c : code){
            System.out.print(c);
        }
    }
}
