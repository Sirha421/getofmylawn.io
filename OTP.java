{
	String customerKey = "147994";
	String apiKey = "4o905obwBz8GPbDQgPEJdnzBCzDmo1wA";
	String currentTimeInMissis = String.valueOf(system.currentTimeMillis());
	String stringToHash = customerKey + currentTimeInMillis + apiKey;
	String hashValue = new Sha512Hash(stringToHash).toHex().toLowerCase();
	HttpPost postRequest = new HttpPost("");
	postRequest.setHeader("Customer-Key", customerKey);
	postRequest.setHeader("Timestamp", currentTimeInMillis);
	postRequest.setHeader("Authorization", hashValue)
}