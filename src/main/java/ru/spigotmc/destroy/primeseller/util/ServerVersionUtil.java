package ru.spigotmc.destroy.primeseller.util;

import org.bukkit.Bukkit;

public class ServerVersionUtil {
    private static String getVersion() {
        return Bukkit.getBukkitVersion()
                .replace("-", "")
                .replace("R0.1", "")
                .replace("SNAPSHOT", "");
    }

    public static ServerVersion getServerVersion() {
        String version = getVersion();
        String[] parts = version.split("\\.");
        int major = Integer.parseInt(parts[0]);
        int minor = Integer.parseInt(parts[1]);
        int patch = 0;
        try {
            patch = Integer.parseInt(parts[2]);
        } catch (NullPointerException e) {}

        return new ServerVersion(major,minor,patch);
    }

    public static class ServerVersion {
        private final int major;
        private final int minor;
        private final int patch;

        public ServerVersion(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }

        public int getMajor() {
            return major;
        }

        public int getMinor() {
            return minor;
        }

        public int getPatch() {
            return patch;
        }
    }
}
