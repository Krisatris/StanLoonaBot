import javafx.scene.media.AudioTrack;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

/**
 * dedicated class for printing lyrics in chat
 * based on timing in songs
 */

public class MusicPrint {

    AudioTrack song;

    VoiceChannel voiceChannel;

    public MusicPrint() {
        song = null;
        voiceChannel = null;
    }

    public void startPlaying(MessageReceivedEvent event) {
        voiceChannel = event.getGuild().getVoiceChannelsByName("General", true).get(0);
        AudioManager audioManager = event.getGuild().getAudioManager();
        audioManager.openAudioConnection(voiceChannel);
    }

    public void leaveVoice(MessageReceivedEvent event) {
        AudioManager audioManager = event.getGuild().getAudioManager();
        audioManager.closeAudioConnection();
    }
}
