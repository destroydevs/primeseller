package ru.spigotmc.destroy.primeseller.entity;

public class User {
    private boolean isAutoBuyEnabled;
    private final int userLimit;

    public User(boolean isAutoBuyEnabled, int userLimit) {
        this.isAutoBuyEnabled = isAutoBuyEnabled;
        this.userLimit = userLimit;
    }

    public void setAutoBuyEnabled(boolean autoBuyEnabled) {
        isAutoBuyEnabled = autoBuyEnabled;
    }

    public boolean isAutoBuyEnabled() {
        return isAutoBuyEnabled;
    }

    public int getUserLimit() {
        return userLimit;
    }
}
