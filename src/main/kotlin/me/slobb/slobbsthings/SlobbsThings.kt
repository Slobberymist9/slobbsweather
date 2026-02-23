package me.slobb.slobbsthings

import me.slobb.slobbsthings.commands.SetSeasonCommand
import me.slobb.slobbsthings.commands.SetSeasonDayCommand
import me.slobb.slobbsthings.commands.SetYearCommand
import me.slobb.slobbsthings.commands.ToggleDayWeatherCommand
import me.slobb.slobbsthings.commands.ToggleNightWeatherCommand
import me.slobb.slobbsthings.commands.SetSeasonLengthCommand
import org.bukkit.plugin.java.JavaPlugin

class SlobbsThings : JavaPlugin() {
//https://www.youtube.com/watch?v=zGFR6G9FHLk&list=PL3Cdwhu_4crm-taHKMt9PDZ0zQn5U6o-y&index=2
    //githiub commit
    override fun onEnable() {
        println("SlobbsThings is now loading...")
        saveDefaultConfig()

        getCommand("setseason")!!.setExecutor(SetSeasonCommand(this))
        getCommand("setseasonday")!!.setExecutor(SetSeasonDayCommand(this))
        getCommand("setseasonlength")!!.setExecutor(SetSeasonLengthCommand(this))
        getCommand("setyear")!!.setExecutor(SetYearCommand(this))
        getCommand("toggledayweather")!!.setExecutor(ToggleDayWeatherCommand(this))
        getCommand("togglenightweather")!!.setExecutor(ToggleNightWeatherCommand(this))
        println("SlobbsThings is now enabled! KILL THEM ALL! ---------------------------------------")

    }
}