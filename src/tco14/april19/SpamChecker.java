package tco14.april19;

public class SpamChecker {

	public String spamCheck(String judgeLog, int good, int bad) {
		int score = 0;
		for(int i=0; i < judgeLog.length(); i++) {
			char ch = judgeLog.charAt(i);
			if(ch == 'o') {

				score += good;
			}
			else if(ch == 'x') {
				score -= bad;
			}
			if(score < 0) {
				return "SPAM";
			}
		}
		
		return "NOT SPAM";
	}
}
