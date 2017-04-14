#### Required JDK   Java8

#### Install Dependencies

```bash
mvn install
```

#### Running all tests

```bash
mvn test 
```

#### Run tests based on TAG 
```bash
mvn test -Dcucumber.options="--tags @base" -Dtest.env='https://www.blinq.com' -Dtest.user='your_user'  -Dtest.pass='pass' -Dwebdriver.chrome.driver=src/test/resources/drivers/chromedriver_mac64 
```


