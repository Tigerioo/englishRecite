package cn.minihand.englishRecite.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.minihand.englishRecite.model.Content;


public class XmlUtil {
	
	private Logger logger = Logger.getLogger(XmlUtil.class);
	
	/**
	 * 读取XML文件
	 * @param filePath
	 * @return 返回一个List
	 */
	public List<Content> readXml(String filePath){
		List<Content> contents = new ArrayList<Content>();
		Content content = null;
		
		Document document = this.getDocumentByFileName(filePath);
		Element root = document.getRootElement();
		
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			content = new Content();
			Element element = (Element)iterator.next();
			logger.info("begin read nodeElement...");
			for (Iterator iterator2 = element.elementIterator(); iterator2
					.hasNext();) {
				Element inner = (Element) iterator2.next();
				if("chinese".equals(inner.getName())){
					content.setChinese(inner.getText());
				}
				if("english".equals(inner.getName())){
					content.setEnglish(inner.getText());
				}
				if("voice".equals(inner.getName())){
					content.setVoice(inner.getText());
				}
				if("type".equals(inner.getName())){
					content.setType(inner.getText());
				}
				logger.info(inner.getName() + ":" + inner.getText() );
			}
		}
		contents.add(content); 
		return contents;
	}
	
	/**
	 * 
	 * @param fileName
	 * @param contents
	 * @return
	 */
	public boolean writeXml(String fileName, List<Content> contents){
		boolean rtn = false; //return value

		//get document
		logger.info("createXml begining...");
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("contents"); // root element
		
		// set content value
		for (Content content : contents) {
			Element single = root.addElement("content");
			logger.info("created element 'content'");
			
			Element chinese = single.addElement("chinese");
			chinese.setText(content.getChinese());
			logger.info("created element 'chinese' and value is " + content.getChinese());
			
			Element english = single.addElement("english");
			english.setText(content.getEnglish());
			logger.info("created element 'english' and value is " + content.getEnglish());
			
			Element voice = single.addElement("voice");
			voice.setText(content.getVoice());
			logger.info("created element 'voice' and value is " + content.getVoice());
			
			Element type = single.addElement("type");
			voice.setText(content.getType());
			logger.info("created element 'type' and value is " + content.getType());
			
			//get XML writer
			XMLWriter output ;
			//output format
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GBK");
			
			try {
				output = new XMLWriter(new FileWriter(fileName), format);
				output.write(document);
				output.close();
				rtn = true;
			} catch (IOException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}
		
        return rtn;
	}
	
	/**
	 * 
	 * @param fileName
	 * @param contents
	 * @return
	 */
	public boolean modifyXml(String fileName, List<Content> contents){
		boolean re = false;
		SAXReader reader = new SAXReader();
		
		try {
			Document document = reader.read(new File(fileName));
			
			// get root
			Element root = document.getRootElement();
			
			// set content value
			for (Content content : contents) {
				Element single = root.addElement("content");
				logger.info("created element 'content'");
				
				Element chinese = single.addElement("chinese");
				chinese.setText(content.getChinese());
				logger.info("created element 'chinese' and value is " + content.getChinese());
				
				Element english = single.addElement("english");
				english.setText(content.getEnglish());
				logger.info("created element 'english' and value is " + content.getEnglish());
				
				Element voice = single.addElement("voice");
				voice.setText(content.getVoice());
				logger.info("created element 'voice' and value is " + content.getVoice());
				
				Element type = single.addElement("type");
				type.setText(content.getType());
				logger.info("created element 'type' and value is " + content.getType());
				
				//get XML writer
				XMLWriter output ;
				//output format
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("GBK");
				
				try {
					output = new XMLWriter(new FileWriter(fileName), format);
					output.write(document);
					output.close();
					re = true;
				} catch (IOException e) {
					logger.error(e.toString());
					e.printStackTrace();
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return re;
	}

	private Document getDocumentByFileName(String fileName){
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	/*
	 * 递归查找,web.xml
	 */
	public String getValueByElementName(Element element, String elementName){
		logger.info("method getValueByElementName begin");
		logger.info("current element is " + element.getName());
		logger.info("will find the key is " + elementName);
		for (Iterator iterator = element.elementIterator(); iterator.hasNext();) {
			Element ele = (Element) iterator.next();
			if(elementName.equals(ele.getName())){
				return ele.getText();
			}
		}
		return "";
	}
	
	/**
	 * 从web.xml文件中取得spring配置文件的命名格式
	 * @return
	 */
	public String getWebXmlContent(){
		String xmlPaths = null;
		try {
			File[] files = FileSearch.getFiles("web.xml");
			String path = files[0].getCanonicalPath();
			Document document = this.getDocumentByFileName(path);
			Element root = document.getRootElement();
			logger.info("root size num is " + root.elements().size());
			for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				logger.info(root.getName() + "-->" + element.getName());
				if("context-param".equals(element.getName())){
					for (Iterator iterator2 = element.elementIterator(); iterator2
							.hasNext();) {
						Element element2 = (Element) iterator2.next();
						logger.info(root.getName() + "-->" + element.getName() + "-->" + element2.getName());
						String val1 = this.getValueByElementName(element, "param-name");
						logger.info(root.getName() + "-->" + element.getName() + "-->" + element2.getName() + " value is \"" + val1 + "\"");
						if("contextConfigLocation".equals(val1)){
							String val2 = this.getValueByElementName(element, "param-value");
							logger.info(root.getName() + "-->" + element.getName() + "-->" + element2.getName() + " value is \"" + val2 + "\"");
							if(!"".equals(val2)){
								return val2;
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return xmlPaths;
	}
	
	public static void main(String[] args) throws DocumentException {
		List<Content> contents;
		contents = new XmlUtil().readXml("./data/2011-5-27.xml");
		
		new XmlUtil().modifyXml("./data/2011.xml", contents);
		
		
	}
}
