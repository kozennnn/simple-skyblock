package fr.kozen.skyrama.objects.grids;

import fr.kozen.skyrama.Skyrama;
import fr.kozen.skyrama.objects.islands.Island;
import fr.kozen.skyrama.objects.islands.IslandDao;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GridManager {

    public GridManager() { this.initialise(); }

    public void initialise() {



    }

    public Location getCenterFromId(int id) {

        int x = (id*769);
        int z = (int) (Math.floor(x / 384500)*769);

        return new Location(Bukkit.getWorld("world"), x, 100, z);

    }

    public boolean isInPlayerIsland(Player player, Location location) {

        if(location.getWorld() == Bukkit.getWorld((String) Skyrama.getPlugin(Skyrama.class).getConfig().get("general.world"))) {
            Island island = Skyrama.getIslandManager().getPlayerIsland(player);
            Location center = getCenterFromId(island.getId());

            int minX = center.getBlockX() - 256;
            int maxX = center.getBlockX() + 256;

            int minZ = center.getBlockZ() - 256;
            int maxZ = center.getBlockZ() + 256;

            if (location.getBlockX() >= minX && location.getBlockX() <= maxX) {
                return location.getBlockZ() >= minZ && location.getBlockZ() <= maxZ;
            }
            return false;
        }
        return false;


    }

}
