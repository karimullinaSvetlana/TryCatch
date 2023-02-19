public class Main {
    public static void main(String[] args) {
        System.out.println(Main.check("fk_12", "pas_12","pas_12"));
    }
    public static boolean check(String login, String password, String confirmPassword){
        String[] letters = {"a","b","c","d","e","f","g","h","i","k","l","m","n","o","p","q","s","t","u","v","w","x","y","z"};
        String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
        int n = 0;
        int len = login.length();
        int n1 = 0;
        int len1 = password.length();
        try {
            for (String letters1 : letters) {
                if (login.contains(letters1)) n += 1;
                if (password.contains(letters1)) n1 += 1;
            }
            if (n == 0) throw new WrongLoginException();
            if (n1 == 0) throw new WrongPasswordException();
            n = 0;
            n1 = 0;
            for (String numbers1 : numbers) {
                if (login.contains(numbers1)) n += 1;
                if (password.contains(numbers1)) n1 += 1;
            }
            if ((n == 0) | (!login.contains("_")) | (len > 20)) throw new WrongLoginException("Неверный логин");
            if ((n1 == 0) | (!password.contains("_")) | (len1 > 20) | (!password.equals(confirmPassword))) throw new WrongPasswordException("Неверный пароль");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}