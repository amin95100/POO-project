package gui;


import com.beaglebuddy.mp3.MP3;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




	/**
	 *
	 * @author SMARA Zakarie et DACOSTA Léa
	 *
	 */
	public class MP3DataExtractorGui{


		/**Retourne les métadonnées d'un fichier mp3
		 * @param path
		 * @return
		 */
		public String mp3DataExtractorGui(String path) {
					String text = new String()	;
			 try {
		         MP3 mp3 = new MP3(path);
	
		       
		                      text ="audio duration.....: " + mp3.getAudioDuration()                  + " s<br/>"      +
		                            "audio size.........: " + mp3.getAudioSize()                      + " bytes<br/>"  +
		                            "album..............: " + mp3.getAlbum()                          + "<br/>"        +
		                            "artist.............: " + mp3.getBand()                           + "<br/>"        +
		                            "contributing artist: " + mp3.getLeadPerformer()                  + "<br/>"        +
		                            "lyrics by..........: " + mp3.getLyricsBy()                       + "<br/>"        +
		                            "music by...........: " + mp3.getMusicBy()                        + "<br/>"        +
		                            
		                            "publisher..........: " + mp3.getPublisher()                      + "<br/>"        +
		                            "rating.............: " + mp3.getRating()                         + "<br/>"        +
		                            "title..............: " + mp3.getTitle()                          + "<br/>"        +
		                            "track #............: " + mp3.getTrack()                          + "<br/>"        +
		                            "year recorded......: " + mp3.getYear()                           + "<br/>"        +
		                            "lyrics.............: " + mp3.getLyrics()                         + "<br/>";
	             
	             
		         }
		         catch (IOException ex)
		         {
		            System.out.println("An error occurred while reading/saving the mp3 file.");
		            ex.printStackTrace();
		         }
         return text;
		}

	}
	
	
