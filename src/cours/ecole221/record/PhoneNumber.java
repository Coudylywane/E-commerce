package cours.ecole221.record;

import cours.ecole221.exeptions.InvalidPhoneNumberException;

public record PhoneNumber(String value) {

    public PhoneNumber {
        if (value == null || !isValidNumber(value)) {
            throw new InvalidPhoneNumberException(
                    "Numéro invalide"
            );
        }
    }

    private static boolean isValidNumber(String number) {
        String regex =
                "^(\\+221)?(77|78|70|76)[0-9]{7}$";

        return number.matches(regex);
    }
}
