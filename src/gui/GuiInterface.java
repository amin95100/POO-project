package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


import cli.PathExplorer;
import cli.PlaylistMaker;


import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 * @author SMARA Zakarie et DACOSTA Léa
 *
 */
public class GuiInterface {

	private JFrame frmGuiInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInterface window = new GuiInterface();
					window.frmGuiInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuiInterface = new JFrame();
		frmGuiInterface.setTitle("GUI Interface");
		frmGuiInterface.setBackground(Color.BLACK);
		frmGuiInterface.setBounds(100, 100, 521, 462);
		frmGuiInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmGuiInterface.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		list.setBounds(10, 110, 229, 305);
		panel.add(list);
		
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(263, 132, 234, 283);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Directory :");
		lblNewLabel_1.setBounds(10, 72, 68, 21);
		panel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 70, 368, 22);
		panel.add(textArea);
		
		JTextArea txtPlaylistName = new JTextArea();
		txtPlaylistName.setBounds(344, 26, 145, 22);
		panel.add(txtPlaylistName);
		
		JLabel lblNewLabel_2 = new JLabel("Playlist name :");
		lblNewLabel_2.setBounds(352, 3, 104, 29);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("RepertoireExplorer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textArea.getText();
				PathExplorer pathexplorer = new PathExplorer();		
				
				ArrayList<String> mp3Paths =null ;
				try {
					
					mp3Paths = pathexplorer.explorePath(s , "mp3", "audio/mpeg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				DefaultListModel DML = new DefaultListModel();
				
				for (Iterator iterator = mp3Paths.iterator(); iterator.hasNext();) {
					String mp3Path = (String) iterator.next();
					DML.addElement(mp3Path);
				}	
				
				list.setModel(DML);
				
			}
		});
		btnNewButton_1.setBounds(10, 28, 156, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GeneratePlaylist");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = textArea.getText();
				String playlistName = txtPlaylistName.getText();
				PathExplorer pathexplorer = new PathExplorer();		
				ArrayList<String> mp3Paths = null;
				try {
					mp3Paths = pathexplorer.explorePath(path, "mp3", "audio/mpeg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PlaylistMakerGui playlistmaker = new PlaylistMakerGui();
				// TODO Make an xspf file
				try {
					System.out.println(playlistmaker.mp3PlaylistMakerGui(mp3Paths,playlistName));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				}
		
		});
		
		btnNewButton_2.setBounds(176, 28, 158, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("MetaDataExtractor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MP3DataExtractorGui dataExtractor = new MP3DataExtractorGui();
				String s = textArea.getText();
				PathExplorer pathexplorer = new PathExplorer();		
				
				ArrayList<String> mp3Paths =null ;
				try {
					
					mp3Paths = pathexplorer.explorePath(s , "mp3", "audio/mpeg");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				lblNewLabel.setText( "<html>"+dataExtractor.mp3DataExtractorGui(mp3Paths.get(list.getSelectedIndex()))+"</html>");
				
				
					//C:\Users\Zakarie\Downloads
			}
			
		});
		btnNewButton.setBounds(263, 102, 226, 21);
		panel.add(btnNewButton);
		
	}
}
