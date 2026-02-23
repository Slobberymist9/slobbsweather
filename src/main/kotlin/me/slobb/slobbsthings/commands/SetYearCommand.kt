package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsWeather
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SetYearCommand(val slobbsWeather: SlobbsWeather) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsWeather.config
        if (args.size != 1) {
            sender.sendPlainMessage("You need to specify a season to change it to. (Spring, Summer, Fall, Winter")
            return false
        }
        if (args.size == 1 && sender.isOp) {
            val year = args[0]
            if (year.toInt() > 0 && year.toInt() < 999999) {
                config.set("year", year.toInt())
                sender.sendPlainMessage("It is now year $year!")
                slobbsWeather.saveConfig()
            } else {
                sender.sendPlainMessage("You are not allowed to run this command!")
            }
        }
        return false
    }
}