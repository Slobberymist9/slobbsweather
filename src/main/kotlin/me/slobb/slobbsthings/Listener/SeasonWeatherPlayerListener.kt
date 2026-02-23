package me.slobb.slobbsthings.Listener

import me.slobb.slobbsthings.SlobbsWeather
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent


class SeasonWeatherPlayerListener(val slobbsWeather: SlobbsWeather) : Listener {

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val config = slobbsWeather.config
        val season = config.get("season")
        val day = config.get("day")
        val year = config.get("year")
        e.player.sendMessage(Component.text("Welcome back! It is currently day $day of $season, year $year!").color(NamedTextColor.GOLD))
    }

}