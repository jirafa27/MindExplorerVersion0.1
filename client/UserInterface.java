package client;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public static Object enterSomething(Class type)  {
        try {
            if (type.getConstructors()[0].newInstance() instanceof Integer)
            return  scanner.nextInt();
        } catch (InstantiationException e ) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // if (type.getConstructors()[0].newInstance() instanceof Boolean)
            return scanner.nextBoolean();
    }
    public static void printString(String string)
    {
        System.out.println(string);
    }
}
