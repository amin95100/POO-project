package cli;

import com.beaglebuddy.mp3.MP3;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.beaglebuddy.id3.enums.PictureType;


 /**
 * @author SMARA Zakarie et DACOSTA Léa
 *
 */
class MP3DataExtractor{


		/**
		 * Affiche les métadonnées d'un ficjier mp3
		 * @param path
		 */
		public void mp3DataExtractor(String path) {
						
			 try {
		         MP3 mp3 = new MP3(path);
	
		       
		         System.out.println("audio duration.....: " + mp3.getAudioDuration()                  + " s\n"      +
		                            "audio size.........: " + mp3.getAudioSize()                      + " bytes\n"  +
		                            "album..............: " + mp3.getAlbum()                          + "\n"        +
		                            "artist.............: " + mp3.getBand()                           + "\n"        +
		                            "contributing artist: " + mp3.getLeadPerformer()                  + "\n"        +
		                            "lyrics by..........: " + mp3.getLyricsBy()                       + "\n"        +
		                            "music by...........: " + mp3.getMusicBy()                        + "\n"        +
		                            "picture............: " + mp3.getPicture(PictureType.FRONT_COVER) + "\n"        +
		                            "publisher..........: " + mp3.getPublisher()                      + "\n"        +
		                            "rating.............: " + mp3.getRating()                         + "\n"        +
		                            "title..............: " + mp3.getTitle()                          + "\n"        +
		                            "track #............: " + mp3.getTrack()                          + "\n"        +
		                            "year recorded......: " + mp3.getYear()                           + "\n"        +
		                            "lyrics.............: " + mp3.getLyrics()                         + "\n");
	
		         }
		         catch (IOException ex)
		         {
		            System.out.println("An error occurred while reading/saving the mp3 file.");
		            ex.printStackTrace();
		         }

		}

	}