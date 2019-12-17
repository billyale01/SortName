package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WordsList {
	
	public static void main(String[] args) {
		ArrayList<String> words = readFromFile("unsorted-names-list.txt");
		System.out.println(Arrays.toString(words.toArray()));
		WordsList i = new WordsList();
		i.sortLast(words);
		saveToFile("sorted-names-list.txt",words);
	}
	
	public static ArrayList readFromFile(String fileName) {
		ArrayList<String> myList = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNextLine()) {
				myList.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return myList;
	}
	
	public static void saveToFile(String fileName, ArrayList list) {
		Path filePath = Paths.get(fileName);
		try {
		Files.write(filePath, list, Charset.defaultCharset());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
		public void sortLast(ArrayList<String> words) {
			Collections.sort(words, new Comparator<String>(){
				public int compare(String o1, String o2) {
					String[] split1 = o1.split(" ");
					String[] split2 = o2.split(" ");
					int i = 1;
					while(split1[split1.length-i].equals(split2[split2.length-i]))
					{
						i+=1;
					}
					String lastName1 = split1[split1.length-i];
					String lastName2 = split2[split2.length-i];
					if(lastName1.compareTo(lastName2) > 0) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			System.out.println(words);
		}
}
