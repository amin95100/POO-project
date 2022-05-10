package cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PathExplorer {
	
	/**
	 * Fonction Récurente Qui explore un path pour y retourner les chemins MP3 dans ce dossier et ces sous-dosssiers
	 * @param path
	 * @param ext
	 * @param mimeType
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> explorePath(String path, String ext, String mimeType) throws IOException {
		
		ArrayList<String> filePaths = new ArrayList<String>();
		File file = new File(path);
		
		if (file.exists()) {  
			
			if (file.isFile()) {
				
				// Get the extension of the file
				int index = path.lastIndexOf(".");
				String extensionFile = path.substring(index+1).toLowerCase();
				
				// Get the MIME
				String mimeFile = Files.probeContentType(file.toPath());
				
				if (extensionFile.equals(ext) && mimeType.equals(mimeFile))  {
					filePaths.add(file.getPath());					
				}
			} else {
				File[] directoryContent = file.listFiles();
				for (int i = 0; i < directoryContent.length; i++) {
					filePaths.addAll(this.explorePath(directoryContent[i].getPath(), ext, mimeType));					
				}
			}
			
		}	
		
		return filePaths;
	}
}
