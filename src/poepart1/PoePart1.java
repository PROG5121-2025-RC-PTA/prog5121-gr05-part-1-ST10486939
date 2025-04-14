package poepart1;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class PoePart1 {
    
   
            
    //GUI components
    private static JLabel heading, usernameLabel, passwordLabel, cellphoneLabel;
    private static JTextField usernameText, cellphoneText;
    private static JPasswordField passwordText;
    private static JButton register, login;
    
    //registered user data
    private static String registeredUsername = null;
    private static String registeredPassword = null; 
    private static String registeredCellphone = null;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400,600);
        frame.setTitle("Registration and Login.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        
        panel.setLayout(null);
        panel.setBackground(new Color(207,204,188));
        
        //heading
        heading = new JLabel("Register or Login");
        heading.setBounds(80,10,250,40);
        heading.setFont(new Font("Serif", Font.BOLD, 28));
        panel.add(heading);
        
        
        //username label and textfield
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(30,70,150,25);
        usernameLabel.setFont(new Font("Serif", Font.BOLD,18));
        panel.add(usernameLabel);
        
        usernameText = new JTextField();
        usernameText.setBounds(30,100,300,30);
        panel.add(usernameText);
        
        
        //password label and passwordfield 
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(30,170,150,25);
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(30,200,300,30);
        panel.add(passwordText);
        
        
        //cellphone label and textfield 
        cellphoneLabel = new JLabel("Cellphone no.");
        cellphoneLabel.setBounds(30,270,150,25);
        cellphoneLabel.setFont(new Font("Serif", Font.BOLD,18));
        panel.add(cellphoneLabel);
        
        cellphoneText = new JTextField();
        cellphoneText.setBounds(30,300,300,30);
        panel.add(cellphoneText);
        
        
        //register and login buttons
        register = new JButton("Register");
        register.setBounds(30,370,140,50);
        panel.add(register);
        
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                handleRegistration();
                }
        });
        
        login = new JButton("Login");
        login.setBounds(200,370,140,50);
        panel.add(login);
        
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            handleLogin();
            }
        });
        
    }
    
    //handle registration
    private static void handleRegistration() {
        String username = usernameText.getText();
        String password = new String(passwordText.getPassword());
        String cellphone = cellphoneText.getText();
        
        if(!validUsername(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.");
        } else if(!validPassword(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password "
                    + "contains atleast eight characters, a capital letter, a number, and a special character.");          
        } else if(!validPhoneNumber(cellphone)) {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code.");
        } else {
            registeredUsername = username;
            registeredPassword = password;
            registeredCellphone = cellphone;
            System.out.println("Registered successfully");
        }
    }
    
    
    //handle login
    private static void handleLogin() {
        String username = usernameText.getText().trim();
        String password = new String(passwordText.getPassword());
        
        if(registeredUsername == null || registeredPassword == null) {
            System.out.println("Username or password incorrect, please try again.");
        } else if(!username.equals(registeredUsername)){
            System.out.println("Username or password incorect, please try again.");
        } else if(!password.equals(registeredPassword)) {
            System.out.println("Username or password incoprrect, please try again");
        } else {
            System.out.println("Welcome " +registeredUsername+ ", it is great to see you again.");
        }
    }
    
    //username validation
    private static boolean validUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
    
    //password validation 
    private static boolean validPassword(String password) {
        return password.length() >=8 &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[0-9]").matcher(password).find() &&
                Pattern.compile("[!@#$%^&*()]").matcher(password).find();
    }
    
    //cellphone number validation
    private static boolean validPhoneNumber(String cellphone) {
        if(!cellphone.startsWith("+")) return false;
        String[] parts = cellphone.split("\\+",2);
        if(parts.length<2) return false;
        String number = parts[1].replace("[^0-9]", "");
        return number.length() <= 13 && number.length() >10;
    }
    
}