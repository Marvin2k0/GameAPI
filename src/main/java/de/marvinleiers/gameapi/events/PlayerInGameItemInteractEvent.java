package de.marvinleiers.gameapi.events;

import de.marvinleiers.gameapi.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerInGameItemInteractEvent extends PlayerGameEvent
{
    private ItemStack item;

    public PlayerInGameItemInteractEvent(Game game, Player who, ItemStack item)
    {
        super(game, who);

        this.item = item;
    }

    public ItemStack getItem()
    {
        return item;
    }
}
