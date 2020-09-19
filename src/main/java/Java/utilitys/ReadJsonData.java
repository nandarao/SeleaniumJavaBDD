package Java.utilitys;

public class ReadJsonData {
	/*private ReadConfigFile readConfigFile;
	
	private  String filePath = readConfigFile.getTestDataPath()+"TestData.json";
	
	private List<LoginVeriablesData> loginValues;
	
	public ReadJsonData () {
		loginValues = getLoginData();
	}

	private List<LoginVeriablesData> getLoginData() {
		
		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			LoginVeriablesData[] loginVeriablesDatas = gson.fromJson(bufferedReader, LoginVeriablesData[].class);
			return Arrays.asList(loginVeriablesDatas);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + filePath);
		}
		
	finally {
		try {
			
			if(bufferedReader != null) bufferedReader.close();}
		catch (IOException ignore) {}
	}
	}
	
	public final LoginVeriablesData getLoginData(String value) {
		
		for (LoginVeriablesData loginVeriablesData : loginValues) {
			if (loginVeriablesData.userID.equalsIgnoreCase(value)) {
				return loginVeriablesData;
				
			}
			
		}
		return null;
		
//		return loginValues.stream().filter(X->X.userID.equalsIgnoreCase(value)).findAny().get();
	}
	*/
	

	

}
