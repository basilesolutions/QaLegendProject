package constants;

import java.io.File;

public class Constants {
	public static final String TESTDATA_EXCELPATH = "\\src\\test\\resources\\DataFile.xlsx";
	public static final String CONTACTUPLOAD_FILE = "\\src\\test\\resources\\Upload.csv";
	public static final String HOME_DIRECTORY = System.getProperty("user.dir");
	public static final String LOGIN_PAGE = "LoginScreen";
	public static final String RESET_PAGE = "ResetScreen";
	public static final String ADD_PAGE = "AddUser";
	public static final String UPLOAD_PAGE = "UploadScreen";
	public static final String REGISTER_PAGE = "RegisterPage";
	public static final String MAIL_DETAIL = "@gmail.com";
	public static final String DOT = ".";
	public static final String EXPECTED_MESSAGE_PREFIX = "Welcome";
	public static final String EXPECTED_MESSAGE_SUFFIX = ",";
	public static final String CONFIG_FILE = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "config.properties";
}
