package com.developwiki.kuki.basic.utils;

import java.security.MessageDigest;

public class Md5Utils {
	
	/**
	 * ʮ�����������ֵ��ַ���ӳ������
	 */
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4",  
        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
 
    /**
     * ����
     * @param inputString ����
     * @return
     */
    public static String encodePassword(String inputString){
        return encodeByMD5(inputString);
    }
      
    /** 
     * ��֤����������Ƿ���ȷ
     * @param password ���ܺ������
     * @param inputString ������ַ���
     * @return TRUE:��ȷ FALSE:����
     */
    public static boolean validatePassword(String password, String inputString){
        if(password.equalsIgnoreCase(encodeByMD5(inputString))){
            return true;
        } else{
            return false;
        }
    }

    /**
     * ���ַ�������MD5����
     * @param originString ԭʼ�ַ���
     * @return
     */
    private static String encodeByMD5(String originString){
        if (null != originString){
            try{
                //��������ָ���㷨���Ƶ���ϢժҪ 
                MessageDigest md = MessageDigest.getInstance("MD5");
                //ʹ��ָ�����ֽ������ժҪ���������£�Ȼ�����ժҪ����  
                byte[] results = md.digest(originString.getBytes());
                //���õ����ֽ��������ַ������� 
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
      
    /**
     * ת���ֽ�����Ϊʮ�������ַ���
     * @param     �ֽ����� 
     * @return    ʮ�������ַ��� 
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    
    /** ��һ���ֽ�ת����ʮ��������ʽ���ַ���     */
    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0){
        	n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}
