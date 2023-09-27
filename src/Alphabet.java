import java.util.Arrays;

public class Alphabet {

    public static char[] getRUSSIAN_ALPHABET() {
        return RUSSIAN_ALPHABET;
    }

    private static final char[] RUSSIAN_ALPHABET = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
            'З', 'И', 'Й', 'К', 'Л', 'М',
            'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

     static String fromAlphabet = getRUSSIAN_ALPHABET().toString();

    /*изначально хотела работать только с массивом, но не знала каким образом сравнивать элементы массива с массивом символов,
    полученных из файла пользователя; пришлось искать решение в интернетах, там делали через строку, поэтому сделала строку */
}