package cn.minihand.englishRecite.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearch {
	public FileSearch() {
	}

	/**
	 * 在本文件夹下查找
	 * 
	 * @param s
	 *            String 文件名
	 * @return File[] 找到的文件
	 */
	public static File[] getFiles(String s) {
		return getFiles(PropertiesUtil.userDir, s);
	}

	/**
	 * 获取文件 可以根据正则表达式查找
	 * 
	 * @param dir
	 *            String 文件夹名称
	 * @param s
	 *            String 查找文件名，可带*.?进行模糊查询
	 * @return File[] 找到的文件
	 */
	public static File[] getFiles(String dir, String s) {
		// 开始的文件夹
		File file = new File(dir);
		try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = s.replace('.', '#');
		s = s.replaceAll("#", "\\\\.");
		s = s.replace('*', '#');
		s = s.replaceAll("#", ".*");
		s = s.replace('?', '#');
		s = s.replaceAll("#", ".?");
		s = "^" + s + "$";

		System.out.println(s);
		Pattern p = Pattern.compile(s);
		ArrayList list = filePattern(file, p);

		File[] rtn = new File[list.size()];
		list.toArray(rtn);
		return rtn;
	}

	/**
	 * @param file
	 *            File 起始文件夹
	 * @param p
	 *            Pattern 匹配类型
	 * @return ArrayList 其文件夹下的文件夹
	 */

	private static ArrayList filePattern(File file, Pattern p) {
		if (file == null) {
			return null;
		} else if (file.isFile()) {
			Matcher fMatcher = p.matcher(file.getName());
			if (fMatcher.matches()) {
				ArrayList list = new ArrayList();
				list.add(file);
				return list;
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				ArrayList list = new ArrayList();
				for (int i = 0; i < files.length; i++) {
					ArrayList rlist = filePattern(files[i], p);
					if (rlist != null) {
						list.addAll(rlist);
					}
				}
				return list;
			}
		}
		return null;
	}

	public ArrayList parseWebXml(){
		ArrayList<String> fileNames = new ArrayList<String>();
		String webXmlName = getFiles("web.xml")[0].getName();
		
		
		return  fileNames;
	}
	
	/**
	 * 去除重复的文件名
	 * @param files
	 * @return
	 */
	public static ArrayList<File> getFileNames(String s){
		File[] tempFile = getFiles(s);
		int num = 0; // 计算重复数
		//List<File> files = new ArrayList<File>();
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0; i<tempFile.length; i++){
			files.add(tempFile[i]);
		}
		
		try {
			//每个File都和File[]对比一遍，发现重复在2个以上的，就不加入这个
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file1 = (File) iterator.next();
				//file1和File2 对比
				for (Iterator iterator2 = files.iterator(); iterator2.hasNext();) {
					File file2 = (File) iterator2.next();
					if(file1.getCanonicalFile().equals(file2.getCanonicalPath())){
						num++;
					}
					if(num > 1){
						files.remove(file1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return files;
	}
}
