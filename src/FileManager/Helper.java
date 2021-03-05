package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Helper {
	
	public void getListOfFiles(File mDir) throws FileNotFoundException {
		File[] reqList = mDir.listFiles();
		
		Arrays.sort(reqList, new Comparator<File>() {
			@Override
			public int compare(File arg0, File arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		});
		
		System.out.println("------------------List-------------------");
		for(File file : reqList) {
			System.out.println(file.getName());
		}
		System.out.println("-----------------------------------------");
	}

}
