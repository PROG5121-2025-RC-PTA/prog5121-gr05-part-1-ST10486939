
package poepart1;

import java.util.regex.Pattern;

public class Login {
    private static boolean checkUserName(String username){
        return username.length() <=5 && username.contains("_");
    }
    
    private static boolean checkPasswordComplexity(String password) {
        return password.length() >=8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[0-9]").matcher(password).find() &&
                Pattern.compile("[!@#$%^&*()]").matcher(password).find();
    }
    
    private static boolean checkCellPhoneNumber(String cellphone) {
        if(!cellphone.startsWith("+")) return false;
        String[] parts = cellphone.split("\\+",2);
        if(parts.length<2) return false;
        String number = parts[1].replace("[^0-9]", "");
        return number.length() <= 13 && number.length() >10;
    }
    
    private static void registerUser(String username, String password) {
     
        if(!checkUserName(username)) {
            System.out.println("username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no more than five characters in length.");
        } else if(!checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains "
                    + "at least eight charcaters, a capital letter, a number, and a special character.");          
        } else { 
            System.out.println("Registered successfully");
        }
       
    }
}
