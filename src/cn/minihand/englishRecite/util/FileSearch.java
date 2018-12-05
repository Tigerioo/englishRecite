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
	 * �ڱ��ļ����²���
	 * 
	 * @param s
	 *            String �ļ���
	 * @return File[] �ҵ����ļ�
	 */
	public static File[] getFiles(String s) {
		return getFiles(PropertiesUtil.userDir, s);
	}

	/**
	 * ��ȡ�ļ� ���Ը���������ʽ����
	 * 
	 * @param dir
	 *            String �ļ�������
	 * @param s
	 *            String �����ļ������ɴ�*.?����ģ����ѯ
	 * @return File[] �ҵ����ļ�
	 */
	public static File[] getFiles(String dir, String s) {
		// ��ʼ���ļ���
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
	 *            File ��ʼ�ļ���
	 * @param p
	 *            Pattern ƥ������
	 * @return ArrayList ���ļ����µ��ļ���
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
	 * ȥ���ظ����ļ���
	 * @param files
	 * @return
	 */
	public static ArrayList<File> getFileNames(String s){
		File[] tempFile = getFiles(s);
		int num = 0; // �����ظ���
		//List<File> files = new ArrayList<File>();
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0; i<tempFile.length; i++){
			files.add(tempFile[i]);
		}
		
		try {
			//ÿ��File����File[]�Ա�һ�飬�����ظ���2�����ϵģ��Ͳ��������
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file1 = (File) iterator.next();
				//file1��File2 �Ա�
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
