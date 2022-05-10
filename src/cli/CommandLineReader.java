package cli;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CommandLineReader {

	
	public static void main(String[] args) throws IOException {
		

//		String filePaths = "../../";
		
//			mp3Files = pathexplorer.explorePath(filePaths, "mp3", "audio/mpeg");
//
//			// Display the content of mp3Files
//			for (Iterator iterator = mp3Files.iterator(); iterator.hasNext();) {
//				String mp3Path = (String) iterator.next();
//				// Display the path of the mp3 file
//				System.out.println(mp3Path);
//				System.out.println();
//				// Extract the data of the mp3 file and displays it
////				dataExtractor.mp3DataExtractor(mp3Path);				
////				System.out.println();
//			}				
//			
//			// Make a playlist and displays it
//			String playlist = playlistmaker.mp3PlaylistMaker(mp3Files);
//			System.out.println(playlist);
		
		if (args.length > 0 ) 
		{
			System.out.println(args[0]);
			switch (args[0]) {
				case "-h":
				System.out.println("java -jar cli.jar -f file.mp3 :\n "
						+ "Afficher les métadonnées dans fichie mp3\n"+
				 "java -jar cli.jar -d /directory : \n"
				 + "Parcourrir l’ensemble de l’arborescence des sous-dossiers\n"+
				 "java -jar cli.jar -d ./diretory/ -o playlists.xspf: \n"
				 + "Prends en entrée  le sous-dossier ' ./directory/ ' du répertoire courant et sauvegarde la playlist générée dans le fichier xspf spécifié\n"+
				 "java -jar gui.jar : \n"
				 + "Lancer l'interface graphique ");
					break;

				case "-d": 
					ArrayList<String> mp3Files;
					if (args.length == 2) {
						// Explore the mp3 files from a path
						PathExplorer pathexplorer = new PathExplorer();
						System.out.println(pathexplorer.explorePath(args[1], "mp3", "audio/mpeg"));				
					} else if (args.length == 4) {
						if(args[2].equals("-o") && args[3].substring(args[3].lastIndexOf(".")+1).toLowerCase().equals("xspf") ){
						// Generate the xspf
						PathExplorer pathexplorer = new PathExplorer();		
						ArrayList<String> mp3Paths = pathexplorer.explorePath(args[1], "mp3", "audio/mpeg");
						PlaylistMaker playlistmaker = new PlaylistMaker();
						// TODO Make an xspf file
						System.out.println(playlistmaker.mp3PlaylistMaker(mp3Paths,args[3]));					
						}
						else {
							System.out.println( "Respecter le format : java -jar cli.jar -d ./music/ -o playlist.xspf .Tapez java -jar cli.jar -h pour de l'aide.");	
						}
					}
					
					break;
					
				case "-f" :
					MP3DataExtractor dataExtractor = new MP3DataExtractor();
					if (args[1] != null) {
						dataExtractor.mp3DataExtractor(args[1]);					
					} 
					break;
					
				default:
					System.out.println("Il manque des paramètres. Tapez java -jar cli.jar -h pour de l'aide.");
					break;
			}
		}
		else {
			System.out.println("Il manque des paramètres. Tapez java -jar cli.jar -h pour de l'aide.");
			
			
		} 
			

	}
}

