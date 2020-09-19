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
formatter.result({
  "duration": 5861097521,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://admin-demo.nopcommerce.com/",
      "offset": 28
    }
  ],
  "location": "Test_Steps.open_login_page_with_URL(String)"
});
formatter.result({
  "duration": 3614807807,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Test login page header",
  "description": "",
  "id": "login-test;test-login-page-header",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "verify login page header",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Test_Steps.verify_login_page_header()"
});
formatter.result({
  "duration": 88367042,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.close_browser()"
});
formatter.result({
  "duration": 1803458952,
  "status": "passed"
});
formatter.after({
  "duration": 9938469,
  "status": "passed"
});
});