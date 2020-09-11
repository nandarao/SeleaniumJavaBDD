$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Nopcommerce.feature");
formatter.feature({
  "line": 1,
  "name": "login Test",
  "description": "",
  "id": "login-test",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "Resuable code",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Launch the \"FF\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "open login page with URL : \"https://admin-demo.nopcommerce.com/\"",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "FF",
      "offset": 12
    }
  ],
  "location": "Test_Steps.launch_the_browser(String)"
});
