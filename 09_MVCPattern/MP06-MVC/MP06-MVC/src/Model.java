public class Model {
    private enum STATES { STATE_0, STATE_LESS_500, STATE_500, STATE_LESS_1000, STATE_EQUAL_OR_MORE_1000};
    private STATES state;
    private int balance;
    private String msg;

    Model() {
        state = STATES.STATE_0;
        balance = 0;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getMsg() { return msg; }

    public void addHundred() {
        msg = "";
        balance += 100;
        if (state == STATES.STATE_0) {
            state = STATES.STATE_LESS_500;
        }
        else if (state == STATES.STATE_LESS_500) {
            if (balance == 500) {
                state = STATES.STATE_500;
            }
        }
        else if (state == STATES.STATE_500) {
            state = STATES.STATE_LESS_1000;
        }
        else if (state == STATES.STATE_LESS_1000) {
            if (balance == 1000) {
                state = STATES.STATE_EQUAL_OR_MORE_1000;
            }
        }
    }

    public void addFiveHundred() {
        msg = "";
        balance += 500;
        if (state == STATES.STATE_0) {
            state = STATES.STATE_500;
        }
        else if (state == STATES.STATE_LESS_500) {
            state = STATES.STATE_LESS_1000;
        }
        else if (state == STATES.STATE_500 || state == STATES.STATE_LESS_1000) {
            state = STATES.STATE_EQUAL_OR_MORE_1000;
        }
    }

    public void addThousand() {
        msg = "";
        balance += 1000;
        if (state == STATES.STATE_0 || state == STATES.STATE_LESS_500
                || state == STATES.STATE_500 || state == STATES.STATE_LESS_1000) {
            state = STATES.STATE_EQUAL_OR_MORE_1000;
        }
        else if (state == STATES.STATE_EQUAL_OR_MORE_1000) {
            msg = "이미 충분한 돈이 투입되었습니다. 음료를 선택하세요";
        }
    }

    public void returnChanges() {
        msg = "";
        if (state == STATES.STATE_LESS_500 || state == STATES.STATE_500 ||
                state == STATES.STATE_LESS_1000 || state == STATES.STATE_EQUAL_OR_MORE_1000) {
            state = STATES.STATE_0;
            msg = "" + balance + "원을 반환합니다";
            balance = 0;
        }
        else {
        }
    }

    public void selectBeverage() {
        if (state == STATES.STATE_EQUAL_OR_MORE_1000) {
            msg = "음료를 내보냅니다. 배출구를 확인하세요.";
            balance -= 1000;
            if (balance > 0) {
                msg = msg + " 거스름돈 " + balance + "원을 반환합니다.";
                balance = 0;
            }
            state = STATES.STATE_0;
        }
        else if (state == STATES.STATE_0) {
            msg = "돈을 넣은 후에 눌러주세요";
        }
        else {
            msg = "1000원 이상을 넣은 후에 눌러주세요";
        }
    }

}
