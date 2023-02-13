function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  //if (!env) {
  //  env = 'dev';
  //}
  var config = {
    env: env,
    myVarName: 'someValue',
  //  appBaseURLJira:'https://santhposhaug.atlassian.net'
  }
  if (env == 'dev') {
    // customize
     config.appBaseURLJira="https://santhposhaug.atlassian.net";
  } else if (env == 'e2e') {
    config.appBaseURLJira="https://santhposhaug.atlassian.net-e2e";
  }
  return config;
}