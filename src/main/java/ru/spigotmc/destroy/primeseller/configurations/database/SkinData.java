package ru.spigotmc.destroy.primeseller.configurations.database;

import com.google.gson.annotations.SerializedName;

public class SkinData {

    @SerializedName("textures")
    Skin textures;

    public Skin getTextures() {
        return textures;
    }

    public static class Skin {
        @SerializedName("url")
        String url;

        public String getUrl() {
            return url;
        }
    }
}
