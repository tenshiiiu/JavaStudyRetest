package Wrapper;

public class WrapperApp {
    
    public static void main(String[] args) {
        // Create Integer and Double objects
        Integer integerObj = Integer.valueOf(42);
        Double doubleObj = Double.valueOf(3.14);

        // Convert integerObj and doubleObj to primitive values
        int intValue = integerObj.intValue();
        double doubleValue = doubleObj.doubleValue();

        // Display the primitive values
        System.out.println("intValue: " + intValue);
        System.out.println("doubleValue: " + doubleValue);

        // Convert strings to primitive values
        String intString = "123";
        String boolString = "true";

        int parsedInt = Integer.parseInt(intString);
        boolean parsedBool = Boolean.parseBoolean(boolString);

        // Display the parsed primitive values
        System.out.println("parsedInt: " + parsedInt);
        System.out.println("parsedBool: " + parsedBool);
    }
}
