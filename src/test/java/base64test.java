import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class base64test {
    public static void main(String[] args) {
        String url = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTllOTIzZjEyYmRhNTEwNTI4NzlmZDRmNTMyMThmYWE1ZmMxMWNjYTYwNjJkMmFkMzRlZGJkMjExOWVmOGI1YiJ9fX0=";

        String base64 = new String(Base64.getDecoder().decode(url));

        System.out.println(base64);

    }
}
