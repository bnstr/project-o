# JDK   Java8

# Dependencies


## Install Dependencies

```bash
mvn install
```


# Running all tests

```bash
mvn test 
```

# Run tests based on TAG 
```bash
mvn test -Dcucumber.options="--tags @featureX" -Dtest.env='https://www.blinq.com' -Dtest.user='your_user'  -Dtest.pass='pass'
```

# Running with Chrome


```bash
mvn test -Dcucumber.options="--tags @featureX" -Dwebdriver.chrome.driver=src/test/resources/drivers/chromedriver_mac64 




