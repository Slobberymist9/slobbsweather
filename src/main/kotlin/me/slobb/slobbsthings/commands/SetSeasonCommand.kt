package me.slobb.slobbsthings.commands

import me.slobb.slobbsthings.SlobbsThings
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.util.Locale

class SetSeasonCommand(val slobbsThings: SlobbsThings) : CommandExecutor {
    /*
    bs for me since i suck at coding:
    setseason (Sp Su F W)
    literally only sets the season and nothing else

    /setseason <season>

     */

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val config = slobbsThings.config
        if (args.size != 1) {
            sender.sendPlainMessage("You need to specify a season to change it to. (Spring, Summer, Fall, Winter")
            return false
        }
            if (args.size == 1 && sender.isOp) {
                val season = args[0] //nots for myself this is grabbing the <season> argument
                if (season.equals("Spring", ignoreCase = true) || season.equals("Summer", ignoreCase = true) || season.equals("Fall", ignoreCase = true) || season.equals("Winter", ignoreCase = true)) {
                sender.sendPlainMessage("You have changed the season to ${season.uppercase(Locale.getDefault())}.")
                config.set("season", season.lowercase(Locale.getDefault()))
                return false
            } else if (!season.equals("Spring", ignoreCase = true) && !season.equals("Summer", ignoreCase = true) && !season.equals("Fall", ignoreCase = true) && !season.equals("Winter", ignoreCase = true)) {
                sender.sendPlainMessage("Invalid season, make sure its one of the four main seasons.")
                    return false
            } else {
                sender.sendPlainMessage("You are not allowed to run this command!")
                }
        }
        return false
    }
}