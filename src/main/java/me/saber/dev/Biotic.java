package me.saber.dev;

import me.saber.dev.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Biotic extends JavaPlugin {

    public static Biotic instance;
    public static HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();


    public static Biotic getInstance(){
        return instance;
    }

    @Override
    public void onEnable(){
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerListeners();
        
    }

    private void registerListeners() {
        Util.getClassesInPackage(this, "me.saber.dev.listeners").stream().filter(Listener.class::isAssignableFrom).forEach(clazz -> {
            try {
                Bukkit.getPluginManager().registerEvents((Listener) clazz.newInstance(), this);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
