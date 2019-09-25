import java.util.Scanner;
import java.lang.String;

public class User {
    static Scanner scanner = new Scanner(System.in);
    private String userName;
    private String companyName;
    private int year;
    private String userEmail;
    private String password;




    public String getCompanyName() {
        return companyName;
    }

    public int getYear() {
        return year;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void User(String userName, String companyName, int year) {
        this.userName = userName;
        this.companyName = companyName;
        this.year = year;
        this.userEmail = createUserEmail();
        this.password = createUserPassword();
    }
    public String getUserName() {
        return userName;
    }

    private int generateRandomIntergerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }

    private char generateRandomCharacter() {
        return (char) ('a' + generateRandomIntergerFromLimit(26));
    }

    private String getFirst5CharactersFromUserName() {
        if (getUserName().length() < 5) {
            StringBuilder pass = new StringBuilder();
            int difference = 5 - getUserName().length();
            pass.append(userName);
            pass.append("0".repeat(Math.max(0, difference)));
            return pass.toString();
        } else {
            return getUserName().substring(0, 5);
        }
    }

    private char getRandomSpecialSymbols() {
        char[] specialSymbols = {
                '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '{', '}', '[', ']', '|', '\\',
                '\'', '\"', ':', ';', ',', '<', '>', '.', '?', '/' };
        int randomNumber = generateRandomIntergerFromLimit(specialSymbols.length);
        return specialSymbols[randomNumber];
    }  //The Last Character of the password i.e., the 11th character is supposed to be a special character.

    private String createUserPassword() {
        StringBuilder pass = new StringBuilder();
        pass.append(generateRandomCharacter()); //1
        for (int i = 0; i < 4; i++) {
            pass.append(generateRandomIntergerFromLimit(10)); //2,3,4,5
        }
        pass.append(getFirst5CharactersFromUserName());  //6,7,8,9,10
        pass.append(getRandomSpecialSymbols()); //11
        return pass.toString();
    }

    private String createUserEmail() {
        return String.format("%s_%d@%s.com",
                getUserName().toLowerCase(),
                getYear(), getCompanyName().toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println("Please Enter Your Details to generate company Email Id and Password :- \n");
        User details = new User();
        System.out.print("Please Enter Username - ");
        details.userName = scanner.nextLine();
        System.out.print("Please Enter Company Name - ");
        details.companyName = scanner.nextLine();
        System.out.print("Please Enter Date of Joining - ");
        details.year = scanner.nextInt();
        System.out.println(details.createUserEmail() + "\n" + details.createUserPassword());
    }

}
