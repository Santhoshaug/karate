function fn(args) {
	var XmlValidator = Java.type('com.api.test.helper.XmlValidator');
	var verify = new XmlValidator(args._xmlcontent.toString());
	var result = verify.isTagPresent(args._xpath.toString());
	return result;
}