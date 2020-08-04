package de.marvinleiers.gameapi.listeners;

import de.marvinleiers.gameapi.GameAPI;
import de.marvinleiers.gameapi.events.PlayerInGameItemInteractEvent;
import de.marvinleiers.gameapi.events.PlayerInLobbyItemInteractEvent;
import de.marvinleiers.gameapi.game.Game;
import de.marvinleiers.gameapi.game.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class GameListener implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();

        if (GameAPI.gameplayers.containsKey(player))
        {
            Game game = GameAPI.gameplayers.get(player).getGame();
            game.leave(player);
        }
    }

    @EventHandler
    public void onItemInteract(PlayerInteractEvent event)
    {
        if (!event.hasItem())
            return;

        ItemStack item = event.getItem();

        Player player = event.getPlayer();

        if (!GameAPI.inGame(player))
            return;

        GamePlayer gp = GameAPI.gameplayers.get(player);
        Game game = gp.getGame();

        event.setCancelled(true);

        if (!game.inLobby())
        {
            Bukkit.getPluginManager().callEvent(new PlayerInGameItemInteractEvent(game, player, item));
        }
        else
        {
            Bukkit.getPluginManager().callEvent(new PlayerInLobbyItemInteractEvent(game, player, item));
        }
    }
}
