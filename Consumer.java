/**
 * Credit calculator v2
 */

public class Consumer {
    private double mSum; //тело кредита
    private double mMthPaid; //ежемесячный платеж
    private double mPctRate; //процентная ставка
    private double mOvrPaid; // размер переплаты
    private double mSumOfFstOvPaid; // сумма с которой начисляются проценты

    public double getOvrPaid() {
        if (isAblToPay(this.mSumOfFstOvPaid, this.mMthPaid, this.mPctRate)) {

            while (mSumOfFstOvPaid > 0) {
                mOvrPaid = mOvrPaid + (mSumOfFstOvPaid * (mPctRate * 0.01));
                mSumOfFstOvPaid = mSumOfFstOvPaid + (mSumOfFstOvPaid * (mPctRate * 0.01)) - (mMthPaid * 12.);
            }
        }
        else {
            System.exit(1);
        }
        return mOvrPaid;
    }
    public void fillClntData(String[] sClntData){
        try {
            this.mSum = Double.parseDouble(sClntData[0]);
            this.mMthPaid = Double.parseDouble(sClntData[1]);
            this.mPctRate = Double.parseDouble(sClntData[2]);
            if (sClntData[3].equals("human")) {
                this.mSumOfFstOvPaid = mSum;
            }
            else if (sClntData[3].equals("business")) {
                this.mSumOfFstOvPaid = (mSum - (mMthPaid * 12));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Не правильно введены данные" + e);
            System.exit(1);
        }
    }

    public static boolean isAblToPay(double sumOfFstOvPaid, double mMnthPaid, double mPctRate)
    {
        return (sumOfFstOvPaid > 0 && mMnthPaid > 0
                && (sumOfFstOvPaid * (mPctRate / 100.) <= (mMnthPaid * 12.)));
    }
}