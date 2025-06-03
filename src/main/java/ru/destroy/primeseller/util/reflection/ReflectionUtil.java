package ru.destroy.primeseller.util.reflection;

import org.bukkit.Bukkit;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import ru.destroy.primeseller.PrimeSeller;

import java.util.Set;
import java.util.function.Consumer;

public class ReflectionUtil {

    public ReflectionUtil() {

    }

    /**
     *
     * @param packageName
     * @param baseType
     * @param registerCode
     * @param <T>
     */
    public static <T> void registerAnnotation(String packageName,
                                       Class<T> baseType,
                                       Consumer<Class<? extends T>> registerCode) {

        String mainPackage = "ru.destroy.primeseller.";

        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage(mainPackage + packageName,
                                PrimeSeller.class.getClassLoader()))
                        .setScanners(Scanners.SubTypes)
        );

        Set<Class<? extends T>> classes = reflections.getSubTypesOf(baseType);

        for (Class<? extends T> classToRegister : classes) {
            registerCode.accept(classToRegister);
        }
    }

}
