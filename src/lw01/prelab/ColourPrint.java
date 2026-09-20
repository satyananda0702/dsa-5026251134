package lw01.prelab;

public class ColourPrint extends PrintJob {
    private static final int FIRST_TEN_PRICE_PER_PAGE = 1500;
    private static final int ADDITIONAL_PRICE_PER_PAGE = 1000;
    private static final int SETUP_FEE = 2000;

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int firstTenPages = Math.min(getPages(), 10);
        int additionalPages = Math.max(getPages() - 10, 0);

        return firstTenPages * FIRST_TEN_PRICE_PER_PAGE
                + additionalPages * ADDITIONAL_PRICE_PER_PAGE
                + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Colour";
    }
}
