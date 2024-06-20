package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {
	public static String encryptPassword(char[] password) {
        try {
            // Chuyển đổi mảng char[] thành chuỗi String
            String passwordString = new String(password);
            
            // Tạo một đối tượng MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Chuyển đổi chuỗi đầu vào thành mảng byte
            byte[] messageDigest = md.digest(passwordString.getBytes());
            
            // Chuyển đổi mảng byte thành đối tượng StringBuilder để chuyển đổi thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Xóa mật khẩu từ bộ nhớ
            Arrays.fill(password, '0');
            
            // Trả về chuỗi hex
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
