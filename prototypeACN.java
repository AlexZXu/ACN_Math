public class ACN_1 {
	static class ACN {
		static int ALLOCATEDWHOLE, ALLOCATEDDECIMAL;
		static int [] WHOLE, DECIMAL;
		
		ACN (String num) {
			ALLOCATEDWHOLE = 1000;
			ALLOCATEDDECIMAL = 1000;
			
			WHOLE = new int [ALLOCATEDWHOLE];
			DECIMAL = new int [ALLOCATEDDECIMAL];
			
			try {
				setArrays(num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void setArrays (String num) throws Exception {
			boolean seenDot = false;
			int pointerA = 0;
			int pointerB = 0;
			for (int i = 0; i < num.length(); i++) {
				if (Character.isDigit(num.charAt(i))) {
					if (seenDot == false) {
						WHOLE [pointerA] = Integer.parseInt(num.charAt(i) + "");
						pointerA++;
					}
					else if (seenDot == true) {
						DECIMAL [pointerB] = Integer.parseInt(num.charAt(i) + "");
						pointerB++;
					}
					
				}
				else if (seenDot == false && num.charAt(i) == '.') {
					seenDot = true;
				}
				else if (seenDot == true && num.charAt(i) == '.') {
					throw new Exception ("Error in input: Input contains more than one decimal point");
				}
				
				else {
					throw new Exception ("Error in input: Input contains characters that are not digits");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ACN test = new ACN ("5.45.f");
	}

}
