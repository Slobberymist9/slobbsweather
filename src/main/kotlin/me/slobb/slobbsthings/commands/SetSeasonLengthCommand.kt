package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsThings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SetSeasonLengthCommand(val slobbsThings: SlobbsThings) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsThings.config
        if (args.size != 1) {
            sender.sendPlainMessage("You need to specify how long you want this season to be!")
            return false
        }
        if (args.size == 1 && sender.isOp) {
            val length = args[0]
            if (length.toInt() > 0 && length.toInt() < 1000) {
                config.set("season-length", length.toInt())
                sender.sendPlainMessage("Each season length is now $length days long!")
                slobbsThings.saveConfig()
            } else if (length.toInt() < 0 || length.toInt() > 1000 && sender.isOp) {
                sender.sendPlainMessage("Please enter a number greater than 0 or less than 1000!")
            } else {
                sender.sendPlainMessage("You are not allowed to run this command!")
            }
        }
        return false
    }
}