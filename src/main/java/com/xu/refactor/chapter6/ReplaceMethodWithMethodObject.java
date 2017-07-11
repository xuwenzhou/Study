package com.xu.refactor.chapter6;

/**
 * 以函数对象取代函数-存在大型函数，其中对局部变量的使用导致无法使用抽取函数
 * @author 39767
 *
 */
public class ReplaceMethodWithMethodObject {
	
	class Account{
		int gamma(int inputVal, int quantity, int yearToDate){
			int importantValue1 = (inputVal * quantity) + delta();
			int importantValue2 = (inputVal * yearToDate) + 100;
			if(yearToDate - importantValue1 > 100)
				importantValue2 -= 20;
			int importantValue3 = importantValue2 * 7;
			return importantValue3 - 2 * importantValue1;
		}
		
		int gamma_R(int inputVal, int quantity, int yearToDate){
			return new Accout_R(this, inputVal, quantity, yearToDate).gamma();
		}
		
		private int delta(){
			return 0;
		}
	}
	
	private static class Accout_R{
		private final Account account;
		private int inputVal;
		private int quantity;
		private int yearToDate;
		private int importantValue1;
		private int importantValue2;
		private int importantValue3;
		
		public Accout_R(Account account, int inputVal, int quantity, int yearToDate){
			this.account = account;
			this.inputVal = inputVal;
			this.quantity = quantity;
			this.yearToDate = yearToDate;
		}
		
		int gamma(){
			importantValue1 = (inputVal * quantity) + account.delta();
			importantValue2 = (inputVal * yearToDate) + 100;
			if(yearToDate - importantValue1 > 100)
				importantValue2 -= 20;
			importantValue3 = importantValue2 * 7;
			return importantValue3 - 2 * importantValue1;
		}
	}
	
}
