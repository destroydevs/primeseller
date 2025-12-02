package me.byteswing.primeseller;

public class JavaChecker {
    public static void checkJavaVersion(Runnable supported, Runnable unsupported) {
        String javaVersion = System.getProperty("java.version");

        if (isJavaVersionSupported(javaVersion)) {
            supported.run();
        } else {
            unsupported.run();
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
