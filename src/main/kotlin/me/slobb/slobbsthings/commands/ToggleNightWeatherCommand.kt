package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsThings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ToggleNightWeatherCommand(val slobbsThings: SlobbsThings) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsThings.config
        if (args.size != 1) {
            sender.sendPlainMessage("Type true or false if you want to disable or enable nighttime weather events.")
            return false
        }
        if (args.size == 1 && sender.isOp) {
            val toggle = args[0]
            if (toggle.equals("true") && sender.isOp) {
                config.set("night-weather", true)
                sender.sendPlainMessage("Night weather enabled")
                slobbsThings.saveConfig()
            } else if (toggle.equals("false") && sender.isOp) {
                config.set("night-weather", false)
                sender.sendPlainMessage("Night weather disabled")
                slobbsThings.saveConfig()
            } else {
                sender.sendPlainMessage("Please enter only true or false")
            }
        }
        return false
    }
}