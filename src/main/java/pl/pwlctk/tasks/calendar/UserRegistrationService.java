package pl.pwlctk.tasks.calendar;

import pl.pwlctk.tasks.calendar.tools.EmailValidation;
import pl.pwlctk.tasks.calendar.tools.Input;

public class UserRegistrationService {
    private Member logInUser;

    UserRegistrationService() {
        logInUser = logIn();
    }

    private Member logIn() {
        System.out.print("Podaj imię: ");
        String name = Input.in.nextLine();
        System.out.println("Podaj email (example@example.com):");
        EmailValidation emailValidation = new EmailValidation();
        String email = emailValidation.enterEmail();

        return new Member(name, email);
    }

    public Member getLogInUser() {
        return logInUser;
    }
}

