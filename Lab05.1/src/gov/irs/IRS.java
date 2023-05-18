package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method for client to obtain the sole instance of the IRSEnum
    public static IRS getInstance(){
        return IRSEnum.INSTANCE;
    }
}
