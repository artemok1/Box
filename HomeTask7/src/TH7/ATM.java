package TH7;

public class ATM {

	private String address;
	private String bank;

	private int num20;
	private int num50;
	private int num100;

	private IATM_UI listener;

	public ATM(int num20, int num50, int num100) {
		super();
		this.num20 = num20;
		this.num50 = num50;
		this.num100 = num100;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public void setNum20(int num20) {
		this.num20 = this.num20 + num20;

		if (this.listener != null) {
			this.listener.showSetNum20Message(num20);
		}
	}

	public void setNum50(int num50) {
		this.num50 = this.num50 + num50;

		if (this.listener != null) {
			this.listener.showSetNum50Message(num50);
		}
	}

	public void setNum100(int num100) {
		this.num100 = this.num100 + num100;

		if (this.listener != null) {
			this.listener.showSetNum100Message(num100);
		}
	}

	public boolean getMoney(int sum) {
		if (sum % 20 != 0 && sum % 50 != 0) {

			if (this.listener != null) {
				this.listener
						.showGetMoneyMessage("The ammount of mone should be 20 fold or 50 fold");
			}

			return false;
		}

		int sumInt = this.num100 * 100 + this.num50 * 50 + this.num20 * 20;

		if (sumInt == 0) {
			if (this.listener != null) {
				this.listener.showGetMoneyMessage("ATM is empty");
			}

			return true;
		}

		if (sum > sumInt) {
			if (this.listener != null) {
				this.listener.showGetMoneyMessage("ATM does not have " + sum
						+ " y.e. The ammount of mone should be less or equal "
						+ sumInt + " y.e.");
			}

			return false;
		}

		int s100 = 0;

		// get number of "100" reqired
		if (this.num100 > 0) {
			s100 = sum / 100;

			if (s100 > this.num100) {
				s100 = this.num100;
			}

			sum = sum - 100 * s100;
		}

		int s50 = 0;

		// get number of "50" reqired
		if (this.num50 > 0 && sum != 0) {
			s50 = sum / 50;

			if (s50 > this.num50) {
				s50 = this.num50;
			}

			sum = sum - 50 * s50;
		}

		int s20 = 0;

		// get number of "20" reqired
		if (this.num20 > 0 && sum != 0) {
			s20 = sum / 20;

			if (s20 > this.num20) {
				s20 = this.num20;
			}

			sum = sum - 20 * s20;
		}

		if (sum > 0) {
			if (this.listener != null) {
				this.listener
						.showGetMoneyMessage("Try another sum, the give sum could not be reached");
			}

			return false;
		}

		if (s100 != 0) {
			if (this.listener != null) {
				this.listener.showGetMoneyMessage(s100
						+ " of 100 y.e. were given to you");
			}

		}

		if (s50 != 0) {
			if (this.listener != null) {
				this.listener.showGetMoneyMessage(s50
						+ " of 50 y.e. were given to you");
			}
		}

		if (s20 != 0) {
			if (this.listener != null) {
				this.listener.showGetMoneyMessage(s20
						+ " of 20 y.e. were given to you");
			}

		}

		this.num100 = this.num100 - s100;
		this.num50 = this.num50 - s50;
		this.num20 = this.num20 - s20;

		return true;

	}

	public void setListener(IATM_UI listener) {
		this.listener = listener;
	}
}
