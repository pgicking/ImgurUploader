/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/5/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

/* Allows the use of input in place of system.in
 * Example:
 *
 * System.out.print("What is your rooms name: ");
 *	   this.name = input.nextLine();
 */

public class Util {
    protected static Scanner input;

    public Util(){
        input = new Scanner(System.in);
    }

}
