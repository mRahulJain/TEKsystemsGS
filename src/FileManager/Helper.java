package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	
	public void createFile(File mDir) throws IOException {
		if(mDir.createNewFile()) {
			System.out.println("File Created!");
		} else {
			System.out.println("File Already Exists!");
		}
	}
	
	public void deleteFile(File mDir) throws IOException {
		if(mDir.delete()) {
			System.out.println("File Deleted!");
		} else {
			System.out.println("File do not exist!");
		}
	}
}
