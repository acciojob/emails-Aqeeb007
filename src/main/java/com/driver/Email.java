package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals("Accio@123") && newPassword.length() == 8){
            if(newPassword.contains("1") || newPassword.contains("2") || newPassword.contains("3") ||
                    newPassword.contains("4") || newPassword.contains("5") || newPassword.contains("6") ||
                    newPassword.contains("7") || newPassword.contains("8") || newPassword.contains("9") ||
                    newPassword.contains("0")){
                if (newPassword.contains("@") || newPassword.contains("#")
                        || newPassword.contains("!") || newPassword.contains("~")
                        || newPassword.contains("$") || newPassword.contains("%")
                        || newPassword.contains("^") || newPassword.contains("&")
                        || newPassword.contains("*") || newPassword.contains("(")
                        || newPassword.contains(")") || newPassword.contains("-")
                        || newPassword.contains("+") || newPassword.contains("/")
                        || newPassword.contains(":") || newPassword.contains(".")
                        || newPassword.contains(", ") || newPassword.contains("<")
                        || newPassword.contains(">") || newPassword.contains("?")
                        || newPassword.contains("|")){
                    for (int i = 0; i < 8; i++) {
                        if(newPassword.charAt(i) >= 'a' || newPassword.charAt(i) <= 'z' || newPassword.charAt(i) >= 'A' || newPassword.charAt(i) >= 'Z'){

                        }
                    }
                }
            }
        }
    }
}
