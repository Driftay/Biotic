package me.saber.dev.handler;

import me.saber.dev.Biotic;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.Objects;
import java.util.UUID;

import static me.saber.dev.Biotic.playerPermissions;

public class PermissionHandler {

    public static void setupPermissions(Player player) {
        PermissionAttachment attachment = player.addAttachment(Biotic.getInstance());
        playerPermissions.put(player.getUniqueId(), attachment);
        permissionsSetter(player.getUniqueId());
    }

    public static void permissionsSetter(UUID uuid) {
        PermissionAttachment attachment = playerPermissions.get(uuid);
        for (String groups : Objects.requireNonNull(Biotic.getInstance().getConfig().getConfigurationSection("Groups")).getKeys(false)) {
            for (String permissions : Biotic.getInstance().getConfig().getStringList("Groups." + groups + ".permissions")) {
                attachment.setPermission(permissions, true);
            }
        }
    }
}
