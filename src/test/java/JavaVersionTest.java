public class JavaVersionTest {
    public static void main(String[] args) {
        checkJavaVersion();
    }
    private static void checkJavaVersion() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("Running on Java version: " + javaVersion);

        if (isJavaVersionSupported(javaVersion)) {
            System.out.println("Java version is supported.");
        }
    }

    private static boolean isJavaVersionSupported(String javaVersion) {
        int version = extractMajorVersion(javaVersion);
        return version >= 11;
    }

    private static int extractMajorVersion(String javaVersion) {
        if (javaVersion.startsWith("1.")) {
            javaVersion = javaVersion.substring(2);
        }
        int dotIndex = javaVersion.indexOf('.');
        if (dotIndex != -1) {
            javaVersion = javaVersion.substring(0, dotIndex);
        }
        return Integer.parseInt(javaVersion);
    }
}
