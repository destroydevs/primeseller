package ru.spigotmc.destroy.primeseller.configurations.database;

import com.google.gson.annotations.SerializedName;

public class SkinData {

    @SerializedName("textures")
    Textures textures;

    public Textures getTextures() {
        return textures;
    }

    public static class Textures {
        @SerializedName("SKIN")
        Skin skin;

        public Skin getSkin() {
            return skin;
        }
    }

    public static class Skin {
        @SerializedName("url")
        String url;

        public String getUrl() {
            return url;
        }
    }
}
