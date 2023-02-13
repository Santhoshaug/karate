function fn(args) {
	var XmlValidator = Java.type('com.api.test.helper.XmlValidator');
	var verify = new XmlValidator(args._xmlcontent.toString());
	var result = verify.isValuePresent(args._xpath.toString(),
			args._expectedValue.toString());
	return result;
}
