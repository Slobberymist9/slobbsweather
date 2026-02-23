package me.slobb.slobbsthings.Listener

import me.slobb.slobbsthings.SlobbsWeather
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.WeatherEvent

class WeatherEventListener(val slobbsWeather: SlobbsWeather) : Listener {
    @EventHandler
    fun onWeatherEvent(event: WeatherEvent) {
        //Bukkit.getScheduler().runTaskLater(slobbsWeather, Runnable {}, 200L)
        /* notes for after work, maybe when 1 player joins we run the script, detect the current saved time and weather, apply those affects, then work from there */
    }
}