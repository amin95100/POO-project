package cli;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author SMARA Zakarie et DACOSTA Léa
 *
 */
public class PlaylistMaker {

	/**
	 * Genere une playlist par default de type "xspf"  contenant l’ensemble des fichiers MP3 du répertoire exploré. 
	 * @param mp3Files
	 * @param playlistName
	 * @return
	 * @throws IOException
	 */
	public String mp3PlaylistMaker(ArrayList<String> mp3Files,String playlistName) throws IOException {
		
		String playlist = new String(); 
		playlist += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		playlist += "\t<playlist version=\"1\" xmlns = \"http://xspf.org/ns/0/\"> \n";
		playlist +=  "\t\t<trackList>\n";
		
		for (Iterator iterator = mp3Files.iterator(); iterator.hasNext();) {
			String mp3Path = (String) iterator.next();
			playlist += "\t\t\t<track><location>"+mp3Path+"</location></track>\n";
		}		
		playlist +=  "\t\t</trackList>\n";
		playlist += "\t</playlist>";
		
		BufferedWriter  bufferedWriter = new BufferedWriter (new FileWriter("./"+playlistName));
		bufferedWriter.write(playlist);
	    bufferedWriter.close();
		return playlist;
	}
	
	
}
