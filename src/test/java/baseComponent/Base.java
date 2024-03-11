//ublic class BaseTest {
//
//    public WebDriver driver;
//    public LandingPage landingPage;
//
//    public WebDriver initializeDriver() throws IOException
//
//    {
//        // properties class
//
//        Properties prop = new Properties();
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//                + "//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
//        prop.load(fis);
//
//        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
//        //prop.getProperty("browser");
//
//        if (browserName.contains("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            WebDriverManager.chromedriver().setup();
//            if(browserName.contains("headless")){
//                options.addArguments("--headless");
//                driver = new ChromeDriver(options);
//            }
//            driver = new ChromeDriver();
//            //driver.manage().window().setSize(new Dimension(1440,900));//full screen
//
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver",
//                    "/Users/rahulshetty//documents//geckodriver");
//            driver = new FirefoxDriver();
//            // Firefox
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            // Edge
//            System.setProperty("webdriver.edge.driver", "edge.exe");
//            driver = new EdgeDriver();
//        }
//
//        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //driver.manage().window().maximize();
//        return driver;
//
//    }
//
//    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
//    {
//        //read json to string
//        String jsonContent = 	FileUtils.readFileToString(new File(filePath),
//                StandardCharsets.UTF_8);
//
//        //String to HashMap- Jackson Databind
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
//        });
//        return data;
//
//        //{map, map}
//
//    }
//
//    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
//    {
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
//        FileUtils.copyFile(source, file);
//        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
//    }
//
//    @BeforeMethod(alwaysRun=true)
//    public LandingPage launchApplication() throws IOException
//    {
////		driver = initializeDriver();
////		landingPage = new LandingPage(driver);
////		landingPage.goTo();
////		return landingPage;
//        driver = initializeDriver();
//        if (driver != null) {
//            landingPage = new LandingPage(driver);
//            landingPage.goTo();
//            return landingPage;
//        }
//        // Handle the case when driver initialization fails
//        return null;
//    }
//
//    @AfterMethod(alwaysRun=true)
//    public void tearDown()
//    {
//        if (driver != null) {
//            driver.close();
//        }
//    }
//}