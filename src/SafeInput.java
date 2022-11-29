import java.util.Scanner;
public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String result="";
        boolean done=false;
        do
        {
            System.out.print(prompt+": ");
            result= pipe.nextLine();
            if( result.length()>=1 )
                done=true;
            else
                System.out.println("\nAtleast one character must be inserted, please try again!");
        }
        while(!done);
        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String result="";
        boolean done=false;
        do
        {
            System.out.print(prompt + ": ");
            result = pipe.nextLine();
            if (result.matches(regEx))
                done = true;
            else
                System.out.println("\nCharacter must match the patter: " + result);
        }
        while(!done);
        return result;
    }

    /**
     * It returns an integer with no restrictions
     * @param pipe a Scanner instance to use for input
     * @param prompt tells the user what to input
     * @return gives an int as the output
     */

    public static int getInt(Scanner pipe, String prompt)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println(trash+" is an invalid input. Try again!");
            }
        }
        while(!done);
        return result;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double result=0;
        boolean done=false;
        String trash="";
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println(trash+ "is not a double. Try again!");
            }
        }while(!done);
        return result;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int result=0;
        boolean done=false;
        String trash="";

        do
        {
            System.out.print(prompt + " ["+ low + "-" + high +"]: ");

            if (pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); // Clears the buffer
                if (result >= low && result <= high)
                    done = true;
                else
                {
                    System.out.println("Value must be in range ["+ low + "-" + high + "]: " + result);
                    System.out.println("Try again!");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println(trash+ " is not a correct int value, try again!");
            }
        }
        while (!done);
        return result;
    }
    /**
     *
     * @param pipe Scanner instance to enter a double
     * @param prompt tells the user what to input
     * @param low tells the lower limit of input
     * @param high tells to upper limit of input
     * @return returns the value
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double result = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");

            if(pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                pipe.nextLine(); // Clears the buffer
                if(result >= low && result <= high)
                    done = true;
                else
                {
                    System.out.println("Value must be in range [" + low + " - " + high + "]: " + result);
                    System.out.println("Try again!");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println(trash+ "is not a correct double value, try agan!");
            }
        }
        while(!done);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String YOrNConfirm = "";
        boolean done = false;
        boolean value = false;
        do
        {
            System.out.println(prompt +": ");
            YOrNConfirm = pipe.nextLine();
            YOrNConfirm = YOrNConfirm.toUpperCase();
            if(YOrNConfirm.equals("Y"))
            {
                value = true;
                done = true;
            }
            else if(YOrNConfirm.equals("N"))
            {
                value = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter a valid value. Either Yes(y/Y) or No(N/n)!");
            }
        }
        while(!done);
        return value;
    }

    public static void prettyHeader(String message)
    {
        final int char_length = 60;
        for(int x = 1; x <= char_length; x++)
        {
            System.out.print("*");

        }
        System.out.println();
        int space=char_length -6- message.length();
        int lSpace=0;
        int rSpace=0;
        if(space%2==0)
        {
            lSpace=rSpace=space/2;
        }
        else
        {
            lSpace=space/2;
            rSpace=lSpace+1;
        }
        System.out.print("***");
        for(int i=1; i<=lSpace; i++ )
        {
            System.out.print(" ");
        }
        System.out.print(message);
        for(int i=1; i<=rSpace; i++ )
        {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();
        for(int x=1; x<=char_length; x++)
        {
            System.out.print("*");

        }

    }
}


