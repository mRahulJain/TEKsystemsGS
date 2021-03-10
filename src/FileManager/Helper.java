package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Helper {

	static int char_num = 256;
	
	public void getListOfFiles(File mDir) throws FileNotFoundException {
		File[] reqList = mDir.listFiles();

		Arrays.sort(reqList, new Comparator<File>() {
			@Override
			public int compare(File arg0, File arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		});

		print("Directory has "+ reqList.length +" files!");
		System.out.println("----------------LIST------------------");
		for (File file : reqList) {
			System.out.println(file.getName());
		}
		System.out.println("--------------------------------------");
	}

	public void createFile(File mDir) throws IOException {
		if (mDir.createNewFile()) {
			print("File Created!");
		} else {
			print("File Already Exists!");
		}
	}

	public void deleteFile(File mDir) throws IOException {
		if (mDir.delete()) {
			print("File Deleted!");
		} else {
			print("File do not exist!");
		}
	}

	public void searchFile(String fileName, File mDir) {
		File[] files = mDir.listFiles();
		List<String> list = new ArrayList<String>();
		
		for(File file : files) {
			if(search(file.getName(), fileName)) {
				list.add(file.getName());
			}
		}
		
		if(list.isEmpty()) {
			System.out.println("No such file exists!");
			return;
		}
		
		print(list.size()+" files contains %"+ fileName +"%");
		System.out.println("------------SEARCH-LIST---------------");
		int i = 1;
		for (String str : list) {
			System.out.print((i++) +". ");
			System.out.println(str);
		}
		System.out.println("--------------------------------------");
	}
	
	static private int max(int a, int b) {
		if(a > b) {
			return a;
		}
		return b;
	}

	static private void badCharHeuristic(char[] str, int size, int badchar[]) {
		int i;
		for (i = 0; i < char_num; i++)
			badchar[i] = -1;
		for (i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	static private boolean search(String a, String b) {
		char[] txt = a.toCharArray();
		char[] pat = b.toCharArray();
		int m = pat.length;
		int n = txt.length;
		int badchar[] = new int[char_num];
		badCharHeuristic(pat, m, badchar);
		int s = 0;
		while (s <= (n - m)) {
			int j = m - 1;
			while (j >= 0 && pat[j] == txt[s + j])
				j--;
			if (j < 0) {
				return true;
			}
			else {
				s += max(1, j - badchar[txt[s + j]]);
			}		
		}
		
		return false;
	}
	
	static private void print(String message) {
		System.out.println();
		System.out.println(message);
		System.out.println();
	}
}
