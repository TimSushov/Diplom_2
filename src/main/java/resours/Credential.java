package resours;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credential {
    public static final String EMAIL = "Pushok" + new Random().nextInt(999) + "-data@yandex.ru";
    public static final String PASSWORD = "12345" + new Random().nextInt(999);
    public static final String NAME = "Pushok" + new Random().nextInt(999);
    public static final String RANDOM = String.valueOf(new Random().nextInt(999));
}
