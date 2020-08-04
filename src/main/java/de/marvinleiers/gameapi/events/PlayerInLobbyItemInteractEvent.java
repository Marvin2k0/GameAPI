package de.marvinleiers.gameapi.events;

import de.marvinleiers.gameapi.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerInLobbyItemInteractEvent extends PlayerGameEvent
{
    private ItemStack item;

    public PlayerInLobbyItemInteractEvent(Game game, Player who, ItemStack item)
    {
        super(game, who);

        this.item = item;
    }

    public ItemStack getItem()
    {
        return item;
    }
}
