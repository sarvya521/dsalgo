 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 *
 */
public class TriangulationCalcualtor extends Calculator<Object> {

    private static final String NATKEY_PREFIX = "FX";
    private static final String NATKEY_DELIM = "_";
    private static final String NATKEY_OUTPUT_PREFIX = "OUTPUT";

    private static final int NATKEY_OUTPUT_INDEX =  new StringBuilder(NATKEY_OUTPUT_PREFIX).append(NATKEY_DELIM).toString().length();

    private static final String NATKEY_ASK_KEY = "ASK";
    private static final String NATKEY_BID_KEY = "BID";
    private static final String NATKEY_MID_KEY = "MID";

    private static final String ROUNDING_PRECISION_KEY = "ROUNDING";

    private final Map<String, Map<String, Double>> inputCCYPairs = new HashMap<>();
    private final Map<String, Map<String, Double>> toTriangulateCCYPairs = new HashMap<>();

    private int roundingPrecision;

    private String validationErrorMessage = "";

    @Override
    public boolean validateParams(Map<String, ?> params) {
        if (!params.containsKey(ROUNDING_PRECISION_KEY)) {
            validationErrorMessage = "Invalid params, ROUNDING precision not specified in params.";
            return false;
        }
        roundingPrecision = (Integer) params.get(ROUNDING_PRECISION_KEY);

        inputCCYPairs.entrySet()
                .stream()
                .filter(e -> !(e.getValue().size() == 2
                        && e.getValue().containsKey(NATKEY_ASK_KEY)
                        && e.getValue().containsKey(NATKEY_BID_KEY)))
                .findFirst().ifPresent(e -> {
                    validationErrorMessage = "Incorrect input params for NatKey " + e.getKey();
                });
        if(!validationErrorMessage.isEmpty()) {
            return false;
        }

        toTriangulateCCYPairs.keySet()
                .stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String toTriangulateNatkey) {
                        String[] toCalculateNatkeyCCYPairs = toTriangulateNatkey.split(NATKEY_DELIM);
                        String CCY1 = toCalculateNatkeyCCYPairs[1];
                        String CCY2 = toCalculateNatkeyCCYPairs[2];

                        boolean containsCCY1 = inputCCYPairs.keySet().stream().anyMatch(e -> e.contains(CCY1));
                        boolean containsCCY2 = inputCCYPairs.keySet().stream().anyMatch(e -> e.contains(CCY2));
                        if (!(containsCCY1 && containsCCY2)) {
                            return true;
                        }
                        return false;
                    }
                })
                .findFirst()
                .ifPresent(toTriangulateNatkey -> {
                    validationErrorMessage = "No input Natkey's for the triangulation natkey  " + toTriangulateNatkey ;
                });
        if(!validationErrorMessage.isEmpty()) {
            return false;
        }
        return true;
    }

    private void deepCopyParams(Map<String, ?> params) {
        params.keySet()
                .forEach(key -> {
                    if (key.startsWith(NATKEY_OUTPUT_PREFIX)) {
                        Map<String, Double> bidAskMidRates = new HashMap<>();
                        bidAskMidRates.put(NATKEY_BID_KEY, 0.0);
                        bidAskMidRates.put(NATKEY_ASK_KEY, 0.0);
                        bidAskMidRates.put(NATKEY_MID_KEY, 0.0);
                        toTriangulateCCYPairs.put(key.substring(NATKEY_OUTPUT_INDEX), bidAskMidRates);
                    } else if (key.startsWith(NATKEY_PREFIX)) {
                        Map<String, Double> valueCopy = ((Map<String, Double>) params.get(key)).entrySet()
                                .stream()
                                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
                        inputCCYPairs.put(key, valueCopy);
                    }
                });
    }

    @Override
    public Map<String, Map<String, Double>> calculate(Map<String, ?> params) throws CalculationException {
        try {
            deepCopyParams(params);

            if (!validateParams(params)) throw new CalculationException( validationErrorMessage);

            toTriangulateCCYPairs.keySet()
                    .forEach(toTriangulateNatkey -> {
                        String[] toCalculateNatkeyCCYPairs = toTriangulateNatkey.split(NATKEY_DELIM);
                        String CCY1 = toCalculateNatkeyCCYPairs[1];
                        String CCY2 = toCalculateNatkeyCCYPairs[2];
                        String natKey1 = "";
                        String natKey2 = "";

                        Optional<String> result = inputCCYPairs.keySet()
                                .stream()
                                .filter(inputNatkey -> inputNatkey.contains(CCY1))
                                .findFirst();
                        if(result.isPresent()) {
                            natKey1 = result.get();
                        }

                        result = inputCCYPairs.keySet()
                                .stream()
                                .filter(inputNatkey -> inputNatkey.contains(CCY2))
                                .findFirst();
                        if(result.isPresent()) {
                            natKey2 = result.get();
                        }

                        String[] inputNatkey1 = natKey1.split(NATKEY_DELIM);
                        String[] inputNatkey2 = natKey2.split(NATKEY_DELIM);

                        //
                        if (inputNatkey1[1].equals(inputNatkey2[1])) {
                            String natkeyCCYa_CCYb = createNatkey(inputNatkey1[2], inputNatkey2[2]);
                            String natkeyCCYb_CCYa = createNatkey(inputNatkey2[2], inputNatkey1[2]);
                            CCY1IsUSDInBothPairs(natkeyCCYa_CCYb, natkeyCCYb_CCYa, natKey1, natKey2, toTriangulateNatkey);
                        }
                        if (inputNatkey1[2].equals(inputNatkey2[2])) {
                            String natkeyCCYa_CCYb = createNatkey(inputNatkey1[1], inputNatkey2[1]);
                            String natkeyCCYb_CCYa = createNatkey(inputNatkey2[1], inputNatkey1[1]);
                            CCY2IsUSDInBothPairs(natkeyCCYa_CCYb, natkeyCCYb_CCYa, natKey1, natKey2, toTriangulateNatkey);
                        }

                        if (inputNatkey1[2].equals(inputNatkey2[1]) || inputNatkey1[1].equals(inputNatkey2[2])) {
                            String natkeyCCYa_CCYb = createNatkey(inputNatkey1[1], inputNatkey2[2]);
                            String natkeyCCYb_CCYa = createNatkey(inputNatkey1[2], inputNatkey2[1]);
                            USDIsMixedInBothPairs(natkeyCCYa_CCYb, natkeyCCYb_CCYa, natKey1, natKey2, toTriangulateNatkey);
                        }
                    });

        } catch (Exception e) {
            throw new CalculationException("Exception in calculating Triangulation " + e.getMessage(), e);
        }

        return toTriangulateCCYPairs;
    }

    private void CCY1IsUSDInBothPairs(String natkeyCCYa_CCYb, String natkeyCCYb_CCYa, String natkey1, String natkey2, String toTriangulateNatkey) {
        if (natkeyCCYa_CCYb.equals(toTriangulateNatkey)) {
            double bid = inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY) / inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY);
            double ask = inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY) / inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY);
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask+bid)/2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        } else if (natkeyCCYb_CCYa.equals(toTriangulateNatkey)) {
            double bid = inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY) / inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY);
            double ask = inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY) / inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY);
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask+bid)/2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        }
    }

    private void CCY2IsUSDInBothPairs(String natkeyCCYa_CCYb, String natkeyCCYb_CCYa, String natkey1, String natkey2 , String toTriangulateNatkey) {
        if (natkeyCCYa_CCYb.equals(toTriangulateNatkey)) {
            double bid = inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY) / inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY);
            double ask = inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY) / inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY);
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask + bid) / 2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        } else if (natkeyCCYb_CCYa.equals(toTriangulateNatkey)) {
            double bid = inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY) / inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY);
            double ask = inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY) / inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY);
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask+bid)/2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        }

    }

    private void USDIsMixedInBothPairs(String natkeyCCYa_CCYb, String  natkeyCCYb_CCYa, String natkey1, String natkey2, String toTriangulateNatkey ) {
        if (natkeyCCYa_CCYb.equals(toTriangulateNatkey)) {
            double bid = inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY) * inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY);
            double ask = inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY) * inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY);
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask+bid)/2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        }
        if (natkeyCCYb_CCYa.equals(toTriangulateNatkey)) {
            double bid = 1 / (inputCCYPairs.get(natkey1).get(NATKEY_ASK_KEY) * inputCCYPairs.get(natkey2).get(NATKEY_ASK_KEY));
            double ask = 1 / (inputCCYPairs.get(natkey1).get(NATKEY_BID_KEY) * inputCCYPairs.get(natkey2).get(NATKEY_BID_KEY));
            Map<String, Double> triagulatedbidMidAskRates = toTriangulateCCYPairs.get(toTriangulateNatkey);
            triagulatedbidMidAskRates.put(NATKEY_BID_KEY, new BigDecimal(bid).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_ASK_KEY, new BigDecimal(ask).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
            triagulatedbidMidAskRates.put(NATKEY_MID_KEY, new BigDecimal((ask+bid)/2).setScale(roundingPrecision, RoundingMode.HALF_UP).doubleValue());
        }
    }

    private String createNatkey(String CCY1, String CCY2) {
        return new StringBuilder(NATKEY_PREFIX).append(NATKEY_DELIM).append(CCY1).append(NATKEY_DELIM).append(CCY2).toString();
    }
}
