import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by zacharyyonash on 12/3/16.
 */
public class Day1_Part2 {
    public static void main (String args[]){
        char card_direction = 'N';
        char r_or_l;
        int x_position = 0;
        int y_position = 0;
        int final_x_position = 0;
        int final_y_position = 0;
        double blocks = 0;
        String filename = "input/day1.txt";
        String line = "";
        HashMap<String,Integer> map = new HashMap();
        // Initialize 0,0 as your first seen point
        map.put(x_position+","+y_position,1);
        boolean keep_moving = true;
        Integer put_return;

        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
            line = in.readLine();
        }catch(Exception e){
            System.out.println(e);
        }

        String[] split_by_comma = line.split(", ");
        for(String direction: split_by_comma){
            if(!keep_moving) { break; }
            r_or_l = direction.charAt(0);
            int dSteps = Integer.parseInt(direction.substring(1));
            switch(card_direction){
                case 'N':
                    if(r_or_l == 'R'){
                        while(dSteps > 0){
                            x_position++;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'E';
                        break;
                    } else{
                        while(dSteps > 0){
                            x_position--;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'W';
                        break;
                    }
                case 'S':
                    if(r_or_l == 'L'){
                        while(dSteps > 0){
                            x_position++;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'E';
                        break;
                    } else{
                        while(dSteps > 0){
                            x_position--;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'W';
                        break;
                    }
                case 'W':
                    if(r_or_l == 'R'){
                        while(dSteps > 0){
                            y_position++;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'N';
                        break;
                    } else{
                        while(dSteps > 0){
                            y_position--;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'S';
                        break;
                    }
                case 'E':
                    if(r_or_l == 'L'){
                        while(dSteps > 0){
                            y_position++;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'N';
                        break;
                    } else{
                        while(dSteps > 0){
                            y_position--;
                            dSteps--;
                            System.out.println(x_position + "," + y_position);
                            put_return = map.put(x_position+","+y_position,1);
                            System.out.println(put_return);
                            if(put_return != null){
                                final_x_position = x_position;
                                final_y_position = y_position;
                                keep_moving = false;
                                break;
                            }
                        }
                        card_direction = 'S';
                        break;
                    }
            }
        }
        
        if(final_x_position >= 0){
            blocks = (final_y_position >= 0) ? (final_x_position + final_y_position)
                    : (final_x_position - final_y_position);
        } else {
            blocks = (final_y_position >= 0) ? (final_y_position - final_x_position)
                    : (final_y_position + final_x_position);
        }

        if(blocks<0){ blocks = -blocks; }
        System.out.println("The answer is " + blocks + " blocks.");
    }
}
