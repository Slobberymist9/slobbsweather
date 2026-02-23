package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsThings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
//https://www.youtube.com/watch?v=axu3grVq3m0&list=PL3Cdwhu_4crm-taHKMt9PDZ0zQn5U6o-y&index=6
class ToggleDayWeatherCommand(val slobbsThings: SlobbsThings) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsThings.config
        if (args.size != 1) {
            sender.sendPlainMessage("Type true or false if you want to disable or enable daytime weather events.")
            return false
        }
        if (args.size == 1 && sender.isOp) {
            val toggle = args[0]
            if (toggle.equals("true") && sender.isOp) {
                config.set("day-weather", true)
                sender.sendPlainMessage("Day weather enabled")
                slobbsThings.saveConfig()
            } else if (toggle.equals("false") && sender.isOp) {
                config.set("day-weather", false)
                sender.sendPlainMessage("Day weather disabled")
                slobbsThings.saveConfig()
            } else {
                sender.sendPlainMessage("You are not allowed to run this command!")
            }
        }
        return false
    }
}