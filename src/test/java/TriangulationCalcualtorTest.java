 
import org.junit.Test;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TriangulationCalcualtorTest {

    private static Map<String, Object> intNatKeys;

    @Before
    public void setUp() throws Exception {
        intNatKeys = new HashMap<>();
        intNatKeys.put("ROUNDING", 6);
        Map<String, Double> bidAskFxRates = new HashMap<String, Double>();
        bidAskFxRates.put("BID", 7.8354);
        bidAskFxRates.put("ASK", 7.8359);
        intNatKeys.put("FX_USD_HKD", bidAskFxRates);
        bidAskFxRates = new HashMap<String, Double>();
        bidAskFxRates.put("BID", 6.5866);
        bidAskFxRates.put("ASK", 6.5875);
        intNatKeys.put("FX_USD_DKK", bidAskFxRates);
        bidAskFxRates = new HashMap<String, Double>();
        bidAskFxRates.put("BID", 1.1370);
        bidAskFxRates.put("ASK", 1.1371);
        intNatKeys.put("FX_EUR_USD", bidAskFxRates);
        bidAskFxRates = new HashMap<String, Double>();
        bidAskFxRates.put("BID", 1.2586);
        bidAskFxRates.put("ASK", 1.2590);
        intNatKeys.put("FX_GBP_USD", bidAskFxRates);
        bidAskFxRates = new HashMap<String, Double>();
        bidAskFxRates.put("BID", 0.9888);
        bidAskFxRates.put("ASK", 0.9891);
        intNatKeys.put("FX_USD_CHF", bidAskFxRates);

//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 6.5866);
//        bidAskFxRates.put("ASK", 6.5875);
//        intNatKeys.put("FX_USD_ZAR", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_TWD", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.2586);
//        bidAskFxRates.put("ASK", 1.2590);
//        intNatKeys.put("FX_USD_SGD", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_SEK", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 0.9888);
//        bidAskFxRates.put("ASK", 0.9891);
//        intNatKeys.put("FX_USD_PLN", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 6.5866);
//        bidAskFxRates.put("ASK", 6.5875);
//        intNatKeys.put("FX_USD_NOK", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_MXN", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.2586);
//        bidAskFxRates.put("ASK", 1.2590);
//        intNatKeys.put("FX_USD_KRW", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_JPY", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 0.9888);
//        bidAskFxRates.put("ASK", 0.9891);
//        intNatKeys.put("FX_USD_INR", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 6.5866);
//        bidAskFxRates.put("ASK", 6.5875);
//        intNatKeys.put("FX_USD_HUF", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_CZK", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.2586);
//        bidAskFxRates.put("ASK", 1.2590);
//        intNatKeys.put("FX_USD_COP", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_CNY", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 0.9888);
//        bidAskFxRates.put("ASK", 0.9891);
//        intNatKeys.put("FX_USD_CLP", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 6.5866);
//        bidAskFxRates.put("ASK", 6.5875);
//        intNatKeys.put("FX_USD_CAD", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_USD_BRL", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.2586);
//        bidAskFxRates.put("ASK", 1.2590);
//        intNatKeys.put("FX_NZD_USD", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 1.1370);
//        bidAskFxRates.put("ASK", 1.1371);
//        intNatKeys.put("FX_AUD_USD", bidAskFxRates);
//        bidAskFxRates = new HashMap<String, Double>();
//        bidAskFxRates.put("BID", 0.9888);
//        bidAskFxRates.put("ASK", 0.9891);
//        intNatKeys.put("FX_USD_THB", bidAskFxRates);


        Map<String, Double> bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_EUR_CHF", bidMidAskFxRates);

        bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_CHF_EUR", bidMidAskFxRates);

        bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_HKD_DKK", bidMidAskFxRates);

        bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_DKK_HKD", bidMidAskFxRates);

        bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_EUR_GBP", bidMidAskFxRates);

        bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_GBP_EUR", bidMidAskFxRates);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void validateParamsTest() {
        assertTrue(new TriangulationCalcualtor().validateParams(intNatKeys));
    }

    @Test
    public void validateShouldThrowExceptionIfRoundigIsNotSpecifiedTest() throws CalculationException {
        intNatKeys.remove("ROUNDING");
        expectedException.expect(CalculationException.class);
        expectedException.expectMessage("Invalid params, ROUNDING precision not specified in params");
        new TriangulationCalcualtor().calculate(intNatKeys);
    }

    @Test
    public void validateShouldThrowExceptionIfFXRatesNotSpecifiedTest() throws CalculationException {
        Map<String, Double> stringDoubleHashMap6 = new HashMap<String, Double>();
        stringDoubleHashMap6.put("BID", 0.9888);
        intNatKeys.put("FX_USD_CHF", stringDoubleHashMap6);

        expectedException.expect(CalculationException.class);
        expectedException.expectMessage("Incorrect input params for NatKey ");
        new TriangulationCalcualtor().calculate(intNatKeys);
    }

    @Test
    public void validateShouldThrowExceptionIfNatkeysNotSpecifiedForTriangulationNatKeyTest() throws CalculationException {
        Map<String, Double> bidMidAskFxRates = new HashMap<String, Double>();
        bidMidAskFxRates.put("BID", 0.0);
        bidMidAskFxRates.put("MID", 0.0);
        bidMidAskFxRates.put("ASK", 0.0);
        intNatKeys.put("OUTPUT_FX_USD_ISK", bidMidAskFxRates);

        expectedException.expect(CalculationException.class);
        expectedException.expectMessage("No input Natkey's for the triangulation natkey ");
        new TriangulationCalcualtor().calculate(intNatKeys);
    }


    @Test
    public void calculateTriangulation() {
        try {
            Map<String, Map<String, Double>> triangualtedFXPairs = new TriangulationCalcualtor().calculate(intNatKeys);

            assertEquals(0.8406, triangualtedFXPairs.get("FX_HKD_DKK").get("BID"), 0.001);
            assertEquals(0.8407, triangualtedFXPairs.get("FX_HKD_DKK").get("ASK"), 0.001);

            assertEquals(1.1894, triangualtedFXPairs.get("FX_DKK_HKD").get("BID"), 0.001);
            assertEquals(1.1897, triangualtedFXPairs.get("FX_DKK_HKD").get("ASK"), 0.001);

            assertEquals(0.9031, triangualtedFXPairs.get("FX_EUR_GBP").get("BID"), 0.001);
            assertEquals(0.9035, triangualtedFXPairs.get("FX_EUR_GBP").get("ASK"), 0.001);

            assertEquals(1.1068, triangualtedFXPairs.get("FX_GBP_EUR").get("BID"), 0.001);
            assertEquals(1.1073, triangualtedFXPairs.get("FX_GBP_EUR").get("ASK"), 0.001);

            assertEquals(1.1243, triangualtedFXPairs.get("FX_EUR_CHF").get("BID"), 0.001);
            assertEquals(1.1247, triangualtedFXPairs.get("FX_EUR_CHF").get("ASK"), 0.001);

            assertEquals(0.8891, triangualtedFXPairs.get("FX_CHF_EUR").get("BID"), 0.001);
            assertEquals(0.8894, triangualtedFXPairs.get("FX_CHF_EUR").get("ASK"), 0.001);

        } catch (CalculationException e) {
            Assert.fail("Triangulation failed " + e.getMessage());
        }
    }

}