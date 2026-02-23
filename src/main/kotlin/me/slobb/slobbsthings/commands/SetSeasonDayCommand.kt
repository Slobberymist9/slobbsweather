package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsThings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SetSeasonDayCommand(val slobbsThings: SlobbsThings) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsThings.config
        if (args.size != 1) {
            sender.sendPlainMessage("Please enter a whole number.")
            return false
        }
        if (args.size == 1 && sender.isOp) {
            val days = args[0]
            val length = config.getInt("season-length")
            if (days.toInt() > 0 && days.toInt() < config.getInt("season-length") && sender.isOp) {
                config.set("day", days.toInt())
                sender.sendPlainMessage("Set the season day to day $days out of $length for this season.")
                slobbsThings.saveConfig()
            } else if (days.toInt() < 0 && sender.isOp || days.toInt() > config.getInt("season-length") && sender.isOp) {
                sender.sendPlainMessage("Please enter a number greater than 0, or make sure the number you entered is less than the current season length, which is at $length days long!")
                return false
            } else {
                sender.sendPlainMessage("You are not allowed to run this command!")
            }
        }
        return false
    }
}