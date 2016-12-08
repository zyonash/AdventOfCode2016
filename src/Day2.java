import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zacharyyonash on 12/4/16.
 */
public class Day2 {
    public static void main(String args[]) throws IOException{
        String file = "input/day2.txt";
        BufferedReader in = null;
        String line;
        int dialNum = 5;
        ArrayList<Integer> code = new ArrayList();

        try{
            in = new BufferedReader(new FileReader(file));
        } catch(Exception e){
            System.out.println(e);
        }

        while((line = in.readLine()) != null){
            for(char c : line.toCharArray()){
                switch(c){
                    case 'U':
                        dialNum = (dialNum != 1 && dialNum != 2 && dialNum != 3) ? (dialNum - 3) : (dialNum);
                        break;
                    case 'D':
                        dialNum = (dialNum != 7 && dialNum != 8 && dialNum != 9) ? (dialNum + 3) : (dialNum);
                        break;
                    case 'L':
                        dialNum = (dialNum != 1 && dialNum != 4 && dialNum != 7) ? (dialNum - 1) : (dialNum);
                        break;
                    case 'R':
                        dialNum = (dialNum != 3 && dialNum != 6 && dialNum != 9) ? (dialNum + 1) : (dialNum);
                        break;
                }
            }
            code.add(dialNum);
        }


        for(Integer n : code){
            System.out.print(n);
        }
    }
}
