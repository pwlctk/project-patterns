package pl.pwlctk.tasks.calendar.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public String enterEmail() {
        String email;
        do {
            email = Input.in.nextLine();
            if(!validate(email)){
                System.out.println("Podano niepoprawny email!");
                System.out.println("Podaj email (example@example.com):");
            }
        } while (!validate(email));

        return email;
    }
}

