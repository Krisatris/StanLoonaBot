/**
 * testing on how to build a basic discord bot
 * to annoy all of my friends with
 */

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "";
        try {
            Scanner tokenFile = new Scanner(new File("C:\\Users\\stell\\Desktop\\Java\\Hell\\bot-token.txt"));
            token = tokenFile.next();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());
        if(event.getMessage().getContentRaw().equals("!test")) {
            event.getChannel().sendMessage("stan loona").queue();
        }
    }
}
